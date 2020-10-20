package com.cfstats.problemset;

import com.google.gson.Gson;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProblemsetBuilder {

    public List<Problem> problemList;
    public Map<String, Problem> problemMap;

    public ProblemsetBuilder() throws URISyntaxException, IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI("https://codeforces.com/api/problemset.problems?tags=2-sat")).build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status Code: " + httpResponse.statusCode());

        ProblemsetResult problemsetResult = (new Gson()).fromJson(httpResponse.body(), ProblemsetResult.class);
        problemList = problemsetResult.result.problems;
        getSolvedCount(problemsetResult.result.problemStatistics);
        createProblemMap();
    }

    private void getSolvedCount(List<ProblemStatistic> problemStatisticList) {
        if (problemList.size() != problemStatisticList.size()) {
            System.out.println("Size don't match\n");
        }

        for (int i = 0; i < problemList.size(); i++) {
            if (problemList.get(i).getUniqueName().equals(problemStatisticList.get(i).getUniqueName())) {
                problemList.get(i).solvedCount = problemStatisticList.get(i).solvedCount;
            }
        }
    }

    private void createProblemMap() {
        problemMap = new HashMap<String, Problem>();
        for (Problem problem : problemList) {
            problemMap.put(problem.getUniqueName(), problem);
        }
    }

    public int getProblemsetSize() {
        System.out.println("Total problems: " + problemList.size());
        return problemList.size();
    }

    public void sortProblemListByRating() {
        problemList.sort(new CompareProblemsByRating());
    }

    public void writeProblemsetToFile() throws IOException {
        try (FileWriter writer = new FileWriter("problemset.txt")) {
            for (Problem pb : problemList) {
                writer.append(pb.toString());
            }
        }
    }

    public void writeProblemsetToFileAsCSV() throws IOException {
        try (CSVPrinter printer = new CSVPrinter(new FileWriter("problemset.csv"), CSVFormat.DEFAULT)) {
            printer.printRecord("#", "name", "rating", "solvedCount");
            for (Problem pb : problemList) {
                printer.printRecord(pb.getUniqueName(), pb.getName(), pb.getRating(), pb.getSolvedCount());
            }
        }
    }

}
