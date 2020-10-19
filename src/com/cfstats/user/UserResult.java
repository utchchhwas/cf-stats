
package com.cfstats.user;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class UserResult {

    public String status;

    public List<User> result = null;

    @Override
    public String toString() {
        ToStringBuilder.setDefaultStyle(ToStringStyle.MULTI_LINE_STYLE);
        return new ToStringBuilder(this).append("status", status).append("result", result).toString();
    }

}
