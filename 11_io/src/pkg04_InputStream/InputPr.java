package pkg04_InputStream;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import pkg02_OutputStream.Car;

public class InputPr {

  
  public static void a() { // int 변수로 1바이트씩 읽기
    File file = new File("\\praice", "sample.dat");
    
    BufferedInputStream in = null;
    
    try {
      in = new BufferedInputStream(new FileInputStream(file));
      
      int c;
      byte[] b = new byte[(int) file.length()];
      int i = 0;
      
      while ( (c = in.read()) != -1 ) {
        b[i++] = (byte) c;
      }
      System.out.println(new String(b));
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
      try {
        if(in != null)
          in.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
    }
    
  }

  public static void b() { // n 바이트씩 데이터 읽기
    File file = new File("\\storage", "sample2.dat");
    
    BufferedInputStream in = null;
    
    try {
      
      in = new BufferedInputStream(new FileInputStream(file));
      byte[] b = new byte[4];
      byte[] bytes = new byte[(int)file.length()];
      int i = 0;
      int readbyte = 0;
      while ( (readbyte = in.read(b)) != -1 ) {
        System.arraycopy(b, 0, bytes, i, readbyte);
        i += readbyte;
      }
        System.out.println(new String(bytes));
        
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
      try {
        if(in != null)
          in.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
    }
  }
  
  public static void c() {
    File file = new File("\\storage", "sample4.dat");
    
    DataInputStream in = null;
    
    try {
      
      in = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
      
      // 파일에 저장도니 변수는 순서대로 읽어야 한다.
      int age = in.readInt();
      double height = in.readDouble();
      char gender = in.readChar();
      boolean isCute = in.readBoolean();
      String name = in.readUTF();
      
      System.out.println(age);
      System.out.println(height);
      System.out.println(gender);
      System.out.println(isCute);
      System.out.println(name);
      
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(in != null)
          in.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
    }
    
    
  }

  public static void d() {
    File file = new File("\\storage", "sample5.dat");
    ObjectInputStream in = null;
    
    List<Car> cars = new ArrayList<Car>();
    
    try {
      in = new ObjectInputStream(new FileInputStream(file));
      while(true) {
        Car car = (Car) in.readObject();
        cars.add(car);
      } 
    } catch (EOFException e) {
       
      for(int i = 0, size = cars.size(); i < size; i++) {
        System.out.println(cars.get(i));
      } 
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    } finally {
      try {
        if(in != null)
          in.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
    }
    
    
  }
  public static void main(String[] args) {
    d();

  }

}
