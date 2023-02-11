package edu.isu.cs.cs2263;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class IOManager {

    private final Gson gson;

    public IOManager() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public List<Student> readData(String file) {
        String json = "";
        try { json = Files.readString(Paths.get(file)); }
        catch (IOException ex) { ex.printStackTrace(); }

        if (json.isBlank()) {
            return Lists.newArrayList();
        } else {
            Type listType = new TypeToken<ArrayList<Student>>() {}.getType();
            return gson.fromJson(json, listType);
        }
    }

    public void writeData(String file, List<Student> students) {
        String json = gson.toJson(students);
        try { Files.writeString(Paths.get(file), json); }
        catch (IOException ex) { ex.printStackTrace(); }
    }
}
