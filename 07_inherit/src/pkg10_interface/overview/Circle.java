package pkg10_interface.overview;

public class Circle implements Shape {
  
  private double radius;
  
  public Circle(double radius) {
    this.radius = radius;
  }

  @Override
  public double getCircum() {
    return 2 * Math.PI * radius;
  }
  
  @Override
  public double getArea() {
    return Math.PI * Math.pow(radius, 2);
  }
  
  
  

}
