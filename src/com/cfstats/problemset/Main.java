package com.cfstats.problemset;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws Exception {
        ProblemsetBuilder builder = new ProblemsetBuilder();
        System.out.println(builder.problemList);
//        builder.sortProblemListByRating();
////        System.out.println(builder.problemList);
//        builder.getProblemsetSize();
////        builder.writeProblemsetToFile();
//        builder.writeProblemsetToFileAsCSV();

//        System.out.println("Here");
//
//        HttpClient httpClient = HttpClient.newHttpClient();
//        HttpRequest httpRequest = HttpRequest.newBuilder(new URI("https://codeforces.com/api/problemset.problems?tags=2-sat")).build();
//        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
//
//        System.out.println("Status code: " + httpResponse.statusCode());
//
//        Gson gson = new Gson();
//        ProblemsetResult problemsetResult = gson.fromJson(httpResponse.body(), ProblemsetResult.class);
////        System.out.println(problemsetResult);
//        System.out.println("Total problems: " + problemsetResult.result.problems.size());
//        System.out.println("Total problems in stats: " + problemsetResult.result.problemStatistics.size());
//
//        HashMap<String, Problem> problemHashMap = new HashMap<>();
//        for (Problem problem : problemsetResult.result.problems) {
//            problemHashMap.put(problem.getUniqueName(), problem);
//        }
//
//        for (ProblemStatistic problemStatistic : problemsetResult.result.problemStatistics) {
//            problemHashMap.get(problemStatistic.getUniqueName()).solvedCount = problemStatistic.solvedCount;
//        }
//
//        for (var pb : problemHashMap.values()) {
//            System.out.println(pb);
//        }
//
////        for (var it : problemsetResult.result.problemStatistics) {
////        }
    }
}
