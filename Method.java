package com;

import java.io.*;
import java.io.IOException;
import com.auth.*;

public class Method {
    public static boolean usernameAndPasswordMatch(String username, String password) throws IOException {

        FileReader fileReader = new FileReader("users-database.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        bufferedReader.mark(200);

        String eachLine = bufferedReader.readLine();

        while (eachLine != null) {
            String[] splittedEachLine = eachLine.split(",");

            if (splittedEachLine[1].equals(username) && splittedEachLine[2].equals(password)) {

                User.currentUser = splittedEachLine;

                bufferedReader.close();

                return true;
            }

            eachLine = bufferedReader.readLine();

        }

        bufferedReader.close();

        return false;

    }

    public static String[] getSpecificUserWithUsername(String username) throws IOException {
        FileReader fileReader = new FileReader("users-database.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        bufferedReader.mark(200);

        String eachLine = bufferedReader.readLine();

        while (eachLine != null) {
            String[] splittedEachLine = eachLine.split(",");

            if (splittedEachLine[1].equals(username)) {

                User.currentUser = splittedEachLine;

                bufferedReader.close();

                return splittedEachLine;
            }

            eachLine = bufferedReader.readLine();

        }

        bufferedReader.close();

        String[] kosong = {};

        return kosong;
    }

    public static boolean isUsernameExist(String username) throws Exception {

        FileReader fileReader = new FileReader("users-database.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        bufferedReader.mark(200);

        String eachLine = bufferedReader.readLine();

        while (eachLine != null) {
            String[] splittedEachLine = eachLine.split(",");

            if (splittedEachLine[1].equals(username)) {
                bufferedReader.close();

                return false;
            }

            eachLine = bufferedReader.readLine();
        }
        bufferedReader.close();

        return true;
    }

    public static int countFileLine(String fileName) throws Exception {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        bufferedReader.mark(200);

        String eachLine = bufferedReader.readLine();

        int counter = 0;

        while (eachLine != null) {
            counter++;
            eachLine = bufferedReader.readLine();
        }

        bufferedReader.close();

        return counter;
    }

    public static boolean appendLine(String fileName, String newLine) throws Exception {
        FileWriter fileWriter = new FileWriter(fileName, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.newLine();
        bufferedWriter.write(newLine);
        bufferedWriter.flush();

        return true;
    }

    public static String getAllTransaction() throws Exception {
        FileReader fileReader = new FileReader("transaksi-database.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        bufferedReader.mark(200);

        String result = "<html> List of all transaction<br/>";
        String eachLine = bufferedReader.readLine();

        while (eachLine != null) {
            String[] splittedEachLine = eachLine.split(",");

            result += "<br/><br/> Nama Pelangan : " + splittedEachLine[2] + " <br/> Nama Kasir :" + splittedEachLine[1]
                    + "<br/> Tangal transaksi : " + splittedEachLine[3] + "<br/> Nasi ayam qty : " + splittedEachLine[4]
                    + "<br/> Nasi gila qty : " + splittedEachLine[5] + "<br/> Nasi Pedas : " + splittedEachLine[6]
                    + "<br/> Nasi Goreng : " + splittedEachLine[7] + "<br/> Total pembelian : " + splittedEachLine[8]
                    + "<br/> <br/> ";

            eachLine = bufferedReader.readLine();
        }
        return result;
    }
}
