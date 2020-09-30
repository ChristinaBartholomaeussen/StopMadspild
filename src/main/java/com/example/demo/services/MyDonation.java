package com.example.demo.services;

import com.example.demo.models.DonationClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MyDonation {

    File file = new File("src/main/resources/TextFiles/donation");
    DonationClass donationClass = new DonationClass();

    public double writeToFile(double donation) throws IOException {

        String donationToFile = Double.toString(donation);

        FileWriter myWriter = new FileWriter(file, true);

        myWriter.write(donationToFile + "\n");
        myWriter.close();

        return donation;

    }

    public double calculateTotalDonation(double donation) throws IOException {


        writeToFile(donation);

        double total = 0;

        Scanner scanFile = new Scanner(file);

        while(scanFile.hasNextLine()){
            String data = scanFile.nextLine();

            donation = Double.parseDouble(data);
            total = total + donation;
            donationClass.setTotalDonation(total);



        }
        double d = donationClass.getTotalDonation();
        scanFile.close();

        return d;

    }

    public double readAndCalculate() throws FileNotFoundException {

        double total = 0;

        Scanner scanFile = new Scanner(file);

        while(scanFile.hasNextLine()){
            String line = scanFile.nextLine();

            total += Double.valueOf(line);

        }

        System.out.println(total);
        return total;
    }






}
