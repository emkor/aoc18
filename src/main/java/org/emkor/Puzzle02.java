package org.emkor;

import java.util.*;

import static org.emkor.TextFileUtil.readLines;

public class Puzzle02 {
    public static void main(String[] args) {
        List<String> lines = readLines("/home/mat/project/aoc18/src/resources/puzzle02.txt");
        Integer checkSum = countChecksum(lines);
        System.out.println("The checksum is " + checkSum);
        String commonLetters = findCommonLetters(lines);
        System.out.println("Common letters are: " + commonLetters);
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

    public static String findCommonLetters(List<String> lines) {
        Map<Integer, Set<String>> indexToStringVariants = new HashMap<>();
        for (String line : lines) {
            Map<Integer, String> variations = lineVariations(line);
            for (Map.Entry<Integer, String> e : variations.entrySet()) {
                Set<String> indexWordVariants = indexToStringVariants.get(e.getKey());
                if (indexWordVariants == null) {
                    indexWordVariants = new HashSet<>();
                }
                if (indexWordVariants.contains(e.getValue())) {
                    return e.getValue();
                } else {
                    indexWordVariants.add(e.getValue());
                    indexToStringVariants.put(e.getKey(), indexWordVariants);
                }
            }
        }
        return null;
    }

    static Map<Integer, String> lineVariations(String line) {
        Map<Integer, String> indexToLineVariations = new HashMap<>();
        for (int i = 0; i < line.length(); i++) {
            indexToLineVariations.put(i, wordWithoutCharAt(line, i));
        }
        return indexToLineVariations;
    }

    static String wordWithoutCharAt(String word, Integer index) {
        return word.substring(0, index) + word.substring(index + 1);
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
