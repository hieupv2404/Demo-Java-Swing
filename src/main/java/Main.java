import pm1.hieupv.controller.LoginController;
import pm1.hieupv.view.LoginView;

import java.awt.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginView view = new LoginView();
                LoginController controller = null;
                try {
                    controller = new LoginController(view);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                // hiển thị màn hình login
                controller.showLoginView();
            }
        });
    }
}
