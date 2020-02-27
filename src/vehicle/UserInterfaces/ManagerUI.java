/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle.UserInterfaces;

import vehicle.Rates.CarRates;
import vehicle.Rates.TruckRates;
import vehicle.Rates.VehicleRates;
import vehicle.Rates.SUVRates;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import vehicle.Account.Account;
import vehicle.Cost;

/**
 *
 * @author RXD0512A
 */
public class ManagerUI implements UserInterface{
    public void start(){
    ArrayList<Account> accounts;
    int selection,option;
    ArrayList<String> results = new ArrayList<String>();
    Scanner user_input = new Scanner(System.in);
    String acct_num;
    VehicleRates v;
    String vin;
    Cost cost;
    boolean quit = false;
    while(!quit){
        displayMenu();
        selection = getCommand(user_input);
    switch(selection){
        case 1: Account acct_info = getAccountInformation(user_input); 
            results = SystemInterface.addAccount(acct_info); 
            displayResults(results);
            break;
        case 2: option = getVehicleType(user_input);
                v = updateRates(user_input,option);break;
        
        case 3:results = SystemInterface.getAllVehicles();
        displayResults(results);break;
        
        case 4: results = SystemInterface.getAllReservations();
        displayResults(results);break;
        
        case 5: results = SystemInterface.getAllAccounts();
        displayResults(results);break;
        
        case 6: results = SystemInterface.getAllTransactions();
        displayResults(results);break;
        
        case 7: quit = true;
        }
    }
    
}
    public void displayMenu(){
        System.out.println("1- Add a new Corporate account");
        System.out.println("2-Update Rates");
        System.out.println("3- display all the vehicles");
        System.out.println("4- display all reservations");
        System.out.println("5- display all accounts");
        System.out.println("6 - Get transaction history");
        System.out.println("7 - quit");
        
    }
    
    public int getCommand(Scanner input){
        System.out.println("What action do you wish to perform?");
        return input.nextInt();
    }
    
    public Account getAccountInformation(Scanner input){
        ArrayList<String> vins = new ArrayList<String>(); 
          System.out.println("Type the account number: ");
          String acct_num = input.next();
          System.out.println("Type the name of the company name");
          String company_name = input.next();
          System.out.println("Type the number of vehicles reserved by this customer");
          int noOfVins = input.nextInt();
          for(int i = 1;i<=noOfVins;i++){
              System.out.println("Type the vin number of "+i+"st vehicle");
              vins.add(input.next());
          }
          System.out.println("Are they a prime customer (true/false)");
          boolean prime = input.nextBoolean();
          
          return new Account(acct_num,company_name,vins,prime);
    }
    
    private void displayResults(ArrayList<String> a){
        Iterator<String> iterator = a.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
        
    }
    
    private VehicleRates updateRates(Scanner input,int type){
        System.out.println("Type the daily_rate of the vehicle: ");
        double daily = input.nextDouble();
        
        System.out.println("Type the weekly rate: ");
        double weekly = input.nextDouble();
        
        System.out.println("Type the monthly rate: ");
        double monthly = input.nextDouble();
        
        System.out.println("Type the rate for per mile: ");
        double mileage = input.nextDouble();
        
        System.out.println("Type the insurance rate: ");
        double insur = input.nextDouble();
        VehicleRates v = new CarRates();
        if(type == 1){
            v = new CarRates(daily,weekly,monthly,mileage,insur);
        }
        
        else if(type == 2){
            v = new SUVRates(daily,weekly,monthly,mileage,insur);
        }
        
        else if(type == 3){
            v = new TruckRates(daily,weekly,monthly,mileage,insur);
        }
        return v;        
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
}
