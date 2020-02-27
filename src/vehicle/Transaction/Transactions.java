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
import java.util.ArrayList;
import java.util.Iterator;
import vehicle.Account.AccountNumberNotFoundException;
import vehicle.Account.InvalidAcctNumException;
public class Transactions {
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    private Iterator<Transaction> iterator;
    
    public Transactions(ArrayList<Transaction> transactions){
        this.transactions = transactions;
        iterator = transactions.iterator();
    }
    public Transactions(){
       
    }
    
    public void add(Transaction t){
        transactions.add(t);
        iterator = transactions.iterator();
    }
    
    public Transaction getTransaction(String acct_num){
        int i = 0;
    if(acct_num.length()==5 && acct_num.matches("^[0-9]+$")){
            while(iterator.hasNext()){                
                Transaction t = transactions.get(i);
                if(t.getAcctNum().equals(acct_num)){
                return t;
            }
        }
        throw new AccountNumberNotFoundException();
        }
        else throw new InvalidAcctNumException();
    }
    
    public boolean hasNext(){
        return iterator.hasNext();
    }
    
    public Transaction getNext(){
        return iterator.next();
    }
}
