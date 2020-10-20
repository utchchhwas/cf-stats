
package com.cfstats.problemset;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

// Object return by calling Codeforces API with problemset.problems method
public class ProblemsetResult {

    // Status code returned by the API
    @SerializedName("status")
    @Expose
    public String status;

    // Result object
    public static class Result {
        @SerializedName("problems")
        @Expose
        public List<Problem> problems = null; // List of Problem objects

        @SerializedName("problemStatistics")
        @Expose
        public List<ProblemStatistic> problemStatistics = null; // List of ProblemStatistics objects

        @Override
        public String toString() {
            ToStringBuilder.setDefaultStyle(ToStringStyle.MULTI_LINE_STYLE);
            return new ToStringBuilder(this).append("problems", problems).append("problemStatistics", problemStatistics).toString();
        }
    }

    // Result returned by the API
    @SerializedName("result")
    @Expose
    public Result result;

    @Override
    public String toString() {
        ToStringBuilder.setDefaultStyle(ToStringStyle.MULTI_LINE_STYLE);
        return new ToStringBuilder(this).append("status", status).append("result", result).toString();
    }

}
