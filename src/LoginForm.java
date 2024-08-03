import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;

    public LoginForm() {
        setTitle("Login");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("Username:"));
        txtUsername = new JTextField();
        panel.add(txtUsername);

        panel.add(new JLabel("Password:"));
        txtPassword = new JPasswordField();
        panel.add(txtPassword);

        JButton btnLogin = new JButton("Login");
        panel.add(btnLogin);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validateLogin();
            }
        });

        add(panel);
    }

    private void validateLogin() {
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());

        if ("admin".equals(username) && "admin".equals(password)) {
            dispose();
            new MainForm().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid login, please try again.");
        }
    }

    public static void main(String[] args) {
        new LoginForm().setVisible(true);
    }
}