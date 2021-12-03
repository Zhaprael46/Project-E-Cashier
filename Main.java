package com.pages;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {

    JFrame frame = new JFrame();

    JLabel title = new JLabel();
    JLabel nasiGorengLabel1 = new JLabel();
    JLabel nasiAyamLabel1 = new JLabel();
    JLabel nasiPedasLabel1 = new JLabel();
    JLabel nasiGilaLabel1 = new JLabel();

    JButton addbuttonNasiAyam = new JButton("+");
    JButton addbuttonNasiPedas = new JButton("+");
    JButton addbuttonNasiGila = new JButton("+");
    JButton addbuttonNasiGoreng = new JButton("+");

    JButton minButtonNasiAyam = new JButton("-");
    JButton minButtonNasiPedas = new JButton("-");
    JButton minButtonNasiGila = new JButton("-");
    JButton minButtonNasiGoreng = new JButton("-");

    JLabel nasiGorengLabel2 = new JLabel();
    JLabel nasiAyamLabel2 = new JLabel();
    JLabel nasiPedasLabel2 = new JLabel();
    JLabel nasiGilaLabel2 = new JLabel();

    double totalHarga = 0;
    JLabel totalHargaLabel = new JLabel();

    int nasiGorengLabel2Counter = 0;
    int nasiAyamLabel2Counter = 0;
    int nasiPedasLabel2Counter = 0;
    int nasiGilaLabel2Counter = 0;

    JLabel namaPemesanLabel = new JLabel();
    JLabel uangYangDiberiLabel = new JLabel();

    JTextField namaPemesanField = new JTextField();
    JTextField uangYangDiberiField = new JTextField();

    JButton orderButton = new JButton("Order");

    private static String namaPembeli = "";
    private static double uangYangDiberi = 0;
    private static double totalBelanja = 0;
    private static int nasiAyamQty = 0;
    private static int nasiGorengQty = 0;
    private static int nasiPedasQty = 0;
    private static int nasiGilaQty = 0;

    public Main() {
        this.title.setText("Warung Duniawi");

        this.nasiAyamLabel1.setText("Nasi Ayam($10) : ");
        this.nasiPedasLabel1.setText("Nasi Pedas($15) : ");
        this.nasiGilaLabel1.setText("Nasi Gila($25) : ");
        this.nasiGorengLabel1.setText("Nasi Goreng($30) : ");

        this.nasiAyamLabel2.setText("Nasi Ayam : " + this.nasiAyamLabel2Counter);
        this.nasiGorengLabel2.setText("Nasi Goreng : " + this.nasiGorengLabel2Counter);
        this.nasiGilaLabel2.setText("Nasi Gila : " + this.nasiGilaLabel2Counter);
        this.nasiPedasLabel2.setText("Nasi Pedas : " + this.nasiPedasLabel2Counter);

        this.totalHargaLabel.setText("$ " + this.totalHarga);

        this.namaPemesanLabel.setText("Nama Pemesanan : ");
        this.uangYangDiberiLabel.setText("Uang Yang Diberikan : ");

        this.title.setBounds(20, 20, 200, 40);

        this.nasiAyamLabel1.setBounds(20, 50, 200, 40);
        this.nasiPedasLabel1.setBounds(20, 100, 200, 40);
        this.nasiGilaLabel1.setBounds(20, 150, 200, 40);
        this.nasiGorengLabel1.setBounds(20, 200, 200, 40);

        this.addbuttonNasiAyam.setBounds(150, 50, 100, 30);
        this.addbuttonNasiPedas.setBounds(150, 100, 100, 30);
        this.addbuttonNasiGila.setBounds(150, 150, 100, 30);
        this.addbuttonNasiGoreng.setBounds(150, 200, 100, 30);

        this.minButtonNasiAyam.setBounds(300, 50, 100, 30);
        this.minButtonNasiPedas.setBounds(300, 100, 100, 30);
        this.minButtonNasiGila.setBounds(300, 150, 100, 30);
        this.minButtonNasiGoreng.setBounds(300, 200, 100, 30);

        this.nasiAyamLabel2.setBounds(20, 300, 120, 40);
        this.nasiGorengLabel2.setBounds(20, 350, 120, 40);
        this.nasiGilaLabel2.setBounds(20, 400, 120, 40);
        this.nasiPedasLabel2.setBounds(20, 450, 120, 40);

        this.totalHargaLabel.setBounds(20, 500, 120, 40);

        this.namaPemesanLabel.setBounds(150, 300, 150, 30);
        this.uangYangDiberiLabel.setBounds(150, 350, 150, 30);

        this.namaPemesanField.setBounds(300, 300, 150, 30);
        this.uangYangDiberiField.setBounds(300, 350, 150, 30);

        this.orderButton.setBounds(300, 400, 150, 30);

        this.frame.add(this.title);

        this.frame.add(this.nasiAyamLabel1);
        this.frame.add(this.nasiPedasLabel1);
        this.frame.add(this.nasiGilaLabel1);
        this.frame.add(this.nasiGorengLabel1);

        this.frame.add(this.addbuttonNasiAyam);
        this.frame.add(this.addbuttonNasiPedas);
        this.frame.add(this.addbuttonNasiGila);
        this.frame.add(this.addbuttonNasiGoreng);

        this.frame.add(this.minButtonNasiAyam);
        this.frame.add(this.minButtonNasiPedas);
        this.frame.add(this.minButtonNasiGila);
        this.frame.add(this.minButtonNasiGoreng);

        this.frame.add(this.nasiAyamLabel2);
        this.frame.add(this.nasiGorengLabel2);
        this.frame.add(this.nasiGilaLabel2);
        this.frame.add(this.nasiPedasLabel2);

        this.frame.add(totalHargaLabel);

        this.frame.add(this.namaPemesanLabel);
        this.frame.add(this.uangYangDiberiLabel);

        this.frame.add(this.namaPemesanField);
        this.frame.add(this.uangYangDiberiField);

        this.frame.add(this.orderButton);

        this.addbuttonNasiAyam.addActionListener(this);
        this.addbuttonNasiGila.addActionListener(this);
        this.addbuttonNasiPedas.addActionListener(this);
        this.addbuttonNasiGoreng.addActionListener(this);

        this.minButtonNasiAyam.addActionListener(this);
        this.minButtonNasiGila.addActionListener(this);
        this.minButtonNasiPedas.addActionListener(this);
        this.minButtonNasiGoreng.addActionListener(this);

        this.orderButton.addActionListener(this);

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(500, 700);
        this.frame.setResizable(false);
        this.frame.setLayout(null);
        this.frame.setVisible(true);

    }

    public static String getNamaPembeli() {
        return namaPembeli;
    }

    public static double getUangYangDiberi() {
        return uangYangDiberi;
    }

    public static double gettotalBelanja() {
        return totalBelanja;
    }

    public static int getNasiAyamQty() {
        return nasiAyamQty;
    }

    public static int getNasiPedasQty() {
        return nasiPedasQty;
    }

    public static int getNasiGorengQty() {
        return nasiGorengQty;
    }

    public static int getNasiGilaQty() {
        return nasiGilaQty;
    }

    public static int getTotalQty() {
        return nasiAyamQty + nasiGilaQty + nasiGorengQty + nasiPedasQty;
    }

    public static double getKembalian() {
        return uangYangDiberi - totalBelanja;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.orderButton) {
            try {
                if ((this.nasiPedasLabel2Counter > 0 || this.nasiGorengLabel2Counter > 0
                        || this.nasiAyamLabel2Counter > 0 || this.nasiGilaLabel2Counter > 0)
                        && (!this.namaPemesanField.getText().isEmpty() && !this.uangYangDiberiField.getText().isEmpty())
                        && Double.parseDouble(this.uangYangDiberiField.getText()) >= this.totalHarga) {

                    this.frame.dispose();

                    uangYangDiberi = Double.parseDouble(this.uangYangDiberiField.getText());
                    namaPembeli = this.namaPemesanField.getText();
                    totalBelanja = this.totalHarga;

                    nasiAyamQty = this.nasiAyamLabel2Counter;
                    nasiPedasQty = this.nasiPedasLabel2Counter;
                    nasiGilaQty = this.nasiGilaLabel2Counter;
                    nasiGorengQty = this.nasiGorengLabel2Counter;

                    new Struk();

                } else {
                    System.out.println("gagal");
                }
            } catch (Exception error) {
                System.out.println("Hubungi Support!");
            }

        }

        if (e.getSource() == this.addbuttonNasiAyam) {
            this.nasiAyamLabel2Counter++;
            this.totalHarga += 10;

            this.totalHargaLabel.setText("$ " + this.totalHarga);

            this.nasiAyamLabel2.setText("Nasi Ayam : " + this.nasiAyamLabel2Counter);

        }
        if (e.getSource() == this.addbuttonNasiPedas) {
            this.nasiPedasLabel2Counter++;
            this.totalHarga += 15;

            this.totalHargaLabel.setText("$ " + this.totalHarga);

            this.nasiPedasLabel2.setText("Nasi Pedas : " + this.nasiPedasLabel2Counter);
        }
        if (e.getSource() == this.addbuttonNasiGoreng) {
            this.nasiGorengLabel2Counter++;
            this.totalHarga += 30;

            this.totalHargaLabel.setText("$ " + this.totalHarga);
            this.nasiGorengLabel2.setText("Nasi Goreng : " + this.nasiGorengLabel2Counter);

        }
        if (e.getSource() == this.addbuttonNasiGila) {
            this.nasiGilaLabel2Counter++;
            this.totalHarga += 25;

            this.totalHargaLabel.setText("$ " + this.totalHarga);
            this.nasiGilaLabel2.setText("Nasi Gila : " + this.nasiGilaLabel2Counter);
        }

        if (e.getSource() == this.minButtonNasiAyam) {
            if (nasiAyamLabel2Counter != 0) {
                this.nasiAyamLabel2Counter--;
                this.totalHarga -= 10;

                this.totalHargaLabel.setText("$ " + this.totalHarga);

                this.nasiAyamLabel2.setText("Nasi Ayam : " + this.nasiAyamLabel2Counter);
            }

        }
        if (e.getSource() == this.minButtonNasiPedas) {
            if (nasiPedasLabel2Counter != 0) {
                this.nasiPedasLabel2Counter--;
                this.totalHarga -= 15;

                this.totalHargaLabel.setText("$ " + this.totalHarga);

                this.nasiPedasLabel2.setText("Nasi Pedas : " + this.nasiPedasLabel2Counter);
            }
        }
        if (e.getSource() == this.minButtonNasiGoreng) {
            if (nasiGorengLabel2Counter != 0) {
                this.nasiGorengLabel2Counter--;
                this.totalHarga -= 30;

                this.totalHargaLabel.setText("$ " + this.totalHarga);
                this.nasiGorengLabel2.setText("Nasi Goreng : " + this.nasiGorengLabel2Counter);
            }
        }
        if (e.getSource() == this.minButtonNasiGila) {
            if (nasiGilaLabel2Counter != 0) {
                this.nasiGilaLabel2Counter--;
                this.totalHarga -= 25;

                this.totalHargaLabel.setText("$ " + this.totalHarga);
                this.nasiGilaLabel2.setText("Nasi Gila : " + this.nasiGilaLabel2Counter);
            }
        }

    }

}
