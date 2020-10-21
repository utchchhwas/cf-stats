package com.cfstats;

import org.json.simple.JSONObject;

import java.util.Date;

public class User {
    String handle;
    String firstName;
    String lastName;

    String country;
    String city;
    String organization;

    String maxRank;

    Long lastOnlineTimeSeconds;
    Long registrationTimeSeconds;

    Long rating;
    Long maxRating;

    String rank;

    Long contribution;
    Long friendOfCount;

    // String titlePhoto;
    // String avatar;
    // String email;


    public String getHandle() {
        return handle;
    }

    public User(JSONObject jsonObject) {
        this.handle = (String) jsonObject.get("handle");
        this.firstName = (String) jsonObject.get("firstName");
        this.lastName = (String) jsonObject.get("lastName");

        this.rank = (String) jsonObject.get("rank");
        this.maxRank = (String) jsonObject.get("maxRank");

        this.rating = (Long) jsonObject.get("rating");
        this.maxRating = (Long) jsonObject.get("maxRating");

        this.city = (String) jsonObject.get("city");
        this.country = (String) jsonObject.get("country");
        this.organization = (String) jsonObject.get("organization");

        this.contribution = (long) jsonObject.get("contribution");
        this.friendOfCount = (long) jsonObject.get("friendOfCount");


        this.lastOnlineTimeSeconds = (long) jsonObject.get("lastOnlineTimeSeconds");
        this.registrationTimeSeconds = (long) jsonObject.get("registrationTimeSeconds");
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Codeforces User Info:").append("\n");
        s.append("Handle: ").append(handle).append("\n");
        s.append("Name: ").append(firstName).append(" ").append(lastName).append("\n");
        s.append("Address: ").append(city).append(", ").append(country).append("\n");
        s.append("Organization: ").append(organization).append("\n");
        s.append("Rating: ").append(rating).append(" (Max: ").append(maxRating).append(")\n");
        s.append("Rank: ").append(rank).append(" (Max: ").append(maxRank).append(")\n");
        s.append("Contribution: ").append(contribution).append("\n");
        s.append("Friends: ").append(friendOfCount).append("\n");
        s.append("Last Active: ").append(new Date(lastOnlineTimeSeconds * 1000)).append("\n");
        s.append("Registered: ").append(new Date(registrationTimeSeconds * 1000)).append("\n");

        return s.toString();
    }

}
