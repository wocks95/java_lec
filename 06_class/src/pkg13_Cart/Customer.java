package pkg13_Cart;

public class Customer {

  private int money;
  private Cart cart;
  
  public Customer() {
  
  }
  
  public Customer(int money) {
    super();
    this.money = money;
  }
  
  public int getMoney() {
    return money;
  }
  
  public void setMoney(int money) {
    this.money = money;
  }
  
  public Cart getCart() {
    return cart;
  }
  
  public void setCart(Cart cart) {
    this.cart = cart;
  }
  
  public void addToCart(Product product) {
    cart.addProduct(product);
  }
  
  public void removeFromCart(int removeIdx) {
    cart.removeProduct(removeIdx);
  }
  
  // 구매
  // 반환 : 영수증
  public String buy() {
    
    String receipt = "영수증\n";
    
    int total = 0;
    
    for(int i = 0, count = cart.getIdx(); i < count; i++) {
      
      // cart 에서 뺀 물건 1개
      Product product = cart.getProducts()[i];
      
      // 총 구매액에 누적
      total += product.getPrice();
      
      // 구매 가능 여부 체크
      if(money < total) {
        System.out.println("구매금액이 부족합니다.");
        return null;
      }
      
      // 영수증 만들기
      receipt += product.getName();
      receipt += "......";
      receipt += product.getPrice();
      receipt += "\n";
      
    }
    
    // 구매
    money -= total;
    
    // 영수증 만들기 추가
    receipt += "총 구매액......" + total + "\n";
    
    return receipt;
    
  }

}
