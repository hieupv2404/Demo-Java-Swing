package pm1.hieupv.service.impl;

import pm1.hieupv.dao.JDBCConnector;
import pm1.hieupv.dao.UserDAO;
import pm1.hieupv.model.User;
import pm1.hieupv.service.UserService;

import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private JDBCConnector jdbcConnector = new JDBCConnector();
    private Connection connection = jdbcConnector.getConnection();
    private UserDAO userDAO = new UserDAO(connection);

    public UserServiceImpl() throws SQLException {
    }

    @Override
    public boolean findUserForLogin(User user) {
        return userDAO.checkUser(user);
    }
}
