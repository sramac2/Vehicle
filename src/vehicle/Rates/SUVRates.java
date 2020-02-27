/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle.Rates;

/**
 *
 * @author RXD0512A
 */
public class SUVRates extends VehicleRates{
    private double daily_rate = 29.95;
    private double weekly_rate = 189.95;
    private double monthly_rate = 679.95;
    private double mileage_chrg = 0.15;
    private double daily_insur_rate = 14.95;
    
    public SUVRates(double daily, double weekly, double monthly, double mileage, double insur){
        daily_rate = daily;
        weekly_rate = weekly;
        monthly_rate = monthly;
        mileage_chrg = mileage;
        daily_insur_rate = insur;
    }
    
    public SUVRates(){
        
    }
    public double getDailyRate(){
        return daily_rate;
    } 
    
    public double getWeeklyRate(){
        return weekly_rate;
    }
    
    public double getMonthlyRate(){
        return monthly_rate;
    }
    
    public double getMileageChrg(){
        return mileage_chrg;
    }
    
    public double getDailyInsurRate(){
        return daily_insur_rate;
    }
    public String toString(){
        return " daily Rate:"+daily_rate+" Weekly rate: "+weekly_rate+
                " Monthly rate:"+monthly_rate+" Mileage Charge: "+mileage_chrg
                +" Daily Insurance: "+daily_insur_rate;
    }
}

