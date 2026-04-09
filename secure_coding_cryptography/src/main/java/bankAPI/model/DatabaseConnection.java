package bankAPI.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.*;

public class DatabaseConnection {

    private final Connection connection;


    public DatabaseConnection(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
        insertUser();
    }

    private void insertUser() throws SQLException {
        Statement stmt = this.connection.createStatement();

        // Create table and insert user with raw password
        stmt.execute("CREATE TABLE users (username VARCHAR(255), password VARCHAR(255))");
        stmt.execute("INSERT INTO users VALUES ('admin', 'admin123')");

        // insert user with encrypted password
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hash = encoder.encode("admin1234");

        // Use prepared statement to insert safely
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        PreparedStatement stmt1 = this.connection.prepareStatement(sql);
        stmt1.setString(1, "admin1");
        stmt1.setString(2, hash);
        stmt1.executeUpdate();

        System.out.println("✅ User inserted with hashed password.");

        ResultSet rs = stmt.executeQuery("SELECT * FROM users");

        while (rs.next()) {
            String username = rs.getString("username");
            String password = rs.getString("password"); // hashed
            System.out.println("Username: " + username + ", Hashed Password: " + password);
        }
    }

    public boolean authenticateWithVulnerability(String username, String password) throws SQLException {

        // ⚠️ Vulnerable query
        String sql = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
        System.out.println("Executing: " + sql);

        Statement statement = this.connection.createStatement();

        ResultSet rs = statement.executeQuery(sql);

        if (rs.next()) {
            System.out.println("✅ Login successful! Welcome " + username);
            return true;
        }

        System.out.println("❌ Invalid credentials.");

        return false;
    }

    public boolean authenticateWithOutVulnerability(String username, String password) throws SQLException {

        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        PreparedStatement pstmt = this.connection.prepareStatement(sql);
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            System.out.println("✅ Login successful! Welcome " + username);
            return true;
        }

        System.out.println("❌ Invalid credentials.");

        return false;
    }

    public boolean authenticateWithEncryption(String username, String password) throws SQLException {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String sql = "SELECT * FROM users WHERE username = ?";

        PreparedStatement pstmt = this.connection.prepareStatement(sql);
        pstmt.setString(1, username);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            String hashPass = rs.getString("password");
            if (encoder.matches(password, hashPass)) {
                System.out.println("✅ Login successful! Welcome " + username);
                return true;
            }
        }

        System.out.println("❌ Invalid credentials.");

        return false;
    }

    public Connection getConnection() {
        return connection;
    }
}
