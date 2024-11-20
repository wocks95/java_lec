package pkg04_Functional_Interface_praice;

import java.util.function.Consumer;

public class Class02_ConsumerPr {

  public static void main(String[] args) {
   Consumer<String> consumer = (String t) -> {
     System.out.println(t);
   };
   System.out.println("hello world");
   
   a(number -> System.out.println(number));

  }

  public static void a(Consumer<Integer> consumer) {
    consumer.accept(10);
    
  }
}
