package org.eddydashcode.java_design_patterns.structural.adapter.datasource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVDataReader {

    private final String filePath;

    public CSVDataReader(String filePath){
        this.filePath = filePath;
    }

    public List<String[]> readCSV(){
        List<String[]> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                records.add(line.split(","));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return records;
    }
}
