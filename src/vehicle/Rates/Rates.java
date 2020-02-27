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
import java.util.ArrayList;
import java.util.Iterator;        
public class Rates {
    private ArrayList<VehicleRates> vehicle_rates = new ArrayList<VehicleRates>();
    private Iterator<VehicleRates> iterator;
    
    public Rates(ArrayList<VehicleRates> vehicle_rates){
        this.vehicle_rates = vehicle_rates;
    }
    
    
    public double calcEstimatedCost(int vehicleType, String 
            estimatedRentalPeriod, int estimatedMilesDriven, boolean 
                    dailyInsur, boolean primeCustomer){
        double cost =0;
        switch(vehicleType){
            case 1 : cost = carCost(estimatedRentalPeriod, estimatedMilesDriven, 
                    dailyInsur, primeCustomer);break;
            case 2 : cost = SUVCost(estimatedRentalPeriod, estimatedMilesDriven, 
                    dailyInsur, primeCustomer);break;  
            case 3 : cost = TruckCost(estimatedRentalPeriod, estimatedMilesDriven, 
                    dailyInsur, primeCustomer);break;
        }
        return cost;
        
    }
    
    public VehicleRates setDefaultCarRates(){
        VehicleRates v = new CarRates();
        vehicle_rates.add(0, v);
        return v;
    }
    
    public VehicleRates setDefaultSUVRates(){
        VehicleRates v = new SUVRates();
        vehicle_rates.add(1, v);
        return v;
    }
    
    public VehicleRates setDefaultTruckRates(){
        VehicleRates v = new TruckRates();
        vehicle_rates.add(2, v);
        return v;
    }
    
    public VehicleRates getCarRates(){
        return vehicle_rates.get(0);
    }
    
    public VehicleRates getSUVRates(){
        return vehicle_rates.get(1);
    }
    
    public VehicleRates getTruckRates(){
        return vehicle_rates.get(2);
    }
    public void setCarRates(VehicleRates c){
        vehicle_rates.add(0, c);
    }
    
    public void setSUVRates(VehicleRates c){
        vehicle_rates.add(1, c);
    }
    
    public void setTruckRates(VehicleRates c){
        vehicle_rates.add(2, c);
    }
    public double calcActualCost(VehicleRates rates, int numDaysUsed, int numMilesDriven,
                boolean dailyInsur, boolean primeCustomer){
        double rate = 0;
        double miles = 0;
        double insur = 0;
        double prime = 0;
        if(numDaysUsed<7) rate = rates.getDailyRate()*numDaysUsed;
        else if(numDaysUsed>7&&numDaysUsed<30) rate = rates.getWeeklyRate()*
                (int)(numDaysUsed/7)+rates.getDailyRate()*(numDaysUsed%7);
        else if(numDaysUsed>30) rate = rates.getMonthlyRate()*(int)(numDaysUsed/30)
                +(int)((numDaysUsed%30)/7)*rates.getWeeklyRate()+(int)((numDaysUsed%30)%7)
                *rates.getDailyRate();
        miles = numMilesDriven*rates.getMileageChrg();
        if(dailyInsur){
            insur = numDaysUsed*rates.getDailyInsurRate();
        }
        if(primeCustomer){
            prime = rates.getMileageChrg()*100;
        }
        return rate+miles+insur-prime;
}

    
    private double carCost(String 
            estimatedRentalPeriod, int estimatedMilesDriven, boolean 
                    dailyInsur, boolean primeCustomer){
        VehicleRates v = new CarRates();
        double rate = 0;
        double insur = 0;
        double miles = 0;
        double prime = 0;
        if(primeCustomer){
            prime = v.getMileageChrg()*100;
        }
        if(estimatedRentalPeriod.charAt(0)=='d'||estimatedRentalPeriod.charAt(0)=='D'){
            String l = Character.toString(estimatedRentalPeriod.charAt(1));
            int t = Integer.parseInt(l);
            rate = v.getDailyRate()*t;
        }
        else if(estimatedRentalPeriod.charAt(0)=='m'||estimatedRentalPeriod.charAt(0)=='M'){
            String l = Character.toString(estimatedRentalPeriod.charAt(1));
            int t = Integer.parseInt(l);
            rate = v.getMonthlyRate()*t;
        }
        else if(estimatedRentalPeriod.charAt(0)=='w'||estimatedRentalPeriod.charAt(0)=='W'){
            String l = Character.toString(estimatedRentalPeriod.charAt(1));
            int t = Integer.parseInt(l);
            rate = v.getWeeklyRate()*t;
        }
        
        if(dailyInsur){
            String l = Character.toString(estimatedRentalPeriod.charAt(1));
            int t = Integer.parseInt(l);
            switch(estimatedRentalPeriod.charAt(0)){
                case 'd':insur = v.getDailyInsurRate()*t; break;
                case 'D':insur = v.getDailyInsurRate()*t; break;
                case 'm':insur = v.getDailyInsurRate()*t*30; break;
                case 'M':insur = v.getDailyInsurRate()*t*30; break;
                case 'w':insur = v.getDailyInsurRate()*t*7; break;
                case 'W':insur = v.getDailyInsurRate()*t*7; break;
        }
        }
        miles = v.getMileageChrg()*estimatedMilesDriven;
        
        return miles+rate+insur-prime;
    }
    

