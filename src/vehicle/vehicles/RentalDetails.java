/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle.vehicles;

/**
 *
 * @author RXD0512A
 */
public class RentalDetails {
    private int vehicle_type;
    private String rental_period;
    private int miles_driven;
    private boolean insur_option;
    private boolean prime_customer;
    
    public RentalDetails(int vehicle_type,String rental_period, int miles_driven, 
            boolean insur_option,boolean prime_customer){
        this.vehicle_type = vehicle_type;
        this.insur_option = insur_option;
        this.miles_driven =miles_driven;
        this.rental_period = rental_period;
        this.prime_customer = prime_customer;
    }
    
    public int getVehicleType(){
        return vehicle_type;
    }
    
    public int getMilesDriven(){
        return miles_driven;
    }
    
    public String getRentalPeriod(){
        return rental_period;
    }
    
    public boolean isPrimeCustomer(){
        return prime_customer;
    }
    
    public boolean isInsurOption(){
        return insur_option;
    }
    
}
