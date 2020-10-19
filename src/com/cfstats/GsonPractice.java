package com.cfstats;

import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class GsonPractice {

    public  static void main(String[] args) throws IOException, InterruptedException, URISyntaxException, ParseException {
        String handle = null;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter Codeforces handle: ");
            handle = scanner.nextLine();
        }

        HttpClient myHC = HttpClient.newHttpClient();
        HttpRequest myReq = HttpRequest.newBuilder(new URI("https://codeforces.com/api/user.info?handles=" + handle)).build();
        HttpResponse<String> myResp = myHC.send(myReq, HttpResponse.BodyHandlers.ofString());
        String input = myResp.body();

        JSONObject jsonObj = (JSONObject) (new JSONParser().parse(String.valueOf(input)));
        JSONObject result = (JSONObject) ((JSONArray) jsonObj.get("result")).get(0);

        Gson gson = new Gson();

    }
}
