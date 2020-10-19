
package com.cfstats.submissions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

// Represents a member of a party.
public class Member {

    @SerializedName("handle")
    @Expose
    public String handle; // String. Codeforces user handle.

    @Override
    public String toString() {
        ToStringBuilder.setDefaultStyle(ToStringStyle.MULTI_LINE_STYLE);
        return new ToStringBuilder(this).append("handle", handle).toString();
    }

}
