package Pkg02_Functional_Interface;
/*
 * package java.util.function;
 * 
 * public interface Supplier<T> {
 *  T get();
 * 
 * }
 */

import java.util.function.Supplier;

public class Class01_Supplier {

  public static void main(String[] args) {
    // Lambda Expression
    Supplier<String> supplier = () -> "hello world";
    System.out.println(supplier.get()); 
    
    // 타입이 Supplier 인 매개변수로 Lambda Expression 전달
    a(() -> 10);
    
  }
  //Supplier : 항상 값을 반환한다. 어떤 값을 줄지 제너릭<>타입으로 정함
  public static void a(Supplier<Integer> supplier) {
    System.out.println(supplier.get());
  }
  
}
