package com.example.demo.controllers;

import com.example.demo.models.DonationClass;
import com.example.demo.services.MyDonation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
public class IndexController
{
    DonationClass donationToDisplay = new DonationClass();

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
    public String index(Model donationModel)
    {
        donationModel.addAttribute("donationToDisplay", donationToDisplay);
        return "donation";

    }

    @PostMapping("/postDonation")
    public String postDonation(WebRequest dataFromform) throws IOException {
        MyDonation myDonation = new MyDonation();

        double value = Double.valueOf(dataFromform.getParameter("amount"));

        DonationClass donationClass = new DonationClass(value);
        myDonation.writeDonationToFile(value);
        donationToDisplay = donationClass;

        return "redirect:/postDonationStart";
    }

    @GetMapping("/omOrg")
    public String omOrganisationen()
    {
        return "omOrganisationen";
    }
}


