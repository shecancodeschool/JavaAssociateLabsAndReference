package org.eddydashcode.java_design_patterns.structural.adapter.datasource;

import java.util.List;

public class CSVDataSourceAdapter implements DataSource{

    private final CSVDataReader csvDataReader;

    public CSVDataSourceAdapter(String filePath){
        this.csvDataReader = new CSVDataReader(filePath);
    }

    @Override
    public String[][] readData() {
        List<String[]> rawData = csvDataReader.readCSV();
        return rawData.toArray(new String[0][]);
    }
}
