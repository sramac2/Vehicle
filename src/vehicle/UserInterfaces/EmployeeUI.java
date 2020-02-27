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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import vehicle.Cost;
import vehicle.vehicles.RentalDetails;
import vehicle.vehicles.ReservationDetails;
public class EmployeeUI implements UserInterface{
    public void start(){
        
    
    int selection,option;
    ArrayList<String> results = new ArrayList<String>();
    Scanner user_input = new Scanner(System.in);
    RentalDetails rental_details;
    String acct_num;
    String rental_period = "d3";
    int num_days_driven = 2;
    String vin;
    Cost cost;
    
    boolean quit = false;
    while(!quit){
        displayMenu();
    selection = getCommand(user_input);
    switch(selection){
        case 1:option = getVehicleType(user_input);
        results = SystemInterface.getRentalRates(option);
        displayResults(results);
        break;
        
        case 2: 
            option = getVehicleType(user_input);
            switch(option){ 
            case 1: results = SystemInterface.getAvailCars();break;
            case 2: results = SystemInterface.getAvailSUVs();break;
            case 3: results = SystemInterface.getAvailTrucks();break;
        }
                displayResults(results);break;
        case 3: rental_details = getRentalDetails(user_input);
                results = SystemInterface.estimatedRentalCost(rental_details);
                displayResults(results);
                break;
        case 4: ReservationDetails reserv_details = getReservationDetails(user_input);
                    results = SystemInterface.makeReservation(reserv_details);
                    displayResults(results);break;
        case 5: acct_num = getAcctNumber(user_input);
                results = SystemInterface.getAccount(acct_num);
                displayResults(results);
                break;
        case 6: acct_num = getAcctNumber(user_input);
                vin = getVIN(user_input);
                results = SystemInterface.cancelReservation(acct_num, vin);
                displayResults(results);break;
        case 7: acct_num = getAcctNumber(user_input);
                vin = getVIN(user_input);
                String rental = getRentalPeriod(user_input); 
                num_days_driven = getDaysDriven(user_input);
                results = SystemInterface.processReturnedVehicle(vin, rental,num_days_driven);
                displayResults(results);
                break;
        case 8: quit = true;
    }}
        
    }
    
    public int getDaysDriven(Scanner input){
        System.out.println("Type the number of days driven");
        return input.nextInt();
    }
    public void displayMenu(){
        System.out.println("1-Displays Rental Rates");
        System.out.println("2-Displays available vehicles");
        System.out.println("3-Estimate the vehicel cost");
        System.out.println("4-Make a reservation");
        System.out.println("5-View corporate account");
        System.out.println("6-Cancel a reservation");
        System.out.println("7-Process a returned vehicle");
        System.out.println("8-quit");
    }
    
    public String getRentalPeriod(Scanner input){
        System.out.println("Type your rental period");
        return input.next();
    }
    public int getCommand(Scanner input){
        System.out.println("What action do you wish to perform?");
        return input.nextInt();
    }
    
    private String getAcctNumber(Scanner input){
        boolean q = false;
        String acct_num  = "";
        while(!q){    
        System.out.println("Type your account number: ");
        acct_num = input.next();
        if(acct_num.length()==5 && acct_num.matches("^[0-9]+$")){
            return acct_num;
            }
        }
        return acct_num;
    }
    
    private String getVIN(Scanner input){
        System.out.println("Type the VIN number of the vehicle: ");
        return input.next();
    }
    private int getVehicleType(Scanner input){
        int type = 0;
        boolean q = false;
        while(!q){
        System.out.println("Type the Vehicle type 1-car, 2-SUV, 3-Truck");
        type = input.nextInt();
        if(type == 1||type==2||type==3){
            q = true;
            }
        }
        return type;
        
    }
    
    private RentalDetails getRentalDetails(Scanner input){
       System.out.println("Type the Vehicle type 1-car, 2-SUV, 3-Truck");
       int type = input.nextInt();
       
       System.out.println("Type the estimated number of miles to be driven: ");
       int miles = input.nextInt();
       
       System.out.println("Type the rental period in the format D/M/Y and the "
               + "number followed(ex: D4, M3, Y6) ");
       String period = input.next();
       
       System.out.println("Do you need insurance?");
       boolean insur_option = input.nextBoolean();
       
       System.out.print("Are you a prime customer? ");
       boolean prime = input.nextBoolean();
               
       return new RentalDetails(type, period, miles, insur_option,prime);
       
    }
    
    private ReservationDetails getReservationDetails(Scanner input)
    {
        String acct ="";
        String acct_num="";
        System.out.println("Type the vin of the vehicle: ");
        String vin = input.next();
        boolean q = false;
        while(!q){    
        System.out.println("Type your account number: ");
        acct_num = input.next();
        if(acct_num.length()==5 && acct_num.matches("^[0-9]+$")){
                acct = acct_num;
                break;
            }
        }
        
         System.out.println("Type the rental period in the format D/M/Y and the "
               + "number followed(ex: D4, M3, Y6) ");
       String period = input.next();
       
       System.out.println("Type your credit card Number:");
       String credit_card = input.next();
       
       System.out.println("Do you need insurance?");
       boolean insur_option = input.nextBoolean();
      
        return new ReservationDetails(vin,acct,period, credit_card,insur_option);
    }    
    
    private void displayResults(ArrayList<String> a){
        Iterator<String> iterator = a.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
        
    }
    
}
    

