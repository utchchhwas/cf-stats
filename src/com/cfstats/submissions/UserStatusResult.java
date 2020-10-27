
package com.cfstats.submissions;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

// Returns submissions of specified user.
public class UserStatusResult {

    // Status code returned by the API
    @SerializedName("status")
    @Expose
    public String status;

    // Result object
    @SerializedName("result")
    @Expose
    public List<Submission> submissionList = null;

    @Override
    public String toString() {
        ToStringBuilder.setDefaultStyle(ToStringStyle.MULTI_LINE_STYLE);
        return new ToStringBuilder(this).append("status", status).append("result", submissionList).toString();
    }

}
