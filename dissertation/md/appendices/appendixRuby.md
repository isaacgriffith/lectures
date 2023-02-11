\chapter{Data Collection Ruby Script}\label{chap:appruby}

\begin{singlespace}
\begin{lstlisting}[language=Ruby]
require 'rubygems'
require 'uri'
require 'nokogiri'
require 'open-uri'
require 'net/http'
require 'mechanize'
require 'find'
require 'pathname'

module SFExtract
  # Data Class representing a project
  class Project
    attr_accessor :url, :language
    attr_reader :name, :id, :versions, :subprojects, :parent

    private
    @@nextID = 0

    public
    def initialize(name, language, project = nil)
      @name = name
      @parent = project
      @language = language
      @versions = Array.new
      @instances = Array.new
      @id = @@nextID
      @@nextID += 1
      @subprojects = Array.new
    end

    def addVersion(version)
      unless @versions.include?(version)
        @versions << version
      end
    end

    def remVersion(version)
      if @versions.include?(version)
        @versions.delete(version)
      end
    end

    def addInstance(instance)
      unless @instances.include?(instance)
        @instances << instance
      end
    end

    def remInstance(instance)
      if @instances.include?(instance)
        @instances.delete(instance)
      end
    end

    def addSubProject(project)
      unless @subprojects.include?(project)
        @subprojects << project
      end
    end

    def remSubProject(project)
      if @subprojects.include?(project)
        @subprojects.delete(project)
      end
    end
  end

  # Data class representing a file link
  class FileLink
    attr_accessor :name, :url
    attr_reader :version
    def initialize(name, version)
      @name = name
      @version = version
    end
  end

  # Data class representing a Version
  class Version
    attr_accessor :name, :url, :location
    attr_reader :project
    def initialize(name, project)
      @name = name
      @project = project
      @fileLinks = Array.new
    end

    def addFileLink(link)
      unless @fileLinks.include? link
        @fileLinks << link
      end
    end

    def remFileLink(link)
      if @fileLinks.include?(link)
        @fileLinks.delete(link)
      end
    end
  end

  # Creates the directory structure for a project
  class DirectoryCreator
    def initialize()
      
    end

    def run(baseDir, version)
      name = version.project.name
      ver = version.name
      location = genDirString(version, "").prepend("#{baseDir}/")
      FileUtils::mkdir_p "#{location}/src"
      FileUtils::mkdir_p "#{location}/test"
      version.location=("#{location}/")
    end

    private

    def genDirString(object, location)
      location.prepend("#{object.name}/")
      if (object.is_a?(Version))
        genDirString(object.project, location)
      elsif (object.is_a?(Project))
        genDirString(object.parent, location) unless object.parent == nil
      end

      return location
    end
  end

  # Identifies versions of each project
  class VersionIdentifier
    def initialize()

    end

    def run(project)
      projURL = project.url()
      versions = Array.new()
      recurseFolders(project, projURL, versions)
      return versions
    end

    private

    def recurseFolders(project, url, versions)
      total = 0
      doc = Nokogiri::HTML(open(url))
      doc.xpath('//tr[@class="folder "]//th[@headers="files_name_h"]//a').each do |node|
        folderName = node.text.strip!
        if (node['href'].start_with?('http://sourceforge.net'))
          folderURL = node['href']
        else
          folderURL = "http://sourceforge.net" + node['href']
        end
        folerName = URI.unescape(folderName)
        unless folderName.scan(/^\D+(\d)\D+(\d)/).empty? then
          version = Version.new(folderName, project)
          version.url=(folderURL)
          versions << version
        else
          sub = Project.new(folderName,project.language,project)
          sub.url = folderURL
          project.addSubProject(sub)
          recurseFolders(sub, folderURL, versions)
        end
      end
    end
  end

  # Downloads Version files to appropriate location
  class FileDownloader
    def initialize()
      
    end

    def run(version)
      files = Hash.new
      doc = Nokogiri::HTML(open(version.url))
      doc.xpath('//tr//a[@class="name"]').each do |node|
        location = version.location
        fileName = node.text
        fileName.strip!
        fileURL = node['href'].split("/download")[0] + "?use_mirror=autoselect"
        if fileName.include?(".zip") || fileName.include?(".bz2") || fileName.include?(".tgz") || fileName.include?(".gz") || fileName.include?(".jar") || fileName.include?(".7z") || fileName.include?(".Z") then
          agent = Mechanize.new { |a| a.follow_meta_refresh = true }
          agent.pluggable_parser.default = Mechanize::Download
          agent.get(fileURL).save(location + fileName) unless File.exists?(location + fileName)
        end
      end
      return files
    end
  end

  # Reads Project Search terms from file or STDIN
  class ProjectReader
    def initialize()
      
    end

    def run(fileName)
      list = Array.new
      File.open(fileName, "r") do |file|
        while line = file.gets
          line.strip!
          list.push(line)
        end
      end
      return list
    end
  end

  # Finds Projects on SourceForge
  class ProjectFinder
    def initialize()
      
    end

    def run(projName,lang)
      list = Array.new
      projName.tr!('_',' ')
      projName = URI.escape(projName)
      doc = Nokogiri::HTML(open("http://sourceforge.net/directory/language:java/?q=#{projName}"))
      doc.xpath('//div[@class = "project_info"]//a').each do |node|
        list.insert(-1,'http://sourceforge.net' + node["href"].to_s.split('?')[0] + 'files')
      end
      
      project = Project.new(URI.unescape(projName),lang)
      project.url = list[0]
      return project
    end
  end

  class SonarFileWriter
    def initialize()

    end

    def run(baseDir, lang)
      os_walk(baseDir, lang)
    end

    def os_walk(root, lang)
      root = Pathname(root)
      dirs = []
      dirs << root
      Pathname(root).find do |path|
        unless path == root || path.basename.to_s == "src"|| path.basename.to_s == "test"
          dirs << path if path.directory?
        end
      end

      dirs.each do |dir|
        modules = []
        unless dir.children(with_directory=false).include?(Pathname("src")) or dir.children(with_directory=false).include?(Pathname("test"))
          dir.each_child(with_director=false) do |val|
            modules << val
          end
          writeParentFile(modules, dir)
        else
          writeVersionFile(dir, lang)
        end
      end
    end

    def writeParentFile(modules, dir)
      modstr = ""
      modules.each do |mod|
        modstr = modstr + mod.basename.to_s
        modstr = modstr + "," unless modules.index(mod) == modules.size() - 1
      end

      key = dir.basename
      proj = key
      
      unless File.exists?(dir + "/sonar-project.properties")
        file = File.new(dir.to_s + "/sonar-project.properties", "w")
        file.puts "sonar.projectKey=#{key}"
        file.puts "sonar.projectName=#{proj} All Versions"
        file.puts "sonar.modules=#{modstr}"
        file.close()
      end
    end

    def writeVersionFile(dir, lang)
      proj = dir.dirname().basename()
      ver = dir.basename()

      unless File.exists?(dir + "/sonar-project.properties")
        file = File.new(dir.to_s + "/sonar-project.properties", "w")
        file.puts "sonar.projectKey=#{proj}-#{ver}"
        file.puts "sonar.projectName=#{proj}"
        file.puts "sonar.projectVersion=#{ver}"
        file.puts "sonar.language=#{lang}"
        file.puts "sonar.tests=test"
        file.puts "sonar.sources=src"
        file.close()
      end
    end
  end

  class SourceUnpacker
    def initialize()

    end

    def run(baseDir, lang)
      files = os_walk(baseDir, lang)

      files.each do |path|
        $extensions[lang].each do |ext|
          exec "7za x #{path.to_s} \"#{ext}\" -o#{path.dirname()}/src"
        end
      end
    end

    def os_walk(root, lang)
      root = Pathname(root)
      files = []
      Pathname(root).find do |path|
        unless path == root || path.basename.to_s == "src"
          files << path if path.file? && path.basename.to_s.end_with?($zipext)
        end
      end

      return files
    end
  end
