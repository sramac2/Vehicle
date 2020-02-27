/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle.vehicles;

import vehicle.Cost;

/**
 *
 * @author sramac1
 */
public abstract class Vehicle {
    private String description; // make-model for cars/suvs, length for trucks
    private int mpg; // miles per gallon
    private String vin; // unique vehicle identification number
    private Reservation resv; // a null value means that the vehicle is not reserved
    private Cost cost;
    
    public Vehicle(String description, int mpg, String vin){
        this.description = description;
        this.mpg = mpg;
        this.vin = vin;
        resv = null;
        cost = null;
    }
    public String getDescription(){
        return description;
    }
    
    public int getMpg(){
        return mpg;
    }
    
    public String getVin(){
        return vin;
    }
    
    public Reservation getReservation(){
        return resv;
    }
    
    public abstract String toString();
    
    public boolean isReserved(){
        return resv!=null;
    }
    
    public Cost getCost(){
        return cost;
    }
    
    public void setCost(Cost cost){
        this.cost = cost;   
    }
    
    public void reserve(Reservation resv){
        this.resv = resv;
    }
    
    public void cancelReservation(Reservation r) 
            throws UnreservedVehicleException{
        if(resv.equals(r)){
            resv = null;
        }
        else{
            throw new UnreservedVehicleException();
        }
    }
}
