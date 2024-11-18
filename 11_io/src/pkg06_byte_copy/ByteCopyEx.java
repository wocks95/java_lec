package pkg06_byte_copy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteCopyEx {

  public static void a() {
    
    File inputFile = new File("\\dev_lec\\tools", "eclipse-jee-2023-09-R-win32-x86_64.zip");
    File putoutFile = new File("\\storage", inputFile.getName()); 
    BufferedInputStream in = null;
    BufferedOutputStream out = null;
    
    try {
      
      in = new BufferedInputStream(new FileInputStream(inputFile));
      out = new BufferedOutputStream(new FileOutputStream(putoutFile));
      
      long begin = System.currentTimeMillis();
      // 1바이트씩 복사하기
      /*int readbyte = 0;
      while( (readbyte = in.read(b)) != -1) {
        out.write(b, 0, readbyte); 
      } */
      
      // 4바이트씩 복사하기
      byte[] b = new byte[4];
      int readbyte = 0;
      while( (readbyte = in.read(b)) != -1) {
        out.write(b, 0, readbyte); //write(b, 0, readbyte) -> b 배열의 0 인덱스 부터 읽은 갯수(readbyte)만큼만 복사한다. 
      }
      
      long end = System.currentTimeMillis();
      
      System.out.println(putoutFile.getPath() + "파일 복사 완료되었습니다.");
      System.out.println("복사시간" + (end - begin) + "ms");
      
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(out != null) out.close();
        if(in != null)  in.close(); 
        
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
  
  public static void main(String[] args) {
   a();

  }

}
