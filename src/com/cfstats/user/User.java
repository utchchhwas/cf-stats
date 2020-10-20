
package com.cfstats.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

// Represents a Codeforces user.
public class User {

    @SerializedName("lastName")
    @Expose
    public String lastName; // String. Localized. Can be absent.

    @SerializedName("country")
    @Expose
    public String country; // String. Localized. Can be absent.

    @SerializedName("lastOnlineTimeSeconds")
    @Expose
    public Long lastOnlineTimeSeconds; // Integer. Time, when user was last seen online, in unix format.

    @SerializedName("city")
    @Expose
    public String city; // String. Localized. Can be absent.

    @SerializedName("rating")
    @Expose
    public Long rating; // Integer.

    @SerializedName("friendOfCount")
    @Expose
    public Long friendOfCount; // Integer. Amount of users who have this user in friends.

    @SerializedName("titlePhoto")
    @Expose
    public String titlePhoto; // String. User's avatar URL.

    @SerializedName("handle")
    @Expose
    public String handle; // String. Codeforces user handle.

    @SerializedName("avatar")
    @Expose
    public String avatar; // String. User's avatar URL.

    @SerializedName("firstName")
    @Expose
    public String firstName; // String. Localized. Can be absent.

    @SerializedName("contribution")
    @Expose
    public Long contribution; // 	Integer. User contribution

    @SerializedName("organization")
    @Expose
    public String organization; // String. Localized. Can be absent.

    @SerializedName("rank")
    @Expose
    public String rank; // String. Localized.

    @SerializedName("maxRating")
    @Expose
    public Long maxRating; // String. Localized.

    @SerializedName("registrationTimeSeconds")
    @Expose
    public Long registrationTimeSeconds; // Integer. Time, when user was registered, in unix format.

    @SerializedName("maxRank")
    @Expose
    public String maxRank; // Integer.


    @Override
    public String toString() {
        ToStringBuilder.setDefaultStyle(ToStringStyle.MULTI_LINE_STYLE);
        return new ToStringBuilder(this).append("lastName", lastName).append("country", country).append("lastOnlineTimeSeconds", lastOnlineTimeSeconds).append("city", city).append("rating", rating).append("friendOfCount", friendOfCount).append("titlePhoto", titlePhoto).append("handle", handle).append("avatar", avatar).append("firstName", firstName).append("contribution", contribution).append("organization", organization).append("rank", rank).append("maxRating", maxRating).append("registrationTimeSeconds", registrationTimeSeconds).append("maxRank", maxRank).toString();
    }
}
