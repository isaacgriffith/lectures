package edu.isu.cs.cs2263;

import com.google.common.collect.Lists;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Example {

    public static void main(String[] args) throws IOException {
        List<City> cities = readData();

        printCities(cities);

        Collections.sort(cities);
        System.out.println();
        System.out.println();

        printCities(cities);
    }

    private static List<City> readData() throws IOException {
        List<City> output = Lists.newArrayList();
        List<String> lines = Files.readAllLines(Paths.get("data/cities.csv"));
        lines.forEach(line -> {
            String[] split = line.split(",");
            output.add(new City(split[0], new State(split[1]), Integer.parseInt(split[2])));
        });
        return output;
    }

    private static void printCities(List<City> cities) {
        cities.forEach(System.out::println);
    }
}
