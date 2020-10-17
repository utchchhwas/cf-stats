package com.cfstats;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ProblemList {
    public ArrayList<Problem> problems;

    public ProblemList(JSONArray jsonArray) {
        this.problems = new ArrayList<Problem>();
        for (var ob : jsonArray) {
            this.problems.add(new Problem((JSONObject) ob));
        }
    }

    public void printAsCSV() throws IOException {
        try (CSVPrinter printer = new CSVPrinter(new FileWriter("problemset.csv"), CSVFormat.DEFAULT)) {
            printer.printRecord("contestId", "index", "name", "rating");
            for (Problem pb : problems) {
                printer.printRecord(pb.contestId, pb.index, pb.name, pb.rating, String.join(", ", pb.tags));
            }
        }

    }
}
