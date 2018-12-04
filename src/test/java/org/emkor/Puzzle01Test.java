package org.emkor;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Puzzle01Test {

    @Test
    public void calcSumTest() {
        List<String> testInput = Arrays.asList("+1", "-2", "+3", "+1");
        Integer result = Puzzle01.calcSum(testInput);
        assertEquals(Integer.valueOf(3), result);
    }

    @Test
    public void calcSumAndReturnFirstDuplicateSimpleCaseTest() {
        List<String> testInput = Arrays.asList("+1", "-1");
        Integer result = Puzzle01.calcSumAndReturnFirstDuplicate(testInput, new ArrayList<>());
        assertEquals(Integer.valueOf(0), result);
    }

    @Test
    public void calcSumAndReturnFirstDuplicateLongerCaseTest() {
        List<String> testInput = Arrays.asList("+3", "+3", "+4", "-2", "-4");
        Integer result = Puzzle01.calcSumAndReturnFirstDuplicate(testInput, new ArrayList<>());
        assertEquals(Integer.valueOf(10), result);
    }

    @Test
    public void calcSumAndReturnFirstDuplicateLastCaseTest() {
        List<String> testInput = Arrays.asList("+7", "+7", "-2", "-7", "-4");
        Integer result = Puzzle01.calcSumAndReturnFirstDuplicate(testInput, new ArrayList<>());
        assertEquals(Integer.valueOf(14), result);
    }


}