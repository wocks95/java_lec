package pkg02_URL;

import java.net.MalformedURLException;
import java.net.URL;

public class URLPr {

  public static void main(String[] args) {
   try {
    URL url = new URL("https://www.example.com:8080/blog/list?page=1&sort=DESC#memo");
  
    System.out.println(url.getProtocol());
    System.out.println(url.getHost());
    System.out.println(url.getPort());
    System.out.println(url.getPath());
    System.out.println(url.getQuery());
    System.out.println(url.getFile()); // Path + Query
    System.out.println(url.getRef());
   
   
   
   
   
   
   } catch (MalformedURLException e) {
    e.printStackTrace();
  }
   

  }

}
