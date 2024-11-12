package pkg04_throws;

public class Price_Computer {

  public int add(String a, String b) throws NumberFormatException {
    return Integer.parseInt(a) + Integer.parseInt(b);
  }
  public int subtract(String a, String b) throws NumberFormatException{
    return Integer.parseInt(a) - Integer.parseInt(b);
  }
}
