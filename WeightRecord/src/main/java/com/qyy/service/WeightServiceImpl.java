package com.qyy.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class WeightServiceImpl implements WeightService {

    @Override
    public void addWeight(Double weight, ArrayList<Double> weights) {
        weights.add(weight);
    }
}
