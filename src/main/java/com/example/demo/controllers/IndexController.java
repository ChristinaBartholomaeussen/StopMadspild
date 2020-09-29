package com.example.demo.controllers;

import com.example.demo.models.DonationClass;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@Controller
public class IndexController
{
    DonationClass donationToDisplay = new DonationClass();

    @GetMapping("/")
    public String index()
    {
        return "forside";
    }

    @GetMapping("/postDonationStart")
    public String index(Model donationModel)
    {
        donationModel.addAttribute("donationToDisplay", donationToDisplay);
        return "donation";

    }


    @PostMapping("/postDonation")
    public String postDonation(WebRequest dataFromform)
    {

        double value = Double.valueOf(dataFromform.getParameter("amount"));

        DonationClass donationClass = new DonationClass(value);

        donationToDisplay = donationClass;
        System.out.println(value);

        return "redirect:/postDonationStart";


    }
}


