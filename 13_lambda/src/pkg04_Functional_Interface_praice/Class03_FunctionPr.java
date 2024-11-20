package pkg04_Functional_Interface_praice;

import java.util.function.Function;

public class Class03_FunctionPr {

  public static void main(String[] args) {
    Function<String, Integer> function = str -> Integer.parseInt(str);
    System.out.println(function.apply("10") + 10);
    
    a(name -> name + "님"); //apply메소드
  }
  
  public static void a(Function<String, String> function) {
    System.out.println(function.apply("홍길동"));
  }
}
