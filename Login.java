package com.auth;

import javax.swing.*;

import com.Method;
import com.pages.Main;
import com.pages.manager.Manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class Login implements ActionListener {
    JFrame frame = new JFrame();

    JLabel loginLabel = new JLabel();
    JLabel usernameLabel = new JLabel();
    JLabel passwordLabel = new JLabel();

    JTextField usernameTextField = new JTextField();
    JTextField passwordTextField = new JTextField();

    JButton button = new JButton("Login");

    JMenuBar menuBar = new JMenuBar();

    JMenu authMenu = new JMenu("Auth");
    JMenuItem loginItem = new JMenuItem("Login");

    JMenuItem registerItem = new JMenuItem("Register");

    public Login() {
        this.loginLabel.setText("Login");
        this.usernameLabel.setText("Username : ");
        this.passwordLabel.setText("Password : ");

        this.loginLabel.setBounds(0, 0, 100, 30);
        this.usernameLabel.setBounds(0, 40, 100, 30);
        this.passwordLabel.setBounds(0, 80, 100, 30);
        this.usernameTextField.setBounds(120, 40, 150, 25);
        this.passwordTextField.setBounds(120, 80, 150, 25);
        this.button.setBounds(120, 130, 150, 25);

        this.button.addActionListener(this);
        this.registerItem.addActionListener(this);

        this.frame.setJMenuBar(this.menuBar);
        this.menuBar.add(this.authMenu);

        this.authMenu.add(this.loginItem);
        this.authMenu.add(this.registerItem);

        this.frame.add(this.button);
        this.frame.add(this.usernameTextField);
        this.frame.add(this.passwordTextField);
        this.frame.add(this.loginLabel);
        this.frame.add(this.usernameLabel);
        this.frame.add(this.passwordLabel);

        this.frame.setSize(300, 300);
        this.frame.setResizable(false);
        this.frame.setLayout(null);
        this.frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.button) {
            try {
                if (!this.usernameTextField.getText().isEmpty() && !this.passwordTextField.getText().isEmpty()) {
                    if (Method.usernameAndPasswordMatch(this.usernameTextField.getText(),
                            this.passwordTextField.getText())
                            && (!this.usernameTextField.getText().isEmpty()
                                    && !this.passwordTextField.getText().isEmpty())) {

                        User.currentUser = Method.getSpecificUserWithUsername(this.usernameTextField.getText());

                        this.frame.dispose();

                        switch (User.currentUser[3]) {
                        case "cashier":
                            new Main();
                            break;
                        case "manager":
                            new Manager();
                            break;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "USERNAME AND PASSWORD NOT MATCH!", "INVALID",
                                JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "USERNAME FIELD AND PASSWORD FIELD IS EMPTY!", "INVALID",
                            JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception error) {
                System.err.println(error);
            }

        }

        if (e.getSource() == this.registerItem) {
            this.frame.dispose();

            new Register();
        }

    }

}
