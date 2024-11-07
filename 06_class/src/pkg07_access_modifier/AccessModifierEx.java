package pkg07_access_modifier;

public class AccessModifierEx {

  public static void main(String[] args) {
    
    // Sample 타입의 인스턴스 s 생성
    Sample s = new Sample();  // (디폴트) 매개변수 사용
    
    
    // s.item = "데이터";
    s.setItem("데이터");
    // System.out.println(s.item); 필드를 직접적으로 부르면 안됨.
    System.out.println(s.getItem()); //거의 메소드를 호출함
  }

}
