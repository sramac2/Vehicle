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
import java.io.IOException;
import java.net.ProtocolException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.InputStreamReader;
public class Test {
    public static void main (String[]args) throws MalformedURLException, ProtocolException, IOException{
        URL url = new URL("http://app.ezeebits.com/busservices/swagger-ui.js");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        System.out.println(connection.getResponseCode());
        System.out.println(connection.getRequestMethod());
        System.out.println(connection.getResponseMessage());
        System.out.println(connection.getHeaderField(3));
        System.out.println(connection.getErrorStream());
        
        InputStreamReader input = new InputStreamReader(System.in);
        System.out.println(input.read());
        input.skip(1);
        System.out.println(input.read());
        System.out.print(input.ready());
        
    }
    
}