end

$extensions = {
  'java' => ['*.java'],
  'cpp' => ['*.hpp','*.cpp','*.c','*.cxx','*.h','*.cc'],
  'csharp' => ['*.cs']
}
$zipext = ['.7z','.zip','.jar','tgz','.jar','.tar','.gz','bz2']

reader = SFExtract::ProjectReader.new()
finder = SFExtract::ProjectFinder.new()
creator = SFExtract::DirectoryCreator.new()
identifier = SFExtract::VersionIdentifier.new()
sonar = SFExtract::SonarFileWriter.new()
unpacker = SFExtract::SourceUnpacker.new()
downloader = SFExtract::FileDownloader.new()

if ARGV.size() < 2
  puts "usage: ruby SFExtract.rb <lang> <baseDir> <project-list>"
  puts "\t<lang> can be one of the following:"
  puts "\t\tjava - Java Project"
  puts "\t\tcharp - C# Project"
  puts "\t\tcpp - C++ Project"
  puts ""
  puts "\t<baseDir> - is the root directory to store the projects"
  puts ""
  puts "\t<project-list> - is a text file containing the names of the projects"
else
  baseDir = ARGV[1]

  puts "baseDir: #{ARGV[1]}"
  puts "lang: #{ARGV[0]}"
  puts "file: #{ARGV[2]}"

  if File.exists?(baseDir) && File.directory?(baseDir)
    lang = ARGV[0]
    if $extensions.has_key?(lang) && File.exists?(ARGV[2]) && File.file?(ARGV[2])
      puts "# reading in project names"
      list = reader.run(ARGV[2])
      projects = Array.new()

      puts "# finding projects on source forge"
      list.each do |proj|
        projects << finder.run(proj,lang)
      end

      puts "# finding project versions on source forge"
      projects.each do |proj|
        puts "# \tProject: #{proj.name}"
        versions = identifier.run(proj)
        puts "# Creating Directory Structure"
        versions.each do |version|
          creator.run(baseDir, version)
        end
        puts "# Downloading files"
        versions.each do |version|
          downloader.run(version)
        end
      end

      puts "# Writing sonar.projects files"
      sonar.run(baseDir, lang)

      puts "# Unpacking source code"
      unpacker.run(baseDir, lang)
    end
  end
end
\end{lstlisting}
\end{singlespace}