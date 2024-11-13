package pkg03_ArrayList;

import java.util.*;


public class ArrayListPr {

  public static void a() {
    List<String> name;
    
    name = new ArrayList<String>();
    
    name.add("잼");
    name.add("케챱");
    name.add("빵");
    name.add("우유");
    name.add("후라이");
    
    name.set(4, "양배추");
    name.remove(1);
    
    System.out.println(name);
    System.out.println(name.size());
    
    
    
  }
  
  public static void main(String[] args) {
   a();

  }

}
