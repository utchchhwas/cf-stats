package com.cfstats;

import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Parser {

    public static void main(String[] args) throws Exception {
//        JSONObject jo = (JSONObject) (new JSONParser().parse(new FileReader("problemset.json")));
//
//        System.out.println(jo.get("status"));
//
//        var problems = (JSONArray) ((JSONObject) jo.get("result")).get("problems");
//        ProblemList pbs = new ProblemList(problems);
//
//        pbs.printAsCSV();

        JSONObject jo = (JSONObject) (new JSONParser().parse(new FileReader("pritam_submission.json")));

        System.out.println(jo.get("status"));

        var result = (JSONArray) jo.get("result");
        SubmissionList sbList = new SubmissionList(result);
        sbList.writeToFile();

    }

}