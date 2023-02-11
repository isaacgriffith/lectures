package edu.isu.cs.cs2263;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class IOManager {

    public void writeData(List<Student> students) {
        Gson g = new GsonBuilder().setPrettyPrinting().create();

        String json = g.toJson(students);

        try { Files.writeString(Paths.get("./students.json"), json); }
        catch (IOException ex) { ex.printStackTrace(); }
    }
}
