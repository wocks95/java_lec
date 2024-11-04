package pkg02_reference;

public class ReferenceEx {

  public static void main(String[] args) {
    
    // Reference (참조 타입, 만들어진 class를 type으로 가져옴, 간접 접근 방식 = 주소를 저장하면 주소에 저장된 값을 참조하는 것)
    
    // String 클래스 : 주소 값(참조 값)을 저장하는 대표 참조 타입, 문자열 저장
    String s = "Hello World";  // s = "Hello World"의 주소값이 저장
    System.out.println(s);
    System.out.println(System.identityHashCode(s));
    
    // ReferenceEx 클래스 타입 (6장부터 다룰 예정)
   ReferenceEx x = new ReferenceEx();
   System.out.println(x);
   
  }

}
