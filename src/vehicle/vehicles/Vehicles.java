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
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Iterator;
public class Vehicles {
    
    private ArrayList<Vehicle> agency_vehicles;
    private Iterator<Vehicle> iterator;
    
    public Vehicles(){
        agency_vehicles = new ArrayList<Vehicle>();
        agency_vehicles.add(new Car("Honda Accord",1232,"abc1",4));
        iterator = agency_vehicles.iterator();
    }
    public void addVehicle(Vehicle v){
        agency_vehicles.add(v);
        iterator = agency_vehicles.iterator();
    }
    
    public void remove(String vin){
        for(int i =0; i<= agency_vehicles.size()-1;i++){
            if(agency_vehicles.get(i).getVin().equals(vin)){
                agency_vehicles.remove(i);
                iterator = agency_vehicles.iterator();
            }
        }
    }
    
    public Vehicle getVehicle(String vin) throws VINNotFoundException{
        int j = 0;
        for(int i=0; i< agency_vehicles.size();i++){
            Vehicle v = agency_vehicles.get(i);
            if(v.getVin().equals(vin)){
                return v;
            }
        }
        iterator = agency_vehicles.iterator();
        throw new VINNotFoundException();
    }
    
    public Vehicle getNext(){
        return iterator.next();
    }
    
    public boolean hasNext(){
         return iterator.hasNext();
    }
    
    public void reset(){
        
    }
    
    public Iterator<Vehicle> getIterator(){
        return iterator;
    }
    
    public ArrayList<Vehicle> getVehicles(){
        return agency_vehicles;
    }
    
    public void setIterator(Iterator<Vehicle> i){
        iterator = i;
    }
}