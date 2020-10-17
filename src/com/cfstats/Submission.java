package com.cfstats;

import org.json.simple.JSONObject;

public class Submission {
    public long id;
    public Problem problem;
    public String programmingLanguage;
    public String verdict;

    public Submission(JSONObject jsonObj) {
        this.id = (long) jsonObj.get("id");
        this.problem = new Problem((JSONObject) jsonObj.get("problem"));
        this.programmingLanguage = (String) jsonObj.get("programmingLanguage");
        this.verdict = (String) jsonObj.get("verdict");
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("ID: ").append(id).append("\n");
        s.append("Language: ").append(programmingLanguage).append("\n");
        s.append(problem.toString());
        s.append("Verdict: ").append(verdict).append("\n");

        return s.toString();
    }
}
