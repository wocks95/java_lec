package pkg12_Carrier;

public class Carrier {

  private Cup[] cups;
  private int idx;
  
  public Carrier(int cupCount) {
    cups = new Cup[cupCount];
  }
 
  public void addCup(Cup cup) { // 캐리어 담긴 음료 정보 배열로 가져오기
    if(idx == cups.length) {
      System.out.println("주문하신 음료 나왔습니다.");
      return;
    }
   cups[idx++] = cup; 
  }
  
  
  public void info() { //메인 호출
    if(idx == 0) {
      System.out.println("조금만 더 기다려주세요.");
    }
    for(int i = 0; i < idx; i++) {
       System.out.println(cups[i].getCoffee().getName());  
    }
  }
}
