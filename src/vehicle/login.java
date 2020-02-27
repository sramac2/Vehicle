/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author RXD0512A
 */
public class login {
    public static void main (String [] args) throws IOException{
    System.out.print(httpGet("http://app.ezeebits.com/busservices/auth/getAuthToken?namespaceCode=bits&username=rams&password=rams%40us&devicemedium=WEB&authenticationTypeCode=ss&userFirstName=ss"));
    
    }
    
    public static String httpGet(String urlStr) throws IOException {
  URL url = new URL(urlStr);
  HttpURLConnection conn =
      (HttpURLConnection) url.openConnection();
  if (conn.getResponseCode() != 200) {
    throw new IOException(conn.getResponseMessage());
  }
  // Buffering the result into a string
  BufferedReader drdr = new BufferedReader(
      new InputStreamReader(conn.getInputStream()));
  StringBuilder sb = new StringBuilder();
  String line;
  while ((line = drdr.readLine()) != null) {
    sb.append(line);
  }
  drdr.close();
  conn.disconnect();
  return sb.toString();
}
}
