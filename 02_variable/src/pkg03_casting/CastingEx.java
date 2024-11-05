package pkg03_casting;

public class CastingEx {

  public static void main(String[] args) {
    
    // 1. 자동 형 변환 (묵시적 형 변환, promotion)
    // 값의 도메인(값의 범위)이 작은 타입이 큰 타입으로 변환된다.
    // byte < short < int < long < float < double (기준 : 값의 표현 범위, 정수에 비해 소수점까지 표현되는 실수가 더 표현 범위가 넓음)
    int a = 10;
    long b = a;
    double c = b + 1.5; // 변수 b를 double 타입으로 변환한 뒤 더한다.
    char d = 'A';       // char 타입이 int 타입으로 변환되면 유니코드 값이 저장된다.
    int e = (char)'A';  // 단, 음수가 저장될 수 있는 byte,int 등의 타입은 char 타입으로 자동 타입 변환 할 수 없다.
    System.out.println(c);
    System.out.println(e);
    
    // 2. 강제 형 변환 (명시적 형 변환, casting)
    // 어떤 타입으로든 강제로 형 변환을 할 수 있다.
    long x = 256L;
    int y = (int)x;   // 00000000 00000000 00000001 00000000 
    byte z = (byte)y; //                            00000000 앞의 3byte 값을 모두 쳐내고 (4byte 중 1byte) 1byte만 살아남는다. 
    
    
    System.out.println(y);
    System.out.println(z);
  }

}
