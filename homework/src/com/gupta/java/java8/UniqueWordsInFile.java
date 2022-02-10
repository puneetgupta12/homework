package com.gupta.java.java8;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UniqueWordsInFile {
    public static void main(String[] args) {
        List<String> uniqueWordsList = new ArrayList<>();

        try (Stream<String> lines =
                     Files.lines(Paths.get("//Users//puneet//Documents//Puneet//Technical//github//homework//src//com//gupta//java//java8//data.txt"), Charset.defaultCharset())) {
            uniqueWordsList = lines.flatMap(line ->
                    Arrays.stream(line.replaceAll("[,.!\"\']", "").split(" "))) //replace all commas, fullstops, quotes
                    .distinct()
                    .collect(Collectors.toList()); // or count() if we need only the count
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(uniqueWordsList.toString());
        System.out.println("Number of unique words in the file are: " + uniqueWordsList.size());
    }
}
