package pkg02_OutputStream;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class OutputEx {

  public static void a() {
    
    // 생성 모드 : 항상 새로 만드는 모드
    
    // 디렉터리
    File dir = new File("\\storage"); //기존에 설정해둔 드라이브로 감 -> D:
    if(!dir.exists())
      dir.mkdirs();
    
    // 파일
    File file = new File(dir, "sample.dat"); //(저장될 경로, 저장할 파일 이름)
    
    // FileOutputStream (파일 출력 스트림) 인스턴스 선언
    FileOutputStream out = null;
    
    try {
      // FileOutputStream (파일 출력 스트림) 인스턴스 생성 : 파일 생성 시점
      out = new FileOutputStream(file);
      
      // 출력 : 하나의 데이터 내보내기 (단위 : int)
      int c = 'A';
      out.write(c);
      
      // 출력 : 여러 데이터 내보내기 (단위 : byte[])
      // byte[] b = new byte[] {'p','p','l','e'};
      byte[] b = "pple".getBytes(); // "pple"를 byte[]로 바꿔서 출력해줌
      out.write(b);
      
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch(IOException e) {
      e.printStackTrace();
    } finally { //출력한 데이터를 안정적으로 끊어내기
      //파일 출력 스트림의 종료 
      //예외 발생 여부와 상관 없도록 finally 블록에서 처리
      try {
        if(out != null) 
          //만약에 파일 출력 스트림이 안될경우 null값이 전해질텐데 그걸 방지하고자 if문을 만듬
          out.close();
      } catch(IOException e) {
        e.printStackTrace();
      }
    }
    
  }

  public static void b() {
    
    //추가 모드 : 없으면 만들고, 있으면 추가
    File dir = new File("\\storage");
    if(!dir.exists())
      dir.mkdirs();
    
    File file = new File(dir, "sample2.dat");
    
    FileOutputStream out = null;
    
    try {
      out = new FileOutputStream(file, true); // true : 추가 모드 설정
          
      int c = '안';   //byte 기반 출력 스트림이다 보니까 데이터가 잘려서 보내짐 -> H
      out.write(c);
      
      byte[] b = "녕하세요".getBytes();
      out.write(b);
      
    } catch (IOException e) { //FileNotFoundException 의 부모 클래스이므로 함께 처리 가능하다.
      e.printStackTrace();
    } finally {
      try {
        if(out != null)
          out.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    // 여러번 보내면 계속 추가 됨 -> H녕하세요H녕하세요
    
  }
  
  public static void c() {
    // 입출력 성능 향상을 위해 함께 사용하는 보조 스트림 : BufferedOutputStream
    
    File dir = new File("\\storage");
    if(!dir.exists())
      dir.mkdirs();
    
    File file = new File(dir, "sample3.dat");
    
    BufferedOutputStream out = null;
    
    try {
      // 버퍼를 이용해서 출력 데이터를 모아서 한 번에 처리하므로 출력 속도가 향상된다.
      out = new BufferedOutputStream(new FileOutputStream(file));       
      
      int c = '안';
      out.write(c);
      
      byte[] b = "녕하세요".getBytes();
          // new byte[] {'h', '하', '세', '요'}; 코드값이 128 언더까지만 byte로 보낼 수 가 있다.
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
  
  public static void d() {
    
    //변수 그대로 출력하는 스트림 : DataOutputStream
    File dir = new File("\\storage");
    if(!dir.exists());
    dir.mkdirs();
    
    File file = new File(dir, "sample4.dat");
    
    DataOutputStream out =null;
    
    try {
      
      out = new DataOutputStream(new FileOutputStream(file));
      // out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
      
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
  
  public static void e() {
    
    // 인스턴스(객체)를 출력할 수 있는 스트림 : ObjectOutputStream
    
    File dir = new File("\\storage");
    if(!dir.exists())
      dir.mkdirs();
    
    File file = new File(dir, "sample5.dat");
    
    ObjectOutputStream out = null;
    
    try {
      
      out = new ObjectOutputStream(new FileOutputStream(file));
      
      out.writeObject(new Car("genesis", "G90")); //직렬화가 가능한 인스턴스를 출력할 수 있다.
      out.writeObject(new Car("volvo", "XC90"));
      out.writeObject(new Car("bmw", "X7"));
      
         
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
  
  public static void main(String[] args) {
    e();

  }

}
