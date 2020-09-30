package com.example.demo.controllers;

import com.example.demo.models.BeregnerModel;
import com.example.demo.models.DonationClass;
import com.example.demo.services.BeregnerService;
import com.example.demo.services.MyDonation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;

@Controller
public class IndexController
{
    DonationClass donationToDisplay = new DonationClass();

    MyDonation my = new MyDonation();


    @GetMapping("/")
    public String index()
    {
        return "index";
    }

    @GetMapping("/aktion")
    public String aktion()
    {
        return "aktion";
    }

    @GetMapping("/postDonationStart")
    public String index(Model donationModel) throws FileNotFoundException {

        donationToDisplay.setTotalDonation(my.readAndCalculate());
        donationModel.addAttribute("donationToDisplay", donationToDisplay);
        return "donation";

    }

    @PostMapping("/postDonation")
    public String postDonation(WebRequest dataFromform) throws IOException {

        MyDonation myDonation = new MyDonation();

        double value = Double.valueOf(dataFromform.getParameter("donation"));

        DonationClass donationClass = new DonationClass(myDonation.calculateTotalDonation(value));

        donationToDisplay = donationClass;

        return "redirect:/postDonationStart";
    }

    @GetMapping("/omOrg")
    public String omOrganisationen()
    {
        return "omOrganisationen";
    }

    //Beregner start
    BeregnerModel beregnerModel = new BeregnerModel();

    BeregnerService beregnerService = new BeregnerService();

    @GetMapping ("/calc")
    public String calc(Model calcModel) {

        calcModel.addAttribute("beregnerModel", beregnerModel);

        return "beregner";
    }

    @PostMapping("/postCalc")
    public String postCalc(WebRequest dataFromForm) {

        double value = Double.valueOf(dataFromForm.getParameter("output"));

        BeregnerModel calcFromForm = new BeregnerModel(beregnerService.calc(value));

        beregnerModel = calcFromForm;

        return "redirect:/calc";
    } //Beregner slut
}


