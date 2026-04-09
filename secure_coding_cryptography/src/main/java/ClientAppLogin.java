import bankAPI.dto.BankDetails;
import bankAPI.dto.LoginRequest;
import bankAPI.service.impl.BankingServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class ClientAppLogin {


    /**
     * Try SQL Injection Input:
     *
     * username: admin' --
     * password: anything ...
     */

    public static void main(String[] args) throws SQLException {

        BankingServiceImpl bankingService = new BankingServiceImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        LoginRequest request = new LoginRequest(username, password);
        BankDetails login = bankingService.login(request);

        System.out.println(login);


        bankingService.logout();
    }

}
