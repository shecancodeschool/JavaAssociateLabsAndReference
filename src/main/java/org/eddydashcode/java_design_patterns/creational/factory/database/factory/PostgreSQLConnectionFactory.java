package org.eddydashcode.java_design_patterns.creational.factory.database.factory;

import org.eddydashcode.java_design_patterns.creational.factory.database.product.DatabaseConnection;
import org.eddydashcode.java_design_patterns.creational.factory.database.product.PostgreSQLConnection;

public class PostgreSQLConnectionFactory implements DatabaseConnectionFactory{

    @Override
    public DatabaseConnection createConnection() {
        return new PostgreSQLConnection();
    }
}
