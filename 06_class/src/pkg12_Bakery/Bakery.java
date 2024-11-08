package pkg12_Bakery;

public class Bakery { // 빵집의 정보를 적어둠

  private int bread; // 빵갯수
  private int price; // 빵가격
  private int money; // 자본금
  
  public Bakery(int bread, int price, int money) {
    this.bread = bread;
    this.price = price;
    this.money = money;
  }
  
  public int getBread() {
    return bread;
  }
  public void setBread(int bread) {
    this.bread = bread;
  }
  public int getPrice() {
    return price;
  }
  public void setPrice(int price) {
    this.price = price;
  }
  public int getMoney() {
    return money;
  }
  public void setMoney(int money) {
    this.money = money;
  }
  /**
   * 
   * @param money 고객이 낸 돈
   * @param bread 고객이 사려는 빵의 갯수
   * @return 판매할 빵의 갯수와 잔돈
   */
  public BreadNChange sell(int money, int bread) {
    
    //판매할 빵이 부족한 상황
    if(this.bread < bread) { //this.bread: 빵집의 빵 갯수, bread: 고객이 사려는 갯수
      System.out.println("빵이 부족해요.");
      return null; //빵이 없어서 안 준다.
    }
    
    //고객이 낸 돈이 부족한 상황
    if(money < bread * price) {
      System.out.println("돈 더 주세요.");
      return null; //돈이 없으면 빵을 안 판다.
    }
    
    //판매 처리하기
    this.money += bread * price;
    this.bread -= bread;
    
    //반환
    return new BreadNChange(bread, money - bread * price);
    
  }
  
  
}
