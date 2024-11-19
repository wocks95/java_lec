package pkg03_HttpURLConnection;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class IOStreamPr {

  public static void a() { //byte Stream 이용하기
    try {
      URL url = new URL("https://search.pstatic.net/sunny/?src=https%3A%2F%2Fw7.pngwing.com%2Fpngs%2F775%2F1022%2Fpng-transparent-naver-logo-search-engines.png&type=sc960_832");
      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
      
      BufferedInputStream in = null; 
      if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
        in = new BufferedInputStream(conn.getInputStream());
      } else {
        in = new BufferedInputStream(conn.getInputStream());
      }
      
      File file = new File("\\praice", "naver-logo.png");
      BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
      
      byte[] b = new byte[1024];
      int readbyte = 0;
      while((readbyte = in.read(b)) != -1)
        out.write(b, 0, readbyte);
      
      out.close();
      in.close();
      conn.disconnect();
      
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    
    
  }
  
  public static void b() { //문자 Stream 이용하기
    try {
      URL url = new URL("https://www.naver.com/");
      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
      
      BufferedReader in = null;
      
      if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
        in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      } else {
        in = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
      }
      File file = new File("\\praice", "naver.html");
      
      BufferedWriter out = new BufferedWriter(new FileWriter(file));
      String line = null;
      while((line = in.readLine()) != null)
        out.write(line + "\n");
      
      out.close();
      in.close();
      conn.disconnect();
      
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    
    
    
  }
  public static void main(String[] args) {
    b();

  }

}
