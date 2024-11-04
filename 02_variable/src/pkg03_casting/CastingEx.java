package pkg03_casting;

public class CastingEx {

  public static void main(String[] args) {
    
    // 1. 자동 형 변환 (묵시적 형 변환, promotion)
    // 값의 도메인(값의 범위)이 작은 타입이 큰 타입으로 변환된다.
    // byte < short < int < long < float < double (기준 : 값의 표현 범위, 정수에 비해 소수점까지 표현되는 실수가 더 표현 범위가 넓음)
    int a = 10;
    long b = a;
    double c = b + 1.5; // 변수 b를 double 타입으로 변환한 뒤 더한다.
    System.out.println(c);
    
  }

}
