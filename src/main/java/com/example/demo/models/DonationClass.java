package com.example.demo.models;

public class DonationClass {


    private double totalDonation;



    public DonationClass(double totalDonation) {
        this.totalDonation = totalDonation;
    }

    public DonationClass() {}


    public double getTotalDonation(){
        return totalDonation;
    }

    public void setTotalDonation(double totalDonation){
        this.totalDonation = totalDonation;
    }



}
