package com.cfstats.submissions;

import com.google.gson.Gson;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws Exception {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI("https://codeforces.com/api/user.status?handle=utchchhwas&from=1&count=10")).build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status code: " + httpResponse.statusCode());

        Gson gson = new Gson();
        UserStatusResult result = gson.fromJson(httpResponse.body(), UserStatusResult.class);
        System.out.println(result);

    }
}

