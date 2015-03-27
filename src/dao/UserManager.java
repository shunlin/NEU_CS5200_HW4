package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.User;


/**
 * Created by shunlin on 3/26/15.
 */
public class UserManager extends Manager {
    public UserManager() {
        super();
    }

    public void createUser(User newUser) {
        String sql = "INSERT INTO User VALUES (?, ?, ?, ?, ?, ?)";
        try {
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, newUser.getUsername());
            statement.setString(2, newUser.getPassword());
            statement.setString(3, newUser.getFirstName());
            statement.setString(4, newUser.getLastName());
            statement.setString(5, newUser.getEmail());
            statement.setDate(6, newUser.getDateOfBirth());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> readAllUsers() {
        List<User> users = new ArrayList<User>();
        String sql = "select * from User";
        try {
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet results = statement.executeQuery();
            while(results.next()) {
                User user = new User();
                user.setUsername(results.getString("username"));
                user.setPassword(results.getString("password"));
                user.setFirstName(results.getString("firstName"));
                user.setLastName(results.getString("lastName"));
                user.setEmail(results.getString("email"));
                user.setDateOfBirth(results.getDate("dateOfBirth"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User readUser(String username) {
        User user = new User();

        String sql = "SELECT * FROM User where username = ?";
        try {
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                user.setUsername(result.getString("username"));
                user.setPassword(result.getString("password"));
                user.setFirstName(result.getString("firstName"));
                user.setLastName(result.getString("lastName"));
                user.setEmail(result.getString("email"));
                user.setDateOfBirth(result.getDate("dateOfBirth"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void updateUser(String username, User user) {
        String sql = "UPDATE User SET password = ?, firstName = ?, lastName = ?, email = ?, dateOfBirth = ? WHERE username = ?";
        try {
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getPassword());
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getLastName());
            statement.setString(4, user.getEmail());
            statement.setDate(5, user.getDateOfBirth());
            statement.setString(6, username);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(String username) {
        String sql = "DELETE FROM User WHERE username = ?";
        try {
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
