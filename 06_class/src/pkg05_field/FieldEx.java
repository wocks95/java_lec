package pkg05_field;

public class FieldEx {

  public static void main(String[] args) {
    
    // Car 타입의 인스턴스 car 생성
    Car car = new Car();
    
    System.out.println(car.fuel);
    
    car.gasStation(500);
    
    
    for(int i = 0; i < 200; i++) {
      car.accel();
    }
    car.panel();

    for(int i = 0; i < 200; i++) {
      car.brake();
    }
    car.panel();
    
    
  }

}
