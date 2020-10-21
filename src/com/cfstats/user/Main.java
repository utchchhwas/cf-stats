package com.cfstats.user;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException, URISyntaxException {
        User user = User.getUser("utchchhwas");
        System.out.println(user);
    }
}
