package com.widat.service;

public abstract class BaseCalculation {

    public static final double INTEREST_RATE_MOBIL_BASE = 8.0;
    public static final double INTEREST_RATE_MOTOR_BASE = 9.0;
    public static final double EVERY_ONE_YEAR_RATE_ADDED = 0.1;
    public static final double EVERY_TWO_YEAR_RATE_ADDED = 0.5;

    public double loanTotalCalc(double pokokPinjaman, double interest_rate){
        return (pokokPinjaman*(interest_rate/100.0)) + pokokPinjaman;
    }

    public double installmentMonthlyCalc(double totalPinjaman, int tenor, int index){
        return totalPinjaman / ((12 * tenor ) - index * 12);
    }

}

