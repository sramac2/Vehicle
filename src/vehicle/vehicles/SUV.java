/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle.vehicles;

/**
 *
 * @author sramac1
 */
public class SUV extends Vehicle{
    private int storage;
    private int seats;
    public SUV(String description, int mpg, int seats,String vin, int storage){
        super(description,mpg,vin);
        this.storage = storage;
        this.seats = seats;
    }
    
    public String toString(){
         return super.getDescription()+"(SUV) MPG: "+super.getMpg()+
                " Seating: "+seats+" Storage: "+storage+ "cu.ft. VIN: "+getVin();
    }
    }

