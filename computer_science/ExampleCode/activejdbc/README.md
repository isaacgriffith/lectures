# ActiveJDBC Example

This is a simple project for students to understand how to get ActiveJDBC up and running when combining it with gradle.

## Using the fixed ActiveJDBC Plugin for Gradle

0. Clone this project
1. Then build the ActiveJDBC plugin found in the activejdbc directory. This requires the following steps be followed:
    1. In the command line enter the activejdbc directory (i.e. execute the command: `$ cd activejdbc`)
    2. Build the updated version of the activejdbc plugin using the following command:

       ```bash
       $ ./gradlew clean build publish
       ```

    3. At this point you can now use this in your other projects, as it should be available in your local maven repo.
    4. To add the plugin to your local projects, you should add the following code to the top of your project's `settings.gradle` file:

       ```
       pluginManagement {
           repositories {
               mavenLocal()
               gradlePluginPortal()
           }
       }
       ```

    5. Next you simply need to add the plugin to your project's `build.gradle` file with the following:

       ```groovy
       plugins {
           ...
           id "com.empirilytics.activejdbc-gradle-plugin" version "3.0-j11"
           ...
       }
       ```

2. Next you should add in the dependencies necessary for activejdbc as follows:

    ```groovy
    dependencies {
        ...
        implementation "org.javalite:activejdbc:3.0-j11"
        implementation "org.javalite:javalite-common:3.0-j11"
        ...
    }   
    ```
   
    You will also need to add the following section to the `build.gradle` file (note the version should match the dependencies):

    ```groovy
    activejdbc {
        toolVersion = '3.0-j11'
    }
    ```

5. Finally, you will need to add the necessary dbms JDBC driver dependencies, I suggest selecting the specific ones for your needs:

   ```groovy
   dependencies {
       ...
       // SQLite
       implementation 'org.xerial:sqlite-jdbc:3.25.2'
       // MariaDb
       implementation 'org.mariadb.jdbc:mariadb-java-client:2.6.0'
       // MySQL
       implementation 'mysql:mysql-connector-java:8.0.20'
       // PostgreSQL
       implementation 'org.postgresql:postgresql:42.3.3'
       // Oracle 18n
       implementation 'com.oracle.jdbc:orai18n:12.2.0.1'
       // MS SQL Server
       implementation 'com.microsoft.sqlserver:mssql-jdbc:10.2.0.jre11'
       // Apache Derby
       implementation 'org.apache.derby:derby:10.15.2.0'
       // IBM DB2
       implementation 'com.ibm.db2:jcc:11.5.7.0'
       // IBM Informix
       implementation 'com.ibm.informix:jdbc:4.50.7.1'
       ...
   }
   ```
   
## Building and Running the Example Project

1. From the project root directory simply execute the following command to build the project:

   ```bash
   $ ./gradlew clean build 
   ```
   
2. Running the project requires a bit more work.
   1. The project requires that you have MySQL up and running on your system and accessible on port 3306
   2. If that is not the case and you live in a timezone other than America/Denver, then you will need to modify the database url in the `App.java` file to use the correct url.
      1. Additionally you will need to update the username and password fields in the connection as well.
   3. You will need to execute the script, `data/testdb.sql` to setup the database.
   4. Once you have the database setup and the connection information corrected. You can run the project as follows:

      ```bash
      $ ./gradlew run 
      ```
      
## Authors

This project was authored by @grifisaa

## License

The MIT License (MIT)

Test ActiveJDBC Project
Copyright (c) 2022 Isaac D. Griffith

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.