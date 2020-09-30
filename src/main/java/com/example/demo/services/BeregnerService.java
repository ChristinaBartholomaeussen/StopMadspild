package com.example.demo.services;

import com.example.demo.models.BeregnerModel;

public class BeregnerService {

    BeregnerModel beregnerModel = new BeregnerModel();

    public double calc(double value) {

        double output;

        output = value * 2.5;

        beregnerModel.setOutput(output);

        double d = beregnerModel.getOutput();

        return d;
    }
}
