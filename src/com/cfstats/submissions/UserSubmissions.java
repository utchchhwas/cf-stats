package com.cfstats.submissions;

import com.cfstats.problemset.Problem;
import com.cfstats.problemset.Problemset;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class UserSubmissions {

    String handle;
    private List<Submission> submissionList = null;
    private List<Submission> acceptedSubmissionList = null;
    private Set<Problem> solvedProblems = null;

    public UserSubmissions(String handle) throws InterruptedException, IOException, URISyntaxException {
        this.handle = handle;
        fetchData(handle);
    }

    private void fetchData(String handle) throws URISyntaxException, IOException, InterruptedException {
        System.out.println("Fetching data from Codeforces server...");

        int from = 1, count = 1000;
        HttpClient httpClient = HttpClient.newHttpClient();
        String link = "https://codeforces.com/api/user.status?handle=" + handle + "&from=" + from + "&count=" + count;
//        System.out.println("Link: " + link);
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI(link)).build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status Code: " + httpResponse.statusCode());
        if (httpResponse.statusCode() == 200) {
            System.out.println("Successfully fetched data.");
        }

        UserStatusResult userStatusResult = (new Gson()).fromJson(httpResponse.body(), UserStatusResult.class);
        submissionList = userStatusResult.submissionList;
        createAcceptedSubmissionList();
        createSolvedProblems();
    }

    private void createAcceptedSubmissionList() {
        if (submissionList == null) return;

        acceptedSubmissionList = new ArrayList<>();
        for (var sb : submissionList) {
            if (sb.getVerdict() == Verdict.OK) {
                acceptedSubmissionList.add(sb);
            }
        }
    }

    private void createSolvedProblems() {
        solvedProblems = new HashSet<>();
        for (var sb : acceptedSubmissionList) {
            solvedProblems.add(sb.getProblem());
        }
    }

    public int getTotalSubmissionCount() {
        System.out.println("Total submissions: " + submissionList.size());
        return submissionList.size();
    }

    public int getAcceptedSubmissionCount() {
        System.out.println("Accepted submissions: " + acceptedSubmissionList.size());
        return acceptedSubmissionList.size();
    }

    public void getSolvedProblems() {
        System.out.println("Total solved problems: " + solvedProblems.size());
    }

    public void updateProblemset(Problemset problemset) {
        var problemMap = problemset.getProblemMap();
        for (var pb : solvedProblems) {
            if (problemMap.containsKey(pb.getUniqueName())) {
                problemMap.get(pb.getUniqueName()).setSolved(true);
            }
        }
    }

}
