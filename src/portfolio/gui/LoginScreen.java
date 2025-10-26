package portfolio.gui;

import javax.swing.*;

public class LoginScreen extends JFrame {
    public LoginScreen() {
        setTitle("Login");
        setSize(300, 180);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(30, 30, 80, 25);
        add(userLabel);

        JTextField userField = new JTextField();
        userField.setBounds(120, 30, 120, 25);
        add(userField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(100, 80, 80, 25);
        add(loginButton);

        loginButton.addActionListener(e -> {
            String username = userField.getText();
            if (!username.isEmpty()) {
                dispose();
                new Dashboard(username);
            } else {
                JOptionPane.showMessageDialog(null, "Enter username");
            }
        });

        setVisible(true);
    }
}
