
package com.cfstats.problemset;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ProblemsetResult {

    @SerializedName("status")
    @Expose
    public String status;

    @SerializedName("result")
    @Expose
    public Result result;

    @Override
    public String toString() {
        ToStringBuilder.setDefaultStyle(ToStringStyle.MULTI_LINE_STYLE);
        return new ToStringBuilder(this).append("status", status).append("result", result).toString();
    }

}
