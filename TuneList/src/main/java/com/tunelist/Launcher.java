package com.tunelist;

import java.util.Arrays;
import java.util.List;

public class Launcher {
    public static TuneList tl;
    public static Config config;
    
    public static void main(String[] args) {
        config = new Config();
        tl = new TuneList(config.get("file"));
        //List<String[]> result = tl.searchTitle("wind");
        List<String[]> result = tl.searchTitle("the");

        System.out.printf("Found %d results %n%n", result.size());

        for (String[] row : result) {
            System.out.println(Arrays.toString(row));
        }
        

    }

}
