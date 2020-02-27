/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle.UserInterfaces;

/**
 *
 * @author RXD0512A
 */
import vehicle.vehicles.ReservationDetails;
import vehicle.vehicles.Reservation;
import vehicle.vehicles.RentalDetails;
import vehicle.Account.Account;
import vehicle.Account.Accounts;
import vehicle.Transaction.Transaction;
import vehicle.Transaction.Transactions;
import vehicle.vehicles.Car;
import vehicle.vehicles.Vehicles;
import vehicle.vehicles.Truck;
import vehicle.vehicles.SUV;
import vehicle.vehicles.Vehicle;
import vehicle.Rates.CarRates;
import vehicle.Rates.TruckRates;
import vehicle.Rates.Rates;
import vehicle.Rates.VehicleRates;
import vehicle.Rates.SUVRates;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.*;
import java.util.Date;
public class SystemInterface {
    private static Rates agency_rates;
    private static Vehicles agency_vehicles;
    private static Accounts accounts;
    private static Transactions transactions_history;
    
    public static void initSystemInterface(Rates r, Vehicles v, Accounts a, Transactions t ){
        agency_rates = r;
        agency_vehicles = v;
        accounts = a;
        transactions_history = t;
    }
    
    public static ArrayList<String> addAccount(Account acct_info){
        accounts.add(acct_info);
        ArrayList<String> s = new ArrayList<String>();
        s.add(acct_info.toString());
        return s;
    }
    
    public static ArrayList<String> getAccount(String acct_num){
         ArrayList<String> s = new ArrayList<String>();
         ArrayList<String> vehicleReserved = new ArrayList<String>();
         s.add(accounts.getAccount(acct_num).toString());
         Account a = accounts.getAccount(acct_num);
         vehicleReserved = a.getVehiclesReserved();
         int size = vehicleReserved.size();
         for(int i =0; i<=size-1;i++){
             String vin = vehicleReserved.get(i);
             s.add(agency_vehicles.getVehicle(vin).toString());
         }
         return s;
    }
    
    public static String getReservations(Account a){
        ArrayList<String> s = new ArrayList<String>();
        ArrayList<String> vehicleReserved = new ArrayList<String>();
        String vehicles="";
        String veh="";
        vehicleReserved = a.getVehiclesReserved();
         int size = vehicleReserved.size();
         String vin = "";
         for(int i =0; i<=size-1;i++){
             vin = vehicleReserved.get(i);
             s.add(agency_vehicles.getVehicle(vin).toString());
         }
         Iterator iterator = s.iterator();
         while(iterator.hasNext()){
              vehicles = iterator.next().toString();
              veh   = veh +" " +vehicles;
         }
         
         return veh;

    }
    
    public static ArrayList<String> getAllAccounts(){
        ArrayList<String> s = new ArrayList<String>();
        while(accounts.hasNext()){
            Account account = accounts.getNext();
            s.add(account.toString());
            s.add(getReservations(account));
        }
        return s;
    }
    
    public static ArrayList<String> getCarRates(){
        VehicleRates v = new CarRates();
        ArrayList<String> s = new ArrayList<String>();
        s.add(v.toString());
        return s;
    }
    
     public static ArrayList<String> getSUVRates(){
        VehicleRates v = new SUVRates();
        ArrayList<String> s = new ArrayList<String>();
        s.add(v.toString());
        return s;
    }
     
     public static ArrayList<String> getTruckRates(){
        VehicleRates v = new TruckRates();
        ArrayList<String> s = new ArrayList<String>();
        s.add(v.toString());
        return s;
    } 
     
    public static ArrayList<String> getAvailCars(){
        ArrayList<String> s = new ArrayList<String>();
        while(agency_vehicles.hasNext()){
            Vehicle v = agency_vehicles.getNext();
            if(v instanceof Car&& !v.isReserved()){
                s.add(v.toString());
            }
        }
        agency_vehicles.setIterator(agency_vehicles.getVehicles().iterator());
        return s;
    }
    
    public static ArrayList<String> getAvailSUVs(){
        ArrayList<String> s = new ArrayList<String>();
        while(agency_vehicles.hasNext()){
            Vehicle v = agency_vehicles.getNext();
            if(v instanceof SUV && !v.isReserved()){
                s.add(v.toString());
            }
        }
        agency_vehicles.setIterator(agency_vehicles.getVehicles().iterator());
        return s;
    }
    
    public static ArrayList<String> getAvailTrucks(){
        ArrayList<String> s = new ArrayList<String>();
        while(agency_vehicles.hasNext()){
            Vehicle v = agency_vehicles.getNext();
            if(v instanceof Truck&& !v.isReserved()){
                s.add(v.toString());
            }
        }
       agency_vehicles.setIterator(agency_vehicles.getVehicles().iterator());
        return s;
    }
    
    public static ArrayList<String> getAllVehicles(){
        ArrayList<String> s = new ArrayList<String>();
        while(agency_vehicles.hasNext()){
            Vehicle v = agency_vehicles.getNext();
                s.add(v.toString()+"\nReserved: "+v.isReserved());
            }
        agency_vehicles.setIterator(agency_vehicles.getVehicles().iterator());
        return s;
        }
       
    public static ArrayList<String> getReservation(String vin){
        ArrayList<String> s = new ArrayList<String>();
        s.add(agency_vehicles.getVehicle(vin).getReservation().toString());
        return s;
    }    
    
