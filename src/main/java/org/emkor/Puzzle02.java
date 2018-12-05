package org.emkor;

import java.util.HashMap;
import java.util.Map;

public class Puzzle02 {
    public static void main(String[] args) {
        Integer twoLettersDuplicatedCount = 0;
        Integer threeLettersDuplicatedCount = 0;

        Integer checkSum = twoLettersDuplicatedCount * threeLettersDuplicatedCount;
    }

    static Boolean hasThreeLetters(String code) {
        Map<Character, Integer> charToCount = new HashMap<>();
        for (Character c : code.toCharArray()) {
            if (charToCount.containsKey(c)) {
                charToCount.put(c, charToCount.get(c) + 1);
            }
            else {
                charToCount.put(c, 1);
            }
        }
        return charToCount.containsValue(3);
    }

    static Boolean hasTwoLetters(String code) {
        Map<Character, Integer> charToCount = new HashMap<>();
        for (Character c : code.toCharArray()) {
            if (charToCount.containsKey(c)) {
                charToCount.put(c, charToCount.get(c) + 1);
            }
            else {
                charToCount.put(c, 1);
            }
        }
        return charToCount.containsValue(2);
    }
}
