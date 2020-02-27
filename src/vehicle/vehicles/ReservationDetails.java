/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle.vehicles;

/**
 *
 * @author RXD0512A
 */
public class ReservationDetails {
    private String vin;
    private String acct_num;
    private String rental_period;
    private boolean daily_insur;
    private String credit_card;
    
    public ReservationDetails(String vin,String acct_num, String rental_period,
            String credit_card,boolean daily_insur){
        this.acct_num = acct_num;
        this.daily_insur = daily_insur;
        this.rental_period = rental_period;
        this.vin = vin;
        this.credit_card = credit_card;
    }
    
    public String getVin(){
        return vin;
    }
    
    public String getRentalPeriod(){
        return rental_period;
    }
    
    public String getAcctNum(){
        return acct_num;
    }
    
    public boolean isInsurOption(){
        return daily_insur;
    }
    
    public String getCreditCardNum(){
        return credit_card;
    }
    
    
}
