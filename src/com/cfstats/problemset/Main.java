package com.cfstats.problemset;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) throws Exception {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI("https://codeforces.com/api/problemset.problems")).build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status code: " + httpResponse.statusCode());

        Gson gson = new Gson();
        ProblemsetResult problemsetResult = gson.fromJson(httpResponse.body(), ProblemsetResult.class);
//        System.out.println(problemsetResult);
        System.out.println("Total problems: " + problemsetResult.result.problems.size());
    }
}
