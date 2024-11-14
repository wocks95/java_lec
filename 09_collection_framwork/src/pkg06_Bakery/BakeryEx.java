package pkg06_Bakery;

public class BakeryEx {

  public static void main(String[] args) {
    
    Customer customer = new Customer(0, 10000);
      
    Bakery bakery1 = new Bakery(100, 1000, 10000);
    Bakery bakery2 = new Bakery(50, 3000, 10000);
    
    customer.buy(bakery1, 3, 10000); //구매 성공
    customer.buy(bakery2, 3, 7000);  //구매 실패, 돈이 없음 9000원을 줘야함
    customer.buy(bakery2, 2, 10000);  //구매 실패
    customer.buy(bakery2, 2, 7000);  //구매 성공
    
    System.out.println(bakery1.getBread() + ", " + bakery1.getMoney()); //97, 13000
    System.out.println(bakery2.getBread() + ", " + bakery2.getMoney()); //48, 16000
    System.out.println(customer.getBread() + ", " + customer.getMoney()); //5, 1000
    
  }
}
