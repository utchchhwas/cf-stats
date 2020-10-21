
package com.cfstats.problemset;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

// Represents a problem.
public class Problem {

    enum TYPE {
        PROGRAMMING,
        QUESTION
    }

    @SerializedName("contestId")
    @Expose
    public Long contestId; // Integer. Can be absent. Id of the contest, containing the problem.

    @SerializedName("index")
    @Expose
    public String index; // String. Usually a letter of a letter, followed by a digit, that represent a problem index in a contest.

    @SerializedName("name")
    @Expose
    public String name; // String. Localized.

    @SerializedName("type")
    @Expose
    public TYPE type; // Enum: PROGRAMMING, QUESTION.

    @SerializedName("rating")
    @Expose
    public int rating; // Integer. Can be absent. Problem rating (difficulty).

    @SerializedName("tags")
    @Expose
    public List<Tags> tags = null; // 	String list. Problem tags.

    @SerializedName("points")
    @Expose
    public Double points; // Floating point number. Can be absent. Maximum ammount of points for the problem.

    public int solvedCount; // Integer. Number of users, who solved the problem.

    public List<Tags> getTags() {
        return tags;
    }

//    @SerializedName("problemsetName")
//    @Expose
//    public String problemsetName; // String. Can be absent. Short name of the problemset the problem belongs to.


    public int getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public int getSolvedCount() {
        return solvedCount;
    }

    public String getUniqueName() {
        return contestId + index;
    }

    // Returns an URL object containing the link to the problem
    public URL getLink() throws MalformedURLException {
        return new URL("https://codeforces.com/problemset/problem/" + contestId + "/" + index);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Problem problem = (Problem) obj;
        return Objects.equals(contestId, problem.contestId) &&
                index.equals(problem.index) &&
                name.equals(problem.name);
//        return getUniqueName().equals(problem.getUniqueName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(contestId, index);
    }

    @Override
    public String toString() {
        ToStringBuilder.setDefaultStyle(ToStringStyle.MULTI_LINE_STYLE);
        return new ToStringBuilder(this).append("contestId", contestId).append("index", index).append("name", name).append("type", type).append("rating", rating).append("tags", tags).append("points", points).append("solvedCount", solvedCount).toString();

//        return contestId + index + "\n";
    }

}
