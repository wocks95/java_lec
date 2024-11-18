package pkg06_byte_copy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteCopyPr {

  public static void a() {
    File readFile = new File("\\dev_lec\\tools", "eclipse-jee-2023-09-R-win32-x86_64.zip");
    File writeFile = new File("\\praice", readFile.getName());
    BufferedInputStream in = null;
    BufferedOutputStream out = null;
    
    try {
      in = new BufferedInputStream(new FileInputStream(readFile));
      out = new BufferedOutputStream(new FileOutputStream(writeFile));
      
      long begin = System.currentTimeMillis();
      byte[] b = new byte[4];
      int readbyte = 0;
      while((readbyte = in.read(b)) != -1) {
        out.write(b, 0, readbyte);
      }
      
      long end = System.currentTimeMillis();
      
      System.out.println(writeFile.getPath() + "파일 복사 완료");
      System.out.println("복사시간" + (end - begin) + "ms");
      
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
      try {
        if(out != null) out.close();
        if(in != null) in.close();
        
      } catch (IOException e) {
          e.printStackTrace();
      }
    }
    
    
  }
  public static void main(String[] args) {
    a();

  }

}
