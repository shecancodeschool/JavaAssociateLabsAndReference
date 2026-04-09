package org.eddydashcode.java_design_patterns.creational.factory.database.factory;

import org.eddydashcode.java_design_patterns.creational.factory.database.product.DatabaseConnection;

public interface DatabaseConnectionFactory {

    DatabaseConnection createConnection();
}
