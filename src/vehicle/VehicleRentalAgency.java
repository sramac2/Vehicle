/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle;

/**
 *
 * @author RXD0512A
 */
import vehicle.UserInterfaces.SystemInterface;
import vehicle.UserInterfaces.UserInterface;
import vehicle.Account.Account;
import vehicle.Account.Accounts;
import vehicle.Transaction.Transactions;
import vehicle.vehicles.Car;
import vehicle.vehicles.Vehicles;
import vehicle.vehicles.SUV;
import vehicle.vehicles.Vehicle;
import vehicle.UserInterfaces.ManagerUI;
import vehicle.Rates.CarRates;
import vehicle.Rates.TruckRates;
import vehicle.Rates.Rates;
import vehicle.Rates.VehicleRates;
import vehicle.Rates.SUVRates;
import vehicle.UserInterfaces.EmployeeUI;
import java.util.Scanner;
import java.util.ArrayList;
public class VehicleRentalAgency {
    
        // user interface types
    private final int EMPLOYEE_UI = 1;
    private final int MANAGER_UI = 2;
    public static void main(String[] args) {
    // initialize system
    
        Vehicles agency_vehicles = new Vehicles(); // creates empty aggregation
        Accounts agency_accounts = new Accounts(); // creates empty aggregation
        Rates agency_rates = buildRates(); // creates fixed, hard-coded rates
        ArrayList<String>  s = new ArrayList<String>();
        s.add("abc2");
        ArrayList<String>  s1 = new ArrayList<String>();
        s1.add("abc3");
        Account acct = new Account("12345","Google Inc.",s,true);
        Account acct1 = new Account("12346","Facebook Inc.",s1,true);
        agency_accounts.add(acct);
        agency_accounts.add(acct1);
        Transactions transactions_history = new Transactions(); // creates empty aggregation
        // create a collection of agency vehicles
        SystemInterface.initSystemInterface(agency_rates, agency_vehicles, agency_accounts, transactions_history);
        populateVehicles(agency_vehicles);
        // prompt for type of user interface
        SystemInterface.initSystemInterface(agency_rates, agency_vehicles, agency_accounts, transactions_history);
        boolean quit = false;
        while(!quit){
        int UI_type = promptForUIType();
        // create appropriate UI
        UserInterface ui = buildUI(UI_type);
        // start user interface
        ui.start();
    }
    }
    
    public static void populateVehicles(Vehicles agency_vehicles){
        Vehicle v  = new Car("Mercedes-Benz CLA250",3344,"abc4",5);
        Vehicle v1 =  new SUV("Jaguar xj",2222,5,"abc2",35);
        Vehicle v2 =  new SUV("Audi A3",24,5,"abc3",25);
        agency_vehicles.addVehicle(v);
        agency_vehicles.addVehicle(v1);
        agency_vehicles.addVehicle(v2);
        
    }
    
    public static int promptForUIType(){
        System.out.println("You are employee-1/manager-2");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
    
    public static Rates buildRates(){
        VehicleRates v = new CarRates();
        VehicleRates v1 = new SUVRates();
        VehicleRates v2 = new TruckRates();
        ArrayList<VehicleRates> vr = new ArrayList<VehicleRates>();
        vr.add(v);
        vr.add(v1);
        vr.add(v2);
        return new Rates(vr);
    }
    
    public static UserInterface buildUI(int ui){
        if(ui == 1){
            return new EmployeeUI();
        }
        else{
            return new ManagerUI();
        } 
    }
    

}
