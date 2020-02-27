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
public class Reservation {
    private String creditCardNum; // credit card number reserved under
    private String rentalPeriod; // e.g., â€œD4â€� (four days), â€œW2â€� (two weeks), â€œM1â€� (one month)
    private boolean insuranceSelected; // set to true if optional daily insurance wante
    
    public Reservation(String creditCardNum, 
            String rentalPeriod, boolean insuranceSelected){
        this.creditCardNum = creditCardNum;
        this.insuranceSelected = insuranceSelected;
        this.rentalPeriod = rentalPeriod;
        
    }
    
    public String getCreditCardNum(){
        return creditCardNum;
    }
    
    public boolean getInsuranceSelected(){
        return insuranceSelected;
    }
    
    public String rentalPeriod(){
        return rentalPeriod;
    }
    
    public boolean equals(Reservation resv){
        return resv.creditCardNum.equals(creditCardNum) && 
                resv.insuranceSelected == insuranceSelected && 
                resv.rentalPeriod.equals(rentalPeriod);
    }
    
    public String toString(){
        return "CreditcardNumber: "+creditCardNum +" Rental Period: "+ 
                rentalPeriod+"Insurance Selected: " +insuranceSelected;
    }
}
