package pkg04_override;

public class MixCoffee extends BlackCoffee {
  // 오버라이드 @Override(Annotation: 지시어) 겹쳐쓰기
  @Override
  public void taste() {
    System.out.println("믹스커피맛");
  }
  
  
  
}
