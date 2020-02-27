/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle.Transaction;

/**
 *
 * @author RXD0512A
 */
public class Transaction {
    private String return_datetime;;
    private String acct_num; // five-digit acct number
    private String company_name;// name of the company
    private String vehicle_type; // car, SUV or Truck
    private String rental_period; // days, week, month
    private double rental_cost;// total price
    
    public Transaction(String acct_num, String company_name,//appropriate constructor
            double rental_cost, String rental_period, String return_datetime, 
            String vehicle_type){   
        this.acct_num = acct_num;
        this.company_name = company_name;
        this.rental_cost = rental_cost;
        this.rental_period = rental_period;
        this.return_datetime = return_datetime;
        this.vehicle_type = vehicle_type;
    }
    
    public String getAcctNum(){
        return acct_num;
    }
    
    public String toString(){//standard toString method
        return "Account number: "+acct_num+" Company Name: "+company_name+
                " Cost: "+rental_cost+" Time Period: "+rental_period+
                " Returning date and time: "+return_datetime+
                " Type of vehicle: "+vehicle_type;
    }
}
