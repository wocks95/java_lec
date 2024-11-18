package pkg05_Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadPr {

  public static void a() { //FileReader
    File file = new File("\\storage", "a.txt");
    
    try (FileReader in = new FileReader(file)) {
      char[] cbuf = new char[2];
      StringBuilder builder = new StringBuilder();
      int readChar = 0;
      while((readChar = in.read(cbuf)) != -1) {
        builder.append(cbuf, 0, readChar);
      }
      System.out.println(builder.toString());
    } catch (IOException e) {
        e.printStackTrace();
    }
    
  }
  
  public static void b() { //BufferedReader
    File file = new File("\\storage", "b.html");
    try (BufferedReader in = new BufferedReader(new FileReader(file))) {
      String line = null;
      StringBuilder builder = new StringBuilder();
      
      while ((line = in.readLine()) !=null) {
        builder.append(line);
      }
      System.out.println(builder.toString());
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    
  }
  
  public static void c() {//InputStream
    File file = new File("\\praice", "c.html");
    
    try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
      String line = null;
      StringBuilder builder = new StringBuilder();
      
      while((line = in.readLine()) != null) {
        builder.append(line);
      }
      
      System.out.println(builder.toString());
      
    } catch (IOException e) {
        e.printStackTrace();
    }
    
  }
  public static void main(String[] args) {
    c();

  }

}
