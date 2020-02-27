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
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
public class Accounts {
    private List<Account> accounts = new CopyOnWriteArrayList<Account>();
    private Iterator<Account> iterator = accounts.iterator();
    
    public Accounts(ArrayList<Account> a){
        accounts = a;
        iterator = accounts.iterator();
    }
    
    public Accounts(){    
    }
    
    public void add(Account acct){
        accounts.add(acct);
        iterator = accounts.iterator();
    }
    
    public Account getAccount(String acct_num){
        int i = 0;
        if(acct_num.length()==5 && acct_num.matches("^[0-9]+$")){
            while(hasNext()){                
                Account account = accounts.get(i);
                i++;
                if(account.getAcctNum().equals(acct_num)){
                return account;
            }
        }
            iterator = accounts.iterator();
        throw new AccountNumberNotFoundException();
        }
        else throw new InvalidAcctNumException();
    }
    
    public boolean hasNext(){
        return iterator.hasNext();
    }
    
    public Account getNext(){
        return iterator.next();
    }
    
    public List<Account> getAllAccounts(){
        return accounts;
    }
    
    public void setIterator(Iterator iterator){
        this.iterator = iterator;
    }
}
