package pm1.hieupv.controller;

import pm1.hieupv.model.User;
import pm1.hieupv.service.impl.UserServiceImpl;
import pm1.hieupv.view.LoginView;
import pm1.hieupv.view.ClassView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginController {
    private UserServiceImpl userServiceImpl;
    private LoginView loginView;
    private ClassView classView;

    public LoginController(LoginView view) throws SQLException {
        this.loginView = view;
        this.userServiceImpl = new UserServiceImpl();
        view.addLoginListener(new LoginListener());
    }

    public void showLoginView() {
        loginView.setVisible(true);
    }

    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            User user = loginView.getLoginInfo();
            if(user!=null) {
                if (userServiceImpl.findUserForLogin(user)) {
                    classView = new ClassView();
                    ClassController classController = null;
                    try {
                        classController = new ClassController(classView);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    classController.showClassView();
                    loginView.setVisible(false);
                } else {
                    loginView.showMessage("Tài khoản hoặc mật khẩu không đúng.");
                }
            }
        }
    }
}

