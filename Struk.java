package com.pages;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.Method;
import com.auth.Login;
import com.auth.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter cla

public class Struk implements ActionListener {
    JFrame frame = new JFrame();
    JLabel namaLabel = new JLabel();

    JLabel nasiAyamQtyLabel = new JLabel();
    JLabel nasiGorengQtyLabel = new JLabel();
    JLabel nasiGilaQtyLabel = new JLabel();
    JLabel nasiPedasQtyLabel = new JLabel();

    JLabel totalQtyLabel = new JLabel();

    JLabel totalYangWajibDibayarLabel = new JLabel();
    JLabel uangDiberikan = new JLabel();
    JLabel kembalianYangHarusDiberi = new JLabel();

    JButton done = new JButton("Transaksi Selesai");
    JButton cancel = new JButton("Transaksi Dibatalkan");

    public Struk() {
        this.namaLabel.setText("Nama Pembeli : " + Main.getNamaPembeli());

        this.nasiAyamQtyLabel.setText("Nasi Ayam Qty : " + Main.getNasiAyamQty());
        this.nasiGorengQtyLabel.setText("Nasi Goreng Qty : " + Main.getNasiGorengQty());
        this.nasiGilaQtyLabel.setText("Nasi Gila Qty : " + Main.getNasiGilaQty());
        this.nasiPedasQtyLabel.setText("Nasi Pedas Qty : " + Main.getNasiPedasQty());

        this.totalQtyLabel.setText("Total Qty : " + Main.getTotalQty());

        this.totalYangWajibDibayarLabel.setText("Total Amount : " + Main.gettotalBelanja());
        this.uangDiberikan.setText("Uang Yang diberikan : " + Main.getUangYangDiberi());
        this.kembalianYangHarusDiberi.setText("Kembalian : " + Main.getKembalian());

        this.namaLabel.setBounds(20, 30, 500, 20);

        this.nasiAyamQtyLabel.setBounds(20, 80, 500, 20);
        this.nasiGorengQtyLabel.setBounds(20, 110, 500, 20);
        this.nasiGilaQtyLabel.setBounds(20, 140, 500, 20);
        this.nasiPedasQtyLabel.setBounds(20, 170, 500, 20);

        this.totalQtyLabel.setBounds(20, 220, 500, 20);

        this.totalYangWajibDibayarLabel.setBounds(20, 230, 500, 200);
        this.uangDiberikan.setBounds(20, 250, 500, 200);
        this.kembalianYangHarusDiberi.setBounds(20, 310, 500, 200);

        this.done.setBounds(20, 420, 200, 30);
        this.cancel.setBounds(20, 460, 200, 30);

        this.frame.add(this.namaLabel);

        this.frame.add(this.nasiAyamQtyLabel);
        this.frame.add(this.nasiGorengQtyLabel);
        this.frame.add(this.nasiGilaQtyLabel);
        this.frame.add(this.nasiPedasQtyLabel);

        this.frame.add(this.totalQtyLabel);

        this.frame.add(this.totalYangWajibDibayarLabel);
        this.frame.add(this.uangDiberikan);
        this.frame.add(this.kembalianYangHarusDiberi);

        this.frame.add(this.done);
        this.frame.add(this.cancel);

        this.done.addActionListener(this);

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(500, 700);
        this.frame.setResizable(false);
        this.frame.setLayout(null);
        this.frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.done) {
            try {
                LocalDateTime myDateObj = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                String formattedDate = myDateObj.format(myFormatObj);

                String newLine = (Method.countFileLine("transaksi-database.txt") + 1) + "," + User.currentUser[1] + ","
                        + Main.getNamaPembeli() + "," + formattedDate + "," + Main.getNasiAyamQty() + ","
                        + Main.getNasiGilaQty() + "," + Main.getNasiPedasQty() + "," + Main.getNasiGorengQty() + ","
                        + Main.gettotalBelanja();

                Method.appendLine("transaksi-database.txt", newLine);

                JOptionPane.showMessageDialog(null, "TRANSACTION HAS BEEN COMPLETED!", "SUCCESS",
                        JOptionPane.INFORMATION_MESSAGE);

                this.frame.dispose();

                new Login();
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, "Contact Support!", "ERROR!", JOptionPane.WARNING_MESSAGE);

                this.frame.dispose();

                new Login();
            }

            if (e.getSource() == this.cancel) {
                JOptionPane.showMessageDialog(null, "TRANSACTION HAS BEEN CANCELED!", "CANCELED",
                        JOptionPane.WARNING_MESSAGE);

                this.frame.dispose();

                new Login();
            }
        }
    }
}
