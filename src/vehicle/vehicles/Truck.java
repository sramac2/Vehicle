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
public class Truck extends Vehicle{
    private int load;
     public Truck(String description, int mpg,String vin, int load){
        super(description,mpg,vin);
        this.load = load;
    }
     
    public String toString(){
        return super.getDescription()+"(Car) MPG: "+super.getMpg()+
                " Load Capacity: "+load+ " VIN: "+getVin();
    }
}
