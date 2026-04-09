package org.eddydashcode.java_design_patterns.structural.adapter.datasource;

public class ClientApplication {

    public static void main(String[] args) {
        DataSource csvDataSource = new CSVDataSourceAdapter("data.csv");
        String[][] data = csvDataSource.readData();

        for (String[] row : data) {
            System.out.println(String.join(" | ", row));
        }
    }
}
