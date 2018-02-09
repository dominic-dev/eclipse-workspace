package com.tunelist;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;

public class TuneList {
    public String path;
    public List<String[]> list;
    
    public TuneList(String p) {
        path = p;
        list = new ArrayList<>();
        this.read();
    }

    private int titleIndex = 1;
    
    private void read() {
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(path));
            String[] line;
            while ((line = reader.readNext()) != null) {
                //System.out.println(Arrays.toString(line));
                list.add(line);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }
    
    public List<String[]> searchTitle(String query){
        List<String[]> result = new ArrayList<>();
        for (String[] row : list){
            if (row[titleIndex].toLowerCase().contains(query)) {
                //System.out.println("found");
                result.add(row);
            }
        }

        return result;
    }
    
    private void filter(String dance, String key, String title) {
        dance = dance.length() > 0 ? dance : null;
        key = key.length() > 0 ? key : null;
        title= title.length() > 0 ? title: null; 
        
    }

}
