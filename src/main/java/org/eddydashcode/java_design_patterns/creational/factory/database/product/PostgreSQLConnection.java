package org.eddydashcode.java_design_patterns.creational.factory.database.product;

public class PostgreSQLConnection implements DatabaseConnection{

    @Override
    public void display() {
        System.out.println("Postgre database connection...");
    }
}
