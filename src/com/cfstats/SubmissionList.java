package com.cfstats;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SubmissionList {
    public ArrayList<Submission> submissions;

    public  SubmissionList(JSONArray jsonArray) {
        this.submissions = new ArrayList<Submission>();
        for (var ob : jsonArray) {
            submissions.add(new Submission((JSONObject) ob));
        }
    }

    public void writeToFile() throws IOException {
        try (FileWriter writer = new FileWriter("pritam_submission.txt")) {
            writer.append("Total submissions: ").append(Integer.toString(submissions.size())).append("\n\n");
            for (var sb : submissions) {
                writer.append(Long.toString(sb.id)).append(" - ");
                writer.append(sb.problem.name).append(" - ");
                writer.append(sb.verdict).append(" - ");
                writer.append(sb.programmingLanguage).append("\n");
            }
        }

    }
}
