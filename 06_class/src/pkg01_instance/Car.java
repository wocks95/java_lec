package pkg01_instance;

// 클래스의 구성 요소 (멤버)
// 1. 필드   : 값   (변수)
// 2. 메소드 : 기능 (함수, js의 function) 
public class Car {
  
  // 필드 (field), 자동 초기화(0, false, null)
  int speed; 
  
  // 메소드 (method)
  void drive() {
    System.out.println(speed + "km 속도로 드라이브 중");
  }
}
