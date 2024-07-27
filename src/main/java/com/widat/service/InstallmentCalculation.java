package com.widat.service;

import com.widat.entity.Response;

import java.util.ArrayList;
import java.util.List;

public class InstallmentCalculation extends BaseCalculation{


    public List<Response> calc(String vehicle, double pokokPinjaman, int tenor){

        List<Response> result = new ArrayList<Response>();

        double installmentYearly = 0.0;
        double totalPinjaman = 0.0;

        double interest_rate = vehicle.equalsIgnoreCase("mobil") ? INTEREST_RATE_MOBIL_BASE : INTEREST_RATE_MOTOR_BASE ;

        for(int i=0; i < tenor; i++) {

            if (i > 0) {
                 if((double)i % 2.0 == 0){
                    interest_rate += EVERY_TWO_YEAR_RATE_ADDED;
                }else {
                    interest_rate += EVERY_ONE_YEAR_RATE_ADDED;
                }
            }

            totalPinjaman = loanTotalCalc(pokokPinjaman, interest_rate);
            double installmentMonthly = installmentMonthlyCalc(totalPinjaman, tenor, i);

            installmentYearly = installmentMonthly * 12;

            pokokPinjaman = totalPinjaman - installmentYearly;

            Response response = new Response();
            response.setIndexResponse(i);
            response.setMonthlyInstallment(installmentMonthly);
            response.setRate(interest_rate);

            result.add(response);
        }

        return result;
    }


}
