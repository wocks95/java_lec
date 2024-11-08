package pkg01_is_a;

/*
 * 부모 클래스
 * 수퍼 클래스 (super)
*/
/*
  ┌--------------┐
  │    Person    │ 슈퍼 클래스
  │--------------│
  │     eat()    │
  │    sleep()   │
  └--------------┘
*/
public class Person {

  public void eat() {
    System.out.println("먹는다.");
  }
  
  public void sleep() {
    System.out.println("잔다.");
    
  }
}
