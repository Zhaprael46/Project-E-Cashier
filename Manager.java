package com.pages.manager;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import com.Method;
import com.auth.Login;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Manager implements ActionListener {
    JFrame frame = new JFrame();
    JScrollPane scrollPane = new JScrollPane();
    JButton backButton = new JButton("Logout");

    JLabel label = new JLabel();

    public Manager() {
        try {
            this.label.setText(Method.getAllTransaction());
        } catch (Exception E) {
            System.err.println(E);
        }

        this.scrollPane.setViewportView(this.label);

        this.backButton.addActionListener(this);

        this.frame.add(this.scrollPane);
        this.frame.add(this.backButton);
        this.frame.setSize(500, 500);
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLayout(new GridLayout(0, 1));
        this.frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.backButton) {
            this.frame.dispose();

            new Login();
        }
    }
}
