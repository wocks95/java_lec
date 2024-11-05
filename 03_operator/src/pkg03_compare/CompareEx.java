package pkg03_compare;

public class CompareEx {

  public static void main(String[] args) {
    
    // 비교 연산
    int a = 10;
    int b = 20;
    
    System.out.println(a > b); // false  크다.
    System.out.println(a >= b); //false  크거나 같다.
    System.out.println(a <  b); //true   작다.
    System.out.println(a <= b); //true   작거나 같다.
    System.out.println(a == b); //false  같다.
    System.out.println(a != b); //true   같지 않다.

    // 문자열을 비교 연산하기 -> ★★★결론. == 또는 != 연산자로 문자열을 비교하면 안 된다.
    String x = "hello";
    String y = "hello";
    System.out.println(x == y); // true, hello를 비교한게 아닌 hello가 저장된 참조를 비교한것
    
  }

}
