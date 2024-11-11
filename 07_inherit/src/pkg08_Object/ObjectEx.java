package pkg08_Object;

public class ObjectEx  {

  public static void main(String[] args) {
    
    // Object 타입의 인스턴스 car 생성
    Object car = new Car("benz", "E300");
    
    
    // 인스턴스 car 를 Car 타입으로 변환 (down casting)
    if(car instanceof Car) {
      System.out.println(((Car) car).getBrand() );
      System.out.println(((Car) car).getModel() );
    }
    
    // Car 타입의 인스턴스 car2 생성

    Car car2 = new Car("bmw", "520d");
    
    //아래 두 코드는 동일하다.
    System.out.println(car2);  //car2는 참조변수이기에 참조값만 있음 -> @2f92e0f4
    System.out.println(car2.toString()); 
    
    /*
  ┌-------------------┐
  │ Object            │ 슈퍼 클래스
  │-------------------│
  │ toString          │
  └-------------------┘
            ▲
  ┌-------------------┐
  │ Car               │ 서브 클래스
  │-------------------│
  │ @Override         │
  │ toString          │
  └-------------------┘    
     */
  }

}
