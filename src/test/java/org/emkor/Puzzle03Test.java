package org.emkor;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.emkor.Puzzle02.*;
import static org.junit.Assert.assertEquals;

public class Puzzle03Test {

    @Test
    public void testShouldCalculateAreaCorrectly() {
        String inputLine = "#123 @ 3,2: 5x4";
        Claim c = Claim.fromLine(inputLine);
        Set<Area> areas = c.toAreas();
        assertEquals(20, areas.size());
    }

    @Test
    public void testShouldCalculateOverlappingAreaCorrectly() {
        List<String> lines =Arrays.asList("#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2");
        List<Claim> claims = lines.stream().map(Claim::fromLine).collect(Collectors.toList());
        Integer actualResult = Puzzle03.overlappingClaimsArea(claims);
        Integer expectedResult = 4;
        assertEquals(expectedResult, actualResult);
    }


}