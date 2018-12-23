package org.emkor;

import java.util.*;

import static org.emkor.TextFileUtil.readLines;

public class Puzzle02 {
    public static void main(String[] args) {
        List<String> lines = readLines("/home/mat/project/aoc18/src/resources/puzzle02.txt");
        Integer checkSum = countChecksum(lines);
        System.out.println("The checksum is " + checkSum);
    }

    public static Integer countChecksum(List<String> lines) {
        Integer twoLettersDuplicatedCount = 0;
        Integer threeLettersDuplicatedCount = 0;
        for (String line : lines) {
            if (hasTwoLetters(line)) {
                twoLettersDuplicatedCount += 1;
            }
            if (hasThreeLetters(line)) {
                threeLettersDuplicatedCount += 1;
            }
        }
        return twoLettersDuplicatedCount * threeLettersDuplicatedCount;
    }

    static Set<String> lineVariations(String line) {
        Set<String> variations = new HashSet<>();
        for (int i = 0; i < line.length(); i++) {
            String variation = line.substring(0, i) + line.substring(i+1);
            variations.add(variation);
        }
        return variations;
    }

    static Boolean hasThreeLetters(String code) {
        Map<Character, Integer> charToCount = buildCharToOccurrencesMap(code);
        return charToCount.containsValue(3);
    }

    static Boolean hasTwoLetters(String code) {
        Map<Character, Integer> charToCount = buildCharToOccurrencesMap(code);
        return charToCount.containsValue(2);
    }

    private static Map<Character, Integer> buildCharToOccurrencesMap(String code) {
        Map<Character, Integer> charToCount = new HashMap<>();
        for (Character c : code.toCharArray()) {
            if (charToCount.containsKey(c)) {
                charToCount.put(c, charToCount.get(c) + 1);
            } else {
                charToCount.put(c, 1);
            }
        }
        return charToCount;
    }
}
