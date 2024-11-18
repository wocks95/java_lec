package pkg02_OutputStream;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class OutputPr {

  public static void a() { //생성 모드: 항상 새로 만드는 모드
    File dir = new File("\\praice");
    if(!dir.exists())
      dir.mkdirs();
    
    File file = new File(dir, "sample.dat");
    
    FileOutputStream out = null;
    
    try {
      out = new FileOutputStream(file);
      int c = 'A';
      out.write(c);
      
      byte[] b = "pple".getBytes();
      out.write(b);
      
      
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(out != null) 
        out.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
  
  public static void b() { //추가 모드: 없으면 만들고, 있으면 추가
    File dir = new File("\\praice");
    if(!dir.exists());
    dir.mkdirs();
    
    File file = new File(dir, "sample2.dat");
    
    FileOutputStream out = null;
    
    try {
      out = new FileOutputStream(file, true);
      
      int c = '안';
      out.write(c);
      
      byte[] b = "녕하세요".getBytes();
      out.write(b);
      
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
      try {
        if(out != null)
          out.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
    }
  }
  
  public static void c() { //입출력 성능 향상을 위해 함께 사용하는 보조 스트림
    File dir = new File("\\praice");
    if(!dir.exists())
      dir.mkdirs();
    
    File file = new File(dir, "sample3.dat");
    
    BufferedOutputStream out = null;
    
    try {
      out = new BufferedOutputStream(new FileOutputStream(file));
      
      int c = '안';
      out.write(c);
      
      byte[] b = "녕하세요".getBytes();
      out.write(b);
      
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
      try {
      if(out != null)
        out.close();
      } catch(IOException e) {
          e.printStackTrace();
      }
    }
    
    
    
  }
  
  public static void d() { //변수 그대로 출력하는 스트림
    File file = new File("\\praice", "sample4.abt");
    
    DataOutputStream out = null;
    
    try {
      out = new DataOutputStream(new FileOutputStream(file));
      
      int age = 10;
      out.writeInt(age);
      
      double height = 150.0;
      out.writeDouble(height);
      
      char gender = '남';
      out.writeChar(gender);
      
      boolean isCute = true;
      out.writeBoolean(isCute);
      
      String name = "또치";
      out.writeUTF(name);
      
      
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
      try {
      if(out != null)
        out.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
    }
    
  }
  
  public static void e() { //인스턴스를 출력 할 수 있는 스트림
    File file = new File("\\praice", "sample5.dat");
    ObjectOutputStream out = null;
    
    try {
      out = new ObjectOutputStream(new FileOutputStream(file));
      
      out.writeObject(new Car("kia", "K5"));
      
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
      try {
      if(out != null)
        out.close();
      } catch(IOException e) {
          e.printStackTrace();
      }
    }
    
  }

  public static void f() {// 여기서부터 WriterPr 클래스!!!
   
    File file = new File("\\praice", "a.txt");
    
    try (FileWriter out = new FileWriter(file)) {
      
      int c = '안';
      out.write(c);
      
      char[] cbuf = "녕하".toCharArray();
      out.write(cbuf);
      
      String str = "세요";
      out.write(str);
      
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
  
  public static void g() {
    File file = new File("\\praice", "c.html");
    
    try (PrintWriter out = new PrintWriter(file)) {
      
      out.println("<script>");
      out.println("location.href='https://www.naver.com/';");
      out.println("</script>");
      
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    
  }
  
  public static void h() {
    File file = new File("\\praice", "a.html");
    
    try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
      out.write("<script>");
      out.newLine();
      out.write("alert('안녕하세요');");
      out.newLine();
      out.write("</script>");
      
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
  
  
  public static void main(String[] args) {
    e();

  }

}
