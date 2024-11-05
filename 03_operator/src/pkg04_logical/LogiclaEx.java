package pkg04_logical;

public class LogiclaEx {
  
  public static void main(String[] args) {
    
    // 논리 연산
    // 1. 논리 AND : && 하나라도 만족하지 못하면 false
    // 2. 논리 OR  : || 왼쪽부터 하나라도 만족하면 더 이상 연산하지 않고 true
    // 3. 논리 NOT : !
    int a = 10;
    int b = 10;
    System.out.println(a > 0 && b > 0);
    System.out.println(a > 0 || b > 0);
    System.out.println(!(a > 0));
    // 숏 서킷
    int x = 10;
    System.out.println(x < 0 && ++x == 0); // && 는 false 가 발생하면 더 이상 연산을 진행하지 않는다.
    System.out.println(x > 0 || ++x == 1); // || 는 true  가 발생하면 더 이상 연산을 진행하지 않는다.
    System.out.println(x);
  }
}
