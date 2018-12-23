package org.emkor;

import java.util.*;

import static org.emkor.TextFileUtil.readLines;

public class Puzzle01 {
    public static void main(String[] args) {
        List<String> lines = readLines("/home/mat/project/aoc18/src/resources/puzzle01.txt");
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

}
