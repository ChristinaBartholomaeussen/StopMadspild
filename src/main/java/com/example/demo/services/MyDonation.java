package com.example.demo.services;

import com.example.demo.models.DonationClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MyDonation {


    DonationClass donationClass = new DonationClass();

    public void writeDonationToFile(double input) throws IOException {



        File file = new File("src/main/resources/TextFiles/donation");

        FileWriter myWriter = new FileWriter(file, true);

        myWriter.write(input + "\n");
        myWriter.close();

        Scanner myReader = new Scanner(file);

        String line;

        double total =0;
        while(myReader.hasNext()){
            line = myReader.nextLine();


            String[] splits = line.split(" ");
            for(String s : splits){
                total += Double.parseDouble(s);
                donationClass.setTotalDonation(total);
            }

        }
        myReader.close();
        System.out.println(total);






}
}
