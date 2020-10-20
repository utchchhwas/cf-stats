
package com.cfstats.problemset;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

// Represents a statistic data about a problem.
public class ProblemStatistic {

    @SerializedName("contestId")
    @Expose
    public Long contestId; // Integer. Can be absent. Id of the contest, containing the problem.

    @SerializedName("index")
    @Expose
    public String index; // String. Usually a letter of a letter, followed by a digit, that represent a problem index in a contest.

    @SerializedName("solvedCount")
    @Expose
    public Long solvedCount; // Integer. Number of users, who solved the problem.

    @Override
    public String toString() {
        ToStringBuilder.setDefaultStyle(ToStringStyle.MULTI_LINE_STYLE);
        return new ToStringBuilder(this).append("contestId", contestId).append("index", index).append("solvedCount", solvedCount).toString();
    }

    public String getUniqueName() {
        return contestId + index;
    }
}
