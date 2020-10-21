package com.cfstats.problemset;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problemset {

    private List<Problem> problemList = null;
    private Map<String, Problem> problemMap = null;

    Problemset(List<Problem> list) {
        this.problemList = list;
        createMapping();
    }

    public void createMapping() {
        problemMap = new HashMap<String, Problem>();
        for (Problem problem : problemList) {
            problemMap.put(problem.getUniqueName(), problem);
        }
    }

    public int getProblemsetSize() {
        System.out.println("Total problems: " + problemList.size());
        return problemList.size();
    }

    public void writeProblemsetToFile() throws IOException {
        try (FileWriter writer = new FileWriter("problemset.txt")) {
            for (Problem pb : problemList) {
                writer.append(pb.toString());
            }
        }
    }

    public void writeProblemsetToFileAsCSV(String fileName) throws IOException {
//        String fileName = "problemset.csv";
        try (CSVPrinter printer = new CSVPrinter(new FileWriter(fileName), CSVFormat.DEFAULT)) {
            printer.printRecord("#", "name", "rating", "solvedCount");
            for (Problem pb : problemList) {
                printer.printRecord(pb.getUniqueName(), pb.getName(), pb.getRating(), pb.getSolvedCount(), pb.tags);
            }
        }
        System.out.println("Wrote to " + fileName);
    }

    // Sorts problemset by rating in ascending order
    public void sortByRatingAscending() {
        problemList.sort(new CompareProblemsByRating());
    }

    // Sorts problemset by rating in ascending order
    public void sortByRatingADescending() {
        problemList.sort(new CompareProblemsByRating().reversed());
    }

    // Sorts problemset by solved count
    public void sortBySolvedCountAscending() {
        problemList.sort(new CompareProblemsBySolvedCount());
    }

    // Sorts problemset by solved count
    public void sortBySolvedCountDescending() {
        problemList.sort(new CompareProblemsBySolvedCount().reversed());
    }

    // Checks if the problem is in the problemset
    public boolean contains(String uniqueName) {
        return problemMap.containsKey(uniqueName);
    }

    // Returns the problem specified
    public Problem getProblem(String uniqueName) {
        if (!contains(uniqueName)) {
            System.out.println("No such problem: " + uniqueName);
            return null;
        }
        return problemMap.get(uniqueName);
    }

}
