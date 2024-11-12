package pkg10_interface._extends;

public class ExtendsEx {

  public static void main(String[] args) {
    
    // SmartPhone 인스턴스가 가질 수 있는 타입
    // : Electronic, Computer, Phone, SmartPhone
    
    Electronic p1 = new SmartPhone();
    p1.powerOn();
    p1.powerOff();
    ((Computer)p1).game(); //다운캐스팅, SmartPhone 클래스도 사용가능함
    ((Phone)p1).call();
    ((Phone)p1).sms();

    System.out.println();
    
    Computer p2 = new SmartPhone();
    ((Electronic)p2).powerOn();
    ((Electronic)p2).powerOff();
    p2.game();
    ((Phone)p2).call();
    ((Phone)p2).sms();
    
    System.out.println();
    
    Phone p3 = new SmartPhone();
    p3.call();
    p3.sms();
    ((Electronic)p3).powerOn();
    ((Electronic)p3).powerOff();
    ((Computer)p3).game();
    
    System.out.println();
    
    SmartPhone p4 = new SmartPhone();
    p4.powerOn();
    p4.powerOff();
    p4.call();
    p4.sms();
    p4.game();
  
    System.out.println();
  }

}
