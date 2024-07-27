package com.widat;

import com.widat.entity.Response;
import com.widat.service.InstallmentCalculation;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testInstallmentCalculationForMobil()
    {
        InstallmentCalculation installmentCalculation = new InstallmentCalculation();
        List<Response> result = installmentCalculation.calc("mobil",75000000, 3);
        assertEquals(2250000.0, result.get(0).getMonthlyInstallment());
        assertEquals(8.0, result.get(0).getRate());
    }
    public void testInstallmentCalculationForMotor()
    {
        InstallmentCalculation installmentCalculation = new InstallmentCalculation();
        List<Response> result = installmentCalculation.calc("motor",12000000, 1);
        assertEquals(1090000.0, result.get(0).getMonthlyInstallment());
        assertEquals(9.0, result.get(0).getRate());
    }
}
