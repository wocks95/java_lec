package pkg04_Functional_Interface_praice;
/*
 * 조건을 테스트하는 함수 
 * 입력값이 특정 조건을 만족하는지 확인하는 데 사용되며, 
 * 결과는 항상 boolean 값으로 반환됩니다.
 * 
 */
import java.util.function.Predicate;

public class Class04_predicatePr {

  public static void main(String[] args) {
    
    Predicate<Integer> predicate = number -> number % 2 == 0;
    System.out.println(predicate.test(11) ? "짝수" : "홀수");
    
    a(number -> number >= 0, 5);
  }

  public static void a(Predicate<Integer> predicate, int number) {
    System.out.println(predicate.test(number) ? "양수" : "음수");
  }
}
