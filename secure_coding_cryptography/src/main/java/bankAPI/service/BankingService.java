package bankAPI.service;

import bankAPI.dto.BankDetails;
import bankAPI.dto.LoginRequest;

import java.sql.SQLException;

public interface BankingService {

    BankDetails login(LoginRequest request) throws SQLException;

    void logout() throws SQLException;
}
