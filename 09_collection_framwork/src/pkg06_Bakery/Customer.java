package pkg06_Bakery;

import java.util.Map;

public class Customer { // 고객의 정보를 적어둠

  private int bread; // 구매한 빵의 갯수
  private int money; // 고객이 가진 돈
  
  public Customer(int bread, int money) {
    this.bread = bread;
    this.money = money;
  }

  public int getBread() {
    return bread;
  }

  public void setBread(int bread) {
    this.bread = bread;
  }

  public int getMoney() {
    return money;
  }

  public void setMoney(int money) {
    this.money = money;
  }
  
  /**
   * 
   * @param bakery 구매할 빵집
   * @param bread  구매하려는 빵의 갯수
   * @param money  구매할 때 낼 돈
   */
  
  public void buy(Bakery bakery, int bread, int money) {
    
    try {
      // 가진 돈 보다 더 많은 돈을 내려고 하는 상황
      if(this.money < money) {
        throw new RuntimeException("내가 가진 돈이 부족합니다.(" + (money - this.money) + "원 부족)");
      }
      
      // 구매 처리 (구매 == 빵집의 판매, 빵집의 판매 결과를 받는 것이 곧 구매이다.)
      Map<String, Integer> breadNChange = null; //빵집이 없거나 퇴짜를 맞았을때
      if(bakery != null) 
        breadNChange = bakery.sell(money, bread);
      
      //구매 결과 확인
      if(breadNChange != null) { //구매 성공
        this.bread += breadNChange.get("Bread");
        this.money -= (money - breadNChange.get("Change"));
      
    } 
      
    } catch (Exception e) {
      System.out.println(e.getMessage());
 
      }
    
  }
  
}
