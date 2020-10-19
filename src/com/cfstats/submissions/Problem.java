
package com.cfstats.submissions;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

// Represents a problem.
public class Problem {

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
    public String type; // Enum: PROGRAMMING, QUESTION.

    @SerializedName("rating")
    @Expose
    public Long rating; // Integer. Can be absent. Problem rating (difficulty).

    @SerializedName("tags")
    @Expose
    public List<String> tags = null; // 	String list. Problem tags.

    @SerializedName("points")
    @Expose
    public Double points; // Floating point number. Can be absent. Maximum ammount of points for the problem.

//    @SerializedName("problemsetName")
//    @Expose
//    public String problemsetName; // String. Can be absent. Short name of the problemset the problem belongs to.

    @Override
    public String toString() {
        ToStringBuilder.setDefaultStyle(ToStringStyle.MULTI_LINE_STYLE);
        return new ToStringBuilder(this).append("contestId", contestId).append("index", index).append("name", name).append("type", type).append("rating", rating).append("tags", tags).append("points", points).toString();
    }

}
