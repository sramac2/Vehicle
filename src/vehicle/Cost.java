/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle;

import vehicle.Rates.VehicleRates;

/**
 *
 * @author RXD0512A
 */
public class Cost {
    private double daily_rate;
    private double weekly_rate;
    private double monthly_rate;
    private double mileage_chrg;
    private double daily_insur_rate;
    
    public Cost(VehicleRates v){
        daily_rate = v.getDailyRate();
        weekly_rate = v.getWeeklyRate();
        monthly_rate = v.getMonthlyRate();
        mileage_chrg = v.getMileageChrg();
        daily_insur_rate = v.getDailyInsurRate();
    }
}
