package com.cfstats;


import com.cfstats.user.UserInfoResult;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Codeforces handle: ");
        String handle = scanner.nextLine();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI("https://codeforces.com/api/user.info?handles=" + handle)).build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println("Response code: " + httpResponse.statusCode());
        System.out.println("Request method: " + httpResponse.request().method());
        System.out.println("Body: " + httpResponse.body());

        Gson gson = new Gson();
        UserInfoResult userInfoResult = gson.fromJson(httpResponse.body(), UserInfoResult.class);

        System.out.println(userInfoResult);

        scanner.close();
    }
}
