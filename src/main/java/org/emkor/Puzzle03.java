package org.emkor;

import java.util.*;
import java.util.stream.Collectors;

import static org.emkor.TextFileUtil.readLines;

class Area {
    public int x;
    public int y;

    public Area(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Area " + this.x + ", " + this.y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area = (Area) o;
        return x == area.x &&
                y == area.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class Claim {
    public int id;
    public int x;
    public int y;
    public int xSize;
    public int ySize;


    public Claim(int id, int x, int y, int xSize, int ySize) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.xSize = xSize;
        this.ySize = ySize;
    }

    public static Claim fromLine(String line) {
        String idString = line.split("@")[0].split("#")[1];
        String xString = line.split("@")[1].split(":")[0].split(",")[0];
        String yString = line.split("@")[1].split(":")[0].split(",")[1];
        String xSizeString = line.split("@")[1].split(":")[1].split("x")[0];
        String ySizeString = line.split("@")[1].split(":")[1].split("x")[1];
        return new Claim(Integer.parseInt(idString.trim()),
                Integer.parseInt(xString.trim()), Integer.parseInt(yString.trim()),
                Integer.parseInt(xSizeString.trim()), Integer.parseInt(ySizeString.trim()));
    }

    @Override
    public String toString() {
        return "#" + this.id + " @ " + this.x + "," + this.y + ": " + this.xSize + "x" + this.ySize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Claim claim = (Claim) o;
        return id == claim.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Set<Area> toAreas() {
        Set<Area> areas = new HashSet<>();
        for (int xArea = 0; xArea < this.xSize; xArea++) {
            for (int yArea = 0; yArea < this.ySize; yArea++) {
                areas.add(new Area(this.x + xArea, this.y + yArea));
            }
        }
        return areas;
    }
}


public class Puzzle03 {
    public static void main(String[] args) {
        System.out.println("Starting...");
        List<String> lines = readLines("/home/mat/project/aoc18/src/resources/puzzle03.txt");
        List<Claim> claims = lines.stream().map(Claim::fromLine).collect(Collectors.toList());
        System.out.println("Overlapping areas inches: " + overlappingClaimsArea(claims));
    }

    public static Integer overlappingClaimsArea(List<Claim> claims) {
        Set<Area> takenAreas = new HashSet<>();
        Set<Area> overlappingAreas = new HashSet<>();
        for (Claim c : claims) {
            for (Area a : c.toAreas()) {
                if (takenAreas.contains(a)) {
                    overlappingAreas.add(a);
                } else {
                    takenAreas.add(a);
                }
            }
        }
        return overlappingAreas.size();
    }
}
