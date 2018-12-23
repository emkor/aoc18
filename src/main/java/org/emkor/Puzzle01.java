package org.emkor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class Puzzle01 {
    public static void main(String[] args) {
        List<String> lines = readTextFile("/home/mat/project/aoc18/src/resources/puzzle01.txt");
        Integer result = calcSum(lines);
        System.out.println("The first part sum is: " + result);
        Integer duplicate = calcSumAndReturnFirstDuplicate(lines);
        System.out.println("The first duplicate is: " + duplicate);
    }

    static Integer calcSum(List<String> strings) {
        Optional<Integer> optionalSum = strings.stream().map(Integer::parseInt).reduce(Integer::sum);
        return optionalSum.orElse(0);
    }

    static Integer calcSumAndReturnFirstDuplicate(List<String> strings) {
        Integer frequency = 0;
        Set<Integer> frequencies = new HashSet<>();
        while (true) {
            for (String s : strings) {
                frequency = frequency + Integer.parseInt(s);
                if (frequencies.contains(frequency)) {
                    return frequency;
                } else {
                    frequencies.add(frequency);
                }
            }
        }
    }

    private static List<String> readTextFile(String path) {
        List<String> lines = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEach(lines::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
