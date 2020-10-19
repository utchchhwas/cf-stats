
package com.cfstats.problemset;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Result {

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
