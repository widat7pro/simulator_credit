package com.widat.entity;

import com.widat.util.CurrencyFormat;

public class Response extends BaseResponse implements PrintableResponse{

    private double monthlyInstallment;
    private double rate;

    public double getMonthlyInstallment() {
        return monthlyInstallment;
    }

    public void setMonthlyInstallment(double monthlyInstallment) {
        this.monthlyInstallment = monthlyInstallment;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public void print() {
        System.out.printf("tahun %d : %s/bln , Suku Bunga %.2f%% \n", (getIndexResponse()+1), CurrencyFormat.formatToRupiah(getMonthlyInstallment()), getRate());
    }
}
