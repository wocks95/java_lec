package pkg10_interface.A_overview;

/*
 *    클래스 상속 vs 인터페이스 구현
 *    
 * 1. 상속한다.      구현한다.(개발자들이 오버라이드를 통해 전부 구현해야하기 때문)
 * 2. extends        implements
 * 3. 자식 클래스    구현 클래스
 */
public class Rectangle implements Shape {
  
  private double width;
  private double height;
  
  
  public Rectangle(double width, double height) {
    this.width = width;
    this.height = height;
  }
  

  @Override
  public double getCircum() {
    return 2 * (width + height);
  }
  
  @Override
  public double getArea() {
    return width * height;
  }
  
  
}
