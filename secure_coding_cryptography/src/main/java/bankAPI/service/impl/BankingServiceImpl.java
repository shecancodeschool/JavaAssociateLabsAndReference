package bankAPI.service.impl;

import bankAPI.dto.BankDetails;
import bankAPI.dto.LoginRequest;
import bankAPI.model.DatabaseConnection;
import bankAPI.service.BankingService;

import java.sql.SQLException;

public class BankingServiceImpl implements BankingService {

    private final DatabaseConnection databaseConnection;

    public BankingServiceImpl() throws SQLException {
        this.databaseConnection = new DatabaseConnection("jdbc:h2:mem:testdb", "sa", "");
    }

    @Override
    public BankDetails login(LoginRequest request) throws SQLException {

        boolean isAuthenticated = this.databaseConnection.authenticateWithEncryption(request.username(), request.password());

        if (!isAuthenticated) throw new RuntimeException("Invalid credentials");

        return new BankDetails(
                "Usenrame",
                "dfdf",
                "dfdfdf"
        );
    }


    @Override
    public void logout() throws SQLException {
        this.databaseConnection.getConnection().close();
    }
}
