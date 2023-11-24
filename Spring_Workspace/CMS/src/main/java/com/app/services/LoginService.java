package com.app.services;
import org.springframework.boot.sql.init.dependency.DependsOnDatabaseInitialization;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;

@DependsOnDatabaseInitialization
@Service
public class LoginService {
    private final DataSource dataSource;
    private final JwtTokenProvider jwtTokenProvider;


    public LoginService(DataSource dataSource,JwtTokenProvider jwtTokenProvider) {
        this.dataSource = dataSource;
        this.jwtTokenProvider = jwtTokenProvider;
    }
//    public LoginService() {
//        super();
//    }
    public boolean checkLogin(String username, String password) {
        try (Connection connection = dataSource.getConnection()) {
            String query = "SELECT username, password FROM users WHERE username = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, username);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String storedPassword = resultSet.getString("password");
                        if (password.equals(storedPassword)) {
                            return true;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
