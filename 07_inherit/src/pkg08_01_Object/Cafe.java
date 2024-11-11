package pkg08_01_Object;

public class Cafe {

  private String coffee;
  private String bakery;
  
  public Cafe(String coffee, String bakery) {
    this.coffee = coffee;
    this.bakery = bakery;
  }

  public String getcoffee() {
    return coffee;
  }

  public void setcoffee(String coffee) {
    this.coffee = coffee;
  }

  public String getbakery() {
    return bakery;
  }

  public void setbakery(String bakery) {
    this.bakery = bakery;
  }

  @Override
  public String toString() {
    return "Cafe [음료=" + coffee + ", 빵=" + bakery + "]";
  }
  
  
  
  
  
}
