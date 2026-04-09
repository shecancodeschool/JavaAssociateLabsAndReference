package org.eddydashcode.java_design_patterns.creational.factory.database;

import org.eddydashcode.java_design_patterns.creational.factory.database.factory.DatabaseConnectionFactory;
import org.eddydashcode.java_design_patterns.creational.factory.database.factory.MySQLConnectionFactory;
import org.eddydashcode.java_design_patterns.creational.factory.database.factory.PostgreSQLConnectionFactory;
import org.eddydashcode.java_design_patterns.creational.factory.database.product.DatabaseConnection;

public class ClientApplication {

    public static void main(String[] args) {

        // create MySQL database connection
        DatabaseConnectionFactory mysqlConnectionFactory = new MySQLConnectionFactory();
        DatabaseConnection mysqlConnection = mysqlConnectionFactory.createConnection();
        mysqlConnection.display();


        // create Postgre database connection
        DatabaseConnectionFactory postgreConnectionFactory = new PostgreSQLConnectionFactory();
        DatabaseConnection postgreConnection = postgreConnectionFactory.createConnection();
        postgreConnection.display();
    }
}
