package pm1.hieupv.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/class_management";
    private static final String USER_NAME = "root";
    private static final String PASS_WORD = "ult.zda1";

    public JDBCConnector() {
    }

    public Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(URL,USER_NAME,PASS_WORD);

        if (conn!= null)
            System.out.println("Connect successfull");
        else
            System.out.println("Connect failed");
        return conn;
    }

}
