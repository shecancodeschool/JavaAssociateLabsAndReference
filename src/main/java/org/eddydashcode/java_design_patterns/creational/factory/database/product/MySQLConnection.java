package org.eddydashcode.java_design_patterns.creational.factory.database.product;

public class MySQLConnection implements DatabaseConnection{

    @Override
    public void display() {
        System.out.println("MySQL database connection ....");
    }
}
