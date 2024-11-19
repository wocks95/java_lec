package Pkg07_char_copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharCopyPr {

  public static void main(String[] args) {
    File file = new File("C:\\program Files\\Java\\jdk-17", "LICENSE");
    File copy = new File("\\praice", file.getName());
    
    try (BufferedReader in = new BufferedReader(new FileReader(file));
         BufferedWriter out = new BufferedWriter(new FileWriter(copy))) {
      
      String line = null;
      
      while ((line = in.readLine()) != null) {
        out.write(line + "\n");
      }
      System.out.println(copy.getPath() + "파일 복사 완료");
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    
    

  }

}
