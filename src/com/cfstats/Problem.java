package com.cfstats;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

// Represents a problem.
public class Problem {

    public long contestId; // Integer. Can be absent. Id of the contest, containing the problem.
    public String index; // String. Usually a letter of a letter, followed by a digit, that represent a problem index in a contest.
    public String name; // String. Localized.
    public long rating; // Integer. Can be absent. Problem rating (difficulty).
    public ArrayList<String> tags; // String list. Problem tags.

    // Constructs a Problem object from a JSONObject object
    public Problem(JSONObject ob) {
        // Get contestID
        this.contestId = (long) ob.get("contestId");
        // Get index
        this.index = (String) ob.get("index");
        // Get name
        this.name = (String) ob.get("name");
        // Get rating; can be absent
        this.rating = (ob.get("rating") != null) ? ((long) ob.get("rating")) : -1;
        // Get tags
        this.tags = new ArrayList<String>((JSONArray) ob.get("tags"));
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Contest ID: ").append(contestId).append("\n");
        s.append("Index: ").append(index).append("\n");
        s.append("Name: ").append(name).append("\n");
        s.append("Tags:");
        for (int i = 0; i < tags.size(); i++) {
            s.append(" ").append(tags.get(i));
            if (i != tags.size() - 1) s.append(",");
        }
        s.append("\n");
        s.append("Rating: ").append(rating).append("\n");
        return s.toString();
    }

    public static ArrayList<Problem> getProblemList(JSONArray arr) {
        ArrayList<Problem> pbs = new ArrayList<Problem>();
        for (Object o : arr) {
            pbs.add(new Problem((JSONObject) o));
        }
        return pbs;
    }

    public void toCSV() throws IOException {
        try (CSVPrinter printer = new CSVPrinter(new FileWriter("csv.txt"), CSVFormat.DEFAULT)) {
            printer.printRecord(contestId, index, name, rating);
        }
    }
}
