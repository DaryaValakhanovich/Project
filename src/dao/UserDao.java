package dao;

import connection.ConnectionManager;
import entity.Role;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

public class UserDao extends BaseDao<User>{
    private static final String USERS_TABLE_NAME = "users";
    private static UserDao INSTANCE = null;


    private UserDao() {
    }

    public static UserDao getInstance() {
        if (INSTANCE == null) {
            synchronized (UserDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UserDao();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public String getSelectQueryById() {
        return "SELECT * FROM users " +
                "WHERE id = ?";
    }

    public String getSelectQueryByEmail() {
        return "SELECT * FROM users " +
                "WHERE email = ?";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM users;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO users (first_name, last_name, birthday, email, password, role) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
    }

    @Override
    protected void prepareStatementForCreate(PreparedStatement statement, User object) throws SQLException {
        statement.setString(1, object.getFirstName());
        statement.setString(2, object.getLastName());
        statement.setString(3, object.getBirthday().toString());
        statement.setString(4, object.getEmail());
        statement.setString(5, object.getPassword());
        statement.setString(6, object.getRole().name());

    }

    @Override
    public User createFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong(USERS_TABLE_NAME + ".id"));
        user.setFirstName(resultSet.getString(USERS_TABLE_NAME + ".first_name"));
        user.setLastName(resultSet.getString(USERS_TABLE_NAME + ".last_name"));
        user.setBirthday(LocalDate.parse(resultSet.getString(USERS_TABLE_NAME + ".birthday")));
        user.setEmail(resultSet.getString(USERS_TABLE_NAME + ".email"));
        user.setPassword(resultSet.getString(USERS_TABLE_NAME + ".password"));
        user.setRole(Role.valueOf(resultSet.getString(USERS_TABLE_NAME + ".role")));
        return  user;
    }

    public void addAdmin(long userId){
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE users SET role = 'ADMIN' WHERE id = ?; ")) {
                preparedStatement.setLong(1, userId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<User> findByEmail(String email){
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    getSelectQueryByEmail())) {
                preparedStatement.setString(1, email);
                try(ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return Optional.of(createFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
