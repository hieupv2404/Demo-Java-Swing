package pm1.hieupv.dao;

import pm1.hieupv.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Connection connection;
    private List<User> userList;
    private User user;

    public UserDAO(Connection connection) {
        this.connection = connection;
        this.userList = new ArrayList<>();
    }

    public boolean checkUser(User user) {
        boolean check = false;
        if (user != null) {
            String sql = "select * from user where user_name=? and pass_word=?";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, user.getUserName());
                preparedStatement.setString(2, user.getPassWord());

                ResultSet resultSet = preparedStatement.executeQuery();
                while(resultSet.next())
                {
                    this.user = new User();
                    this.user.setUserName(resultSet.getString("user_name"));
                    this.user.setPassWord(resultSet.getString("pass_word"));
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (this.user!= null) return true;
        else return false;
    }
}
