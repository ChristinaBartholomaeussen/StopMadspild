package com.example.demo.models;

public class DonationClass {

    private double amount;
    private double totalDonation;


    public DonationClass(double totalDonation) {
        this.totalDonation = totalDonation;
    }

    public DonationClass(){}



    public double getTotalDonation(){
        return totalDonation;
    }

    public void setTotalDonation(double totalDonation){
        this.totalDonation = totalDonation;
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount){
        this.amount = amount;
    }

    public String toString()
    {
        return "Total donation: " + getTotalDonation();
    }

}
