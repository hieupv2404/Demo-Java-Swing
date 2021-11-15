package pm1.hieupv.view;

import pm1.hieupv.model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JLabel userNameLabel;
    private JLabel passwordlabel;
    private JPasswordField passwordField;
    private JTextField userNameField;
    private JButton loginBtn;

    public LoginView() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        userNameLabel = new JLabel("Tài khoản");
        passwordlabel = new JLabel("Mật khẩu");
        userNameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginBtn = new JButton();

        loginBtn.setText("Đăng nhập");
        loginBtn.addActionListener(this);

        // tạo spring layout
        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel();
        // tạo đối tượng panel để chứa các thành phần của màn hình login
        panel.setSize(400, 300);
        panel.setLayout(layout);
        panel.add(userNameLabel);
        panel.add(passwordlabel);
        panel.add(userNameField);
        panel.add(passwordField);
        panel.add(loginBtn);

        // cài đặt vị trí các thành phần trên màn hình login
        layout.putConstraint(SpringLayout.WEST, userNameLabel, 50, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, userNameLabel, 80, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, passwordlabel, 50, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, passwordlabel, 105, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, userNameField, 100, SpringLayout.WEST, userNameLabel);
        layout.putConstraint(SpringLayout.NORTH, userNameField, 80, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, passwordField, 100, SpringLayout.WEST, passwordlabel);
        layout.putConstraint(SpringLayout.NORTH, passwordField, 105, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, loginBtn, 100, SpringLayout.WEST, passwordlabel);
        layout.putConstraint(SpringLayout.NORTH, loginBtn, 130, SpringLayout.NORTH, panel);

        // add panel tới JFrame
        this.add(panel);
        this.pack();
        // cài đặt các thuộc tính cho JFrame
        this.setTitle("Đăng nhập");
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public User getUser() {
        return new User(userNameField.getText(),
                String.copyValueOf(passwordField.getPassword()));
    }

    public User getLoginInfo(){
        if(!validateUserName() || !validatePassWord() )
            return null;
        try {
            User user = new User();
            user.setUserName(userNameField.getText().trim());
            user.setPassWord(String.valueOf(passwordField.getPassword()).trim());
            return user;
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
        return null;
    }

    public boolean validateUserName(){
        String userName = userNameField.getText();
        if (userName == null || "".equals(userName.trim())) {
            userNameField.requestFocus();
            showMessage("Tài khoản không được trống.");
            return false;
        }
        return true;
    }

    public boolean validatePassWord(){
        String passWord = String.copyValueOf(passwordField.getPassword());
        if (passWord == null || "".equals(passWord.trim())) {
            passwordField.requestFocus();
            showMessage("Mật khẩu không được trống.");
            return false;
        }
        return true;
    }


    public void actionPerformed(ActionEvent e) {
    }

    public void addLoginListener(ActionListener listener) {
        loginBtn.addActionListener(listener);
    }
}
