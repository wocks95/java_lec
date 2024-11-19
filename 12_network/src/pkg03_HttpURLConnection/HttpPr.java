package pkg03_HttpURLConnection;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpPr {

  public static void main(String[] args) {
    try {
      URL url = new URL("https://www.google.com/");
      
      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
      
      int responseCode = conn.getResponseCode();
      if(responseCode == HttpURLConnection.HTTP_OK) {
        System.out.println("정상 접속");
      } else {
        System.out.println("접속 불가");
      }
      String method = conn.getRequestMethod();
      System.out.println(method);
      
      String userAgent = conn.getRequestProperty("User-Agent");
      System.out.println(userAgent);
    
      if(conn !=null)
        conn.disconnect();
    } catch (MalformedURLException e) {
       e.printStackTrace();
    } catch (IOException e) {
       e.printStackTrace();
    }

  }

}
