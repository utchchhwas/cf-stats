
package com.cfstats.user;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;

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

    public String getHandle() {
        return handle;
    }

    @SerializedName("rank")
    @Expose
    public String rank; // String. Localized.

    @SerializedName("maxRating")
    @Expose
    public Long maxRating; // String. Localized.

    @SerializedName("registrationTimeSeconds")
    @Expose
    public Long registrationTimeSeconds; // Integer. Time, when user was registered, in unix format.

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return handle.equals(user.handle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(handle);
    }

    @SerializedName("maxRank")
    @Expose
    public String maxRank; // Integer.


    @Override
    public String toString() {
        ToStringBuilder.setDefaultStyle(ToStringStyle.MULTI_LINE_STYLE);
        return new ToStringBuilder(this).append("lastName", lastName).append("country", country).append("lastOnlineTimeSeconds", lastOnlineTimeSeconds).append("city", city).append("rating", rating).append("friendOfCount", friendOfCount).append("titlePhoto", titlePhoto).append("handle", handle).append("avatar", avatar).append("firstName", firstName).append("contribution", contribution).append("organization", organization).append("rank", rank).append("maxRating", maxRating).append("registrationTimeSeconds", registrationTimeSeconds).append("maxRank", maxRank).toString();
    }

    public static User createUser(String handle) throws IOException, InterruptedException, URISyntaxException {
        System.out.println("Fetching data from Codeforces server...");

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI("https://codeforces.com/api/user.info?handles=" + handle)).build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

//        System.out.println("Status Code: " + httpResponse.statusCode());
        if (httpResponse.statusCode() == 200) {
            System.out.println("Successfully fetched data.");
        }

        UserInfoResult userInfoResult = (new Gson()).fromJson(httpResponse.body(), UserInfoResult.class);
        return userInfoResult.result.get(0);
    }
}
