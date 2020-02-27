/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RXD0512A
 */
public class Calculator {
     private static String path = "C:\\Users\\RXD0512A\\Documents\\NetBeansProjects\\Vehicle\\src\\vehicle\\s.txt";
    public static void main(String [] args) throws FileNotFoundException, IOException{
        
        String sign;
        int first = 0;
        int second = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("What operation do you want to perform? (+,-,*,/) or"
                        + "type 1 for history");
        while(true){
            sign = input.next();
            if(sign.equals("/")||sign.equals("+")||sign.equals("-")||
                    sign.equals("*")){
                System.out.println("Please type the first Number");
                first = input.nextInt();    
                System.out.println("Please type the second Number");
                second = input.nextInt();
                break;
            }
            else if(sign.equals("1"))break;
            else{
                System.out.println("Please type a valid operation (+,-,*,/) or "
                        + "type 1 for history");
            }
        }        
        switch(sign){
            case "/": 
                    System.out.println("Result: "+first/second);
                    write(first/second+" ");
                    break;
            case "+":System.out.println("Result: "+(first+second));
                    write(first+second+" ");
                    break;
            case "*": System.out.println("Result: "+first*second);
                    write(first*second+" ");
                    break;
            case "-": System.out.println("Result: "+(first-second));
                    write(first-second+" ");
                    break;
            case "1":read();
                    break;
        }     
        
    }
    
    public static void write(String content){
        BufferedWriter bw = null;
        FileWriter fw = null;
        
         try {
             fw = new FileWriter(path,true);
             bw = new BufferedWriter(fw);
             bw.write(content);
         } catch (IOException ex) {
             Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
         }
         finally{
            try {
                bw.close();
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
        
        
    }
    
    public static void read(){
        try{
            File file  = new File(path);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()){
                System.out.println(scanner.next());
            }     
        }
        
        catch(IOException ex) {
            System.out.println(
           "Error writing to file '"
                + "'");
         
        }
    }
    
    
}
