package pkg03_writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class WriterEx {
  
  /*
   * try catch resources 문
   * 1. 자동으로 생성한 자원(입출력 스트림)을 close 하는 try 문이다.
   * 2. 형식
   *  try (스트림 생성) {
   *  
   *  } catch() {
   *  
   *  }
   */
  public static void a() {
      
    File file = new File("\\storage", "a.txt");

    try (FileWriter out = new FileWriter(file)) {
      
      // 하나의 문자 출력 : int
      int c = '안';
      out.write(c);
      
      // 여러 문자 출력 : char[]
      char[] cbuf = "녕하".toCharArray(); //char[] cbuf = new char[] {'녕','하'};
      out.write(cbuf);
      
      // 문자열 출력 : String
      String str = "세요";
      out.write(str);
      
    } catch (IOException e) {
      e.printStackTrace();
    }
    
  }
  
  public static void b() {
    File file = new File("\\storage", "b.html");
    
    //출력 속도 향상을 위한 ButtferedWriter 클래스
    try(BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
      
      // BufferedWriter 클래스가 지원하는 줄 바꿈 메소드 : NEWLine()
      out.write("<script>");
      out.newLine();
      out.write("alert('안녕하세요');");
      out.newLine();
      out.write("</script>");
      
    }catch (IOException e) {
      e.printStackTrace();
    }
        
  }

  public static void c() {
    
    File file = new File("\\storage\\c.html");
    
    // print, println, prinf 메소드를 지원하는 printWriter클래스
    try (PrintWriter out = new PrintWriter(file)) {
      
      out.println("<script>");
      out.println("location.href='https://www.naver.com/';"); // location 주소 바꿔주는 코드
      out.println("</script>");

      
    } catch (IOException e) {
       e.printStackTrace();
    }
  }
  
  public static void main(String[] args) {
    c();
  }

}
