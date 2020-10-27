package com.cfstats.submissions;

import com.cfstats.problemset.Problemset;
import com.cfstats.problemset.ProblemsetBuilder;

public class Main {
    public static void main(String[] args) throws Exception {
        UserSubmissions userSubmissions = new UserSubmissions("utchchhwas");
        userSubmissions.getTotalSubmissionCount();
        userSubmissions.getAcceptedSubmissionCount();
        userSubmissions.getSolvedProblems();

        ProblemsetBuilder problemsetBuilder = new ProblemsetBuilder();
        Problemset problemset = problemsetBuilder.getProblemset();
        userSubmissions.updateProblemset(problemset);
        problemset.writeProblemsetToFileAsCSV("updated-problemset");

    }
}

