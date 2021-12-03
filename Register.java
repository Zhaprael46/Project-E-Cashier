package com.auth;

import javax.swing.*;

import com.Method;
import com.pages.Main;
import com.pages.manager.Manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
public class Register implements ActionListener {

    JFrame frame = new JFrame();

    JLabel registerLabel = new JLabel();
    JLabel usernameLabel = new JLabel();
    JLabel passwordLabel = new JLabel();

    JTextField usernameTextField = new JTextField();
    JTextField passwordTextField = new JTextField();

    JButton button = new JButton("Register");

    JMenuBar menuBar = new JMenuBar();

    JMenu authMenu = new JMenu("Auth");
    JMenuItem loginItem = new JMenuItem("Login");
    JMenuItem registerItem = new JMenuItem("Register");

    public Register() {
        this.frame.setJMenuBar(this.menuBar);
        this.menuBar.add(this.authMenu);

        this.authMenu.add(this.loginItem);
        this.authMenu.add(this.registerItem);

        this.registerLabel.setText("Register");
        this.usernameLabel.setText("Username : ");
        this.passwordLabel.setText("Password : ");

        this.registerLabel.setBounds(0, 0, 100, 30);
        this.usernameLabel.setBounds(0, 40, 100, 30);
        this.passwordLabel.setBounds(0, 80, 100, 30);
        this.usernameTextField.setBounds(120, 40, 150, 25);
        this.passwordTextField.setBounds(120, 80, 150, 25);
        this.button.setBounds(120, 130, 150, 25);

        this.button.addActionListener(this);
        this.loginItem.addActionListener(this);

        this.frame.add(this.button);
        this.frame.add(this.usernameTextField);
        this.frame.add(this.passwordTextField);
        this.frame.add(this.registerLabel);
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
                    if (Method.isUsernameExist(this.usernameTextField.getText())) {

                        Method.appendLine("users-database.txt",
                                (Method.countFileLine("users-database.txt") + 1) + ","
                                        + this.usernameTextField.getText() + "," + this.passwordTextField.getText()
                                        + "," + "cashier");

                        JOptionPane.showMessageDialog(null, "REGISTER SUCCESS!", "SUCCESS",
                                JOptionPane.INFORMATION_MESSAGE);

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
                        JOptionPane.showMessageDialog(null, "YOU ENTERED EXISTED USERNAME", "INVALID",
                                JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "USERNAME FIELD AND PASSWORD FIELD IS EMPTY!", "INVALID",
                            JOptionPane.WARNING_MESSAGE);
                }

            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, "Contact Support!", "INVALID", JOptionPane.WARNING_MESSAGE);
            }
        }

        if (e.getSource() == this.loginItem) {
            this.frame.dispose();

            new Login();
        }
    }

}
