package Pkg02_Functional_Interface;

import java.util.function.Function;

/*
 * package java.util.function;
 * 
 * @FunctionalInterface
 *  public interface Function<T, R> {
 *    R apply(T t);
 *  }
 * 
 * 
 * Function 인터페이스는 입력값을 받아서 결과값을 반환하는 함수적 기능을 제공합니다.
 * Function 인터페이스는 java.util.function 패키지에 포함되어 있으며, 
 * 주로 단일 입력값을 처리하여 결과를 반환하는 데 사용됩니다.
 */
public class Class03_Function {

  public static void main(String[] args) {
    
    // Lambda Expression String 주고 Integer 로 받기
    Function<String, Integer> function = str -> Integer.parseInt(str);
    System.out.println(function.apply("10")+ 10);
    
    // Function 타입의 매개변수에 Lambda Expression 전달
    a(name -> name + "님"); // apply 메소드
    
  }

  public static void a(Function<String, String> function) {
    System.out.println(function.apply("홍길동"));
  }
}
