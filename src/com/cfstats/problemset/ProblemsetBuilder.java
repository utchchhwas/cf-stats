package com.cfstats.problemset;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

// Class for building a problemset
public class ProblemsetBuilder {

    private List<Problem> problemList;

    public ProblemsetBuilder() throws InterruptedException, IOException, URISyntaxException {
        problemList = null;
        fetchData();
    }

    private void fetchData() throws URISyntaxException, IOException, InterruptedException {
        System.out.println("Fetching data from Codeforces server...");

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI("https://codeforces.com/api/problemset.problems")).build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

//        System.out.println("Status Code: " + httpResponse.statusCode());
        if (httpResponse.statusCode() == 200) {
            System.out.println("Successfully fetched data.");
        }

        ProblemsetResult problemsetResult = (new Gson()).fromJson(httpResponse.body(), ProblemsetResult.class);
        problemList = problemsetResult.result.problems;
        getSolvedCount(problemsetResult.result.problemStatistics);
    }

    private void getSolvedCount(List<ProblemStatistic> problemStatisticList) {
        for (int i = 0; i < problemList.size(); i++) {
            if (problemList.get(i).getUniqueName().equals(problemStatisticList.get(i).getUniqueName())) {
                problemList.get(i).solvedCount = problemStatisticList.get(i).solvedCount;
            }
        }
    }

    public void sortProblemsetByRating() {
        problemList.sort(new CompareProblemsByRating());
    }


    // Returns the complete problemset in default order
    public Problemset getProblemset() {
        return  new Problemset(new ArrayList<>(problemList));
    }

    // Returns a problemset with the given rating
    public Problemset getProblemsetByRating(int rating) {
        ArrayList<Problem> list = new ArrayList<>();
        for (var pb : problemList) {
            if (pb.getRating() == rating) {
                list.add(pb);
            }
        }

        return  new Problemset(list);
    }

    // Returns a problemset with the given rating range
    public Problemset getProblemsetByRating(int lowRating, int highRating) {
        List<Problem> list = new ArrayList<>();
        for (var pb : problemList) {
            if (pb.getRating() >= lowRating && pb.getRating() <= highRating) {
                list.add(pb);
            }
        }
        list.sort(new CompareProblemsByRating());

        return new Problemset(list);
    }


    public Problemset getProblemsetByTag(Tags tag) {
        List<Problem> list = new ArrayList<>();
        for (var pb : problemList) {
            if (pb.getTags().contains(tag)) {
                list.add(pb);
            }
        }

        return new Problemset(list);
    }

    public Problemset getProblemsetByTagsAND(Tags[] tags) {
        List<Problem> list = new ArrayList<>();
        for (var pb : problemList) {
            if (pb.getTags().containsAll(Arrays.asList(tags))) {
                list.add(pb);
            }
        }

        return new Problemset(list);
    }

    public Problemset getProblemsetByTagsOR(Tags[] tags) {
        List<Problem> list = new ArrayList<>();
        for (var pb : problemList) {
            boolean contains = false;
            for (var tag : tags) {
                if (pb.getTags().contains(tag)) {
                    contains = true;
                    break;
                }
            }
            if (contains) {
                list.add(pb);
            }
        }

        return new Problemset(list);
    }

}