    private double SUVCost(String 
            estimatedRentalPeriod, int estimatedMilesDriven, boolean 
                    dailyInsur, boolean primeCustomer){
        VehicleRates v = new SUVRates();
        double rate = 0;
        double insur = 0;
        double miles = 0;
        double prime = 0;
        
        if(primeCustomer){
            prime = v.getMileageChrg()*100;
        }
        if(estimatedRentalPeriod.charAt(0)=='d'||estimatedRentalPeriod.charAt(0)=='D'){
            String l = Character.toString(estimatedRentalPeriod.charAt(1));
            int t = Integer.parseInt(l);
            rate = v.getDailyRate()*t;
        }
        else if(estimatedRentalPeriod.charAt(0)=='m'||estimatedRentalPeriod.charAt(0)=='M'){
            String l = Character.toString(estimatedRentalPeriod.charAt(1));
            int t = Integer.parseInt(l);
            rate = v.getMonthlyRate()*t;
        }
        else if(estimatedRentalPeriod.charAt(0)=='w'||estimatedRentalPeriod.charAt(0)=='W'){
            String l = Character.toString(estimatedRentalPeriod.charAt(1));
            int t = Integer.parseInt(l);            
            rate = v.getWeeklyRate()*t;
        }
        
        if(dailyInsur){
            String l = Character.toString(estimatedRentalPeriod.charAt(1));
            int t = Integer.parseInt(l);
            switch(estimatedRentalPeriod.charAt(0)){
                case 'd':insur = v.getDailyInsurRate()*t; break;
                case 'D':insur = v.getDailyInsurRate()*t; break;
                case 'm':insur = v.getDailyInsurRate()*t*30; break;
                case 'M':insur = v.getDailyInsurRate()*t*30; break;
                case 'w':insur = v.getDailyInsurRate()*t*7; break;
                case 'W':insur = v.getDailyInsurRate()*t*7; break;
            }
        }
        miles = v.getMileageChrg()*estimatedMilesDriven;
        
        return miles+rate+insur-prime;
    
    }
    
    private double TruckCost(String estimatedRentalPeriod, int estimatedMilesDriven, 
                    boolean dailyInsur, boolean primeCustomer){
          VehicleRates v = new TruckRates();
        double rate = 0;
        double insur = 0;
        double miles = 0;
        double prime = 0;
        if(primeCustomer){
            prime = v.getMileageChrg()*100;
        }
        if(estimatedRentalPeriod.charAt(0)=='d'||estimatedRentalPeriod.charAt(0)=='D'){
            String l = Character.toString(estimatedRentalPeriod.charAt(1));
            int t = Integer.parseInt(l);
            rate = v.getDailyRate()*t;
        }
        else if(estimatedRentalPeriod.charAt(0)=='m'||estimatedRentalPeriod.charAt(0)=='M'){
            String l = Character.toString(estimatedRentalPeriod.charAt(1));
            int t = Integer.parseInt(l);
            rate = v.getMonthlyRate()*t;
        }
        else if(estimatedRentalPeriod.charAt(0)=='w'||estimatedRentalPeriod.charAt(0)=='W'){
            String l = Character.toString(estimatedRentalPeriod.charAt(1));
            int t = Integer.parseInt(l);
            rate = v.getWeeklyRate()*t;
        }
        
        if(dailyInsur){
            String l = Character.toString(estimatedRentalPeriod.charAt(1));
            int t = Integer.parseInt(l);
            switch(estimatedRentalPeriod.charAt(0)){
                case 'd':insur = v.getDailyInsurRate()*t; break;
                case 'D':insur = v.getDailyInsurRate()*t; break;
                case 'm':insur = v.getDailyInsurRate()*t*30; break;
                case 'M':insur = v.getDailyInsurRate()*t*30; break;
                case 'w':insur = v.getDailyInsurRate()*t*7; break;
                case 'W':insur = v.getDailyInsurRate()*t*7; break;
            }
        }
        miles = v.getMileageChrg()*estimatedMilesDriven;
        
        return miles+rate+insur-prime;
                    
    }
}