    public static ArrayList<String> getAllReservations(){
        ArrayList<String> s = new ArrayList<String>();
        while(true){
            Vehicle v = agency_vehicles.getNext();
            if(v.isReserved()){
            s.add(v.getReservation().toString());
            }
            if(!agency_vehicles.hasNext())break;
        }
        return s;
    }
    
    public static ArrayList<String> cancelReservation(String acct_num,String vin){
        ArrayList<String> s = new ArrayList<String>();
        Reservation r = agency_vehicles.getVehicle(vin).getReservation();
        agency_vehicles.getVehicle(vin).cancelReservation(r);
        s.add(r.toString());
        return s;
        }
    
    public static ArrayList<String> makeReservation(ReservationDetails r){
        ArrayList<String> s = new ArrayList<String>();
        String credit_card = r.getCreditCardNum();
        String acct = r.getAcctNum();
        String vin = r.getVin();
        accounts.getAccount(acct).addVehicle(vin);
        
        String rental_period = r.getRentalPeriod();
        boolean insur = r.isInsurOption();
        Reservation reserve = new Reservation(credit_card,rental_period, insur);
        agency_vehicles.getVehicle(vin).reserve(reserve);        
        s.add(reserve.toString());
        return s;
    }
    
    public static ArrayList<String> getRentalRates(int veh_type){
        ArrayList<String> s = new ArrayList<String>();
        switch(veh_type){
            case 1: s.add(agency_rates.setDefaultCarRates().toString());break;
            case 2: s.add(agency_rates.setDefaultSUVRates().toString());break;
            case 3: s.add(agency_rates.setDefaultTruckRates().toString());break;
        }
        return s;
    }
    
    public static ArrayList<String> updateRates(VehicleRates v,int type){
         ArrayList<String> s = new ArrayList<String>();
         if(v instanceof SUVRates){
             agency_rates.setSUVRates(v);
             s.add(agency_rates.getSUVRates().toString());
         }
         else if(v instanceof CarRates){
             agency_rates.setCarRates(v);
             s.add(agency_rates.getCarRates().toString());
         }
         else if(v instanceof TruckRates){
             agency_rates.setTruckRates(v);
             s.add(agency_rates.getTruckRates().toString());
         }
         return s;
    }
    
    public static ArrayList<String>  estimatedRentalCost(RentalDetails details){
        ArrayList<String> s = new ArrayList<String>();
        double total = 0;
        int milesDriven = details.getMilesDriven();
        String rentalPeriod = details.getRentalPeriod();
        int vehType = details.getVehicleType();
        boolean insur = details.isInsurOption();
        boolean prime = details.isPrimeCustomer();
        total = agency_rates.calcEstimatedCost(vehType, rentalPeriod, milesDriven, insur, prime);
        s.add("Total Estimated cost: "+total);
        return s;
    }
    
    public static double estimatedTotalCost(RentalDetails details){
        ArrayList<String> s = new ArrayList<String>();
        double total = 0;
        int milesDriven = details.getMilesDriven();
        String rentalPeriod = details.getRentalPeriod();
        int vehType = details.getVehicleType();
        boolean insur = details.isInsurOption();
        boolean prime = details.isPrimeCustomer();
        total = agency_rates.calcEstimatedCost(vehType, rentalPeriod, milesDriven, insur, prime);
        return total;
    }
    
    public static ArrayList<String> processReturnedVehicle(String vin, 
            String rental_period, int num_days_driven){
        ArrayList<String> s = new ArrayList<String>();
        ArrayList<String> vins = new ArrayList<String>();
        Date d = new Date();
        Account a = new Account();
        while(accounts.hasNext()){
            a = accounts.getNext();
            vins = a.getVehiclesReserved();
            for(int i =0; i<vins.size();i++){
                if(vins.get(i).equals(vin)){
                    break;
                }
            }
        }
        Iterator iterator = accounts.getAllAccounts().iterator();
        accounts.setIterator(iterator);
        while(accounts.hasNext()){
            a = accounts.getNext();
            vins = a.getVehiclesReserved();
            for(int i =0; i<vins.size();i++){
                if(vins.get(i).equals(vin)){
                    vins.remove(i);
                    break;
                }
            }
            
        }
        iterator = accounts.getAllAccounts().iterator();
        accounts.setIterator(iterator);
        Vehicle v = agency_vehicles.getVehicle(vin);
        Reservation r = v.getReservation();
        v.cancelReservation(r);
        String acct_num = a.getAcctNum();
        String company_name = a.getCompanyName();
        int veh_type = 0;
        if(v instanceof Car){
            veh_type = 1;
        }
        else if(v instanceof SUV){
            veh_type = 2;
        }
        
        else if(v instanceof Truck){
            veh_type = 3;
        }
        boolean prime = a.isPrimeCustomer();
        RentalDetails rental = new RentalDetails(veh_type, rental_period, 
                num_days_driven, false, prime );
        double cost = estimatedTotalCost(rental);
        Transaction t = new Transaction(acct_num,company_name,cost,
                rental_period,d.toString(),"Car");
        transactions_history.add(t);
        s.add(t.toString());
        return s;
    }
    
    public static ArrayList<String> getAllTransactions(){
        ArrayList<String> s = new ArrayList<String>();
        while(transactions_history.hasNext()){
            s.add(transactions_history.getNext().toString());
        }
        return s;
    }
    
}
    

    

