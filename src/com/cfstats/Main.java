package com.cfstats;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException, ParseException {


        Scanner scanner = new Scanner(System.in);

        String handle = scanner.nextLine();

        System.out.println("Handle: " + handle);


        HttpClient myHC = HttpClient.newHttpClient();

        HttpRequest myReq = HttpRequest.newBuilder(new URI("https://codeforces.com/api/user.info?handles=" + handle)).build();

        HttpResponse<String> myResp = myHC.send(myReq, HttpResponse.BodyHandlers.ofString());

        System.out.println("Response code is " + myResp.statusCode());
        System.out.println("Request Method is " + myResp.request().method());

//        var hdrs = myResp.headers();
//        var hdrMap = hdrs.map();
//
//        System.out.println("\nHere is the header:");
//        for (String k : hdrMap.keySet()) {
//            System.out.println("Key: " + k + " Value: " + hdrMap.get(k));
//        }

//        System.out.println("\nHere is the body:");
//
        String input = myResp.body();
//        int c;
//        while ((c = input.read()) != -1) {
//            System.out.print((char) c);
//        }

        JSONObject jsonObj = (JSONObject) (new JSONParser().parse(String.valueOf(input)));
        JSONObject result = (JSONObject) ((JSONArray) jsonObj.get("result")).get(0);

        User user = new User(result);
        System.out.println(user);


    }
}
