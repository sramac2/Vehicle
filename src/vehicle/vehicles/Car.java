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
public class Car extends Vehicle{
    private int seats;
    public Car(String description, int mpg,String vin, int seats){
        super(description,mpg,vin);
        this.seats = seats;
    }
    
    public String toString(){
        return super.getDescription()+"(Car) MPG: "+super.getMpg()+
                " Seating: "+seats+ " VIN: "+getVin();
    }
}
