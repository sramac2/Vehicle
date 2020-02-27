/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle.Account;

/**
 *
 * @author RXD0512A
 */
import java.util.ArrayList;
public class Account {
    private String acct_num; //five digit account number
    private String company_name; //Name of the company
    private ArrayList<String> vehicles_reserved; // VINs
    private boolean prime_customer;//if the customer is a prime customer
    
    public Account(String acct_num, String company_name,//Appropriate constructor
            ArrayList<String> vehicles_reserved, boolean prime_customer){
        this.acct_num = acct_num;
        this.company_name = company_name;
        this.prime_customer = prime_customer; 
        this.vehicles_reserved = vehicles_reserved;
    }
    
    public Account(){
        
    }
    
    public String getAcctNum(){//returns the account number
        return acct_num;
    }
    
    public String getCompanyName(){
        return company_name;
    }
    
    public ArrayList<String> getVehiclesReserved(){// return a string of vins
        return vehicles_reserved;
    }
    
    public void addVehicle(String acct_num){
        vehicles_reserved.add(acct_num);
    }
    public boolean isPrimeCustomer(){ // checks to see wheter the customer is a prime customer
        return prime_customer;
    }
    
    public String toString(){//standard tostring method
        return "Account Number: "+acct_num+" Company name: "+company_name+
                " PrimeCustomer: "+prime_customer;
    }
}



