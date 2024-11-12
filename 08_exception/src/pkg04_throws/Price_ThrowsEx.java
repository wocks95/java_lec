package pkg04_throws;

public class Price_ThrowsEx {

  public static void main(String[] args) {
    String a = "10";
    String b = "4";
    try {
      Price_Computer pri = new Price_Computer();
      System.out.println(pri.add(a, b));
      System.out.println(pri.subtract(a, b));
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }

}
