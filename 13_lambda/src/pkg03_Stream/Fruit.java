package pkg03_Stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/* Lombok 이란 곳에서 파일 설치하기
 * Window > ShowView > OutLine에서 잘 설치 됐는지 확인 가능함
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Fruit {
  
  private String name;
  private int price;
  
  /* @NoArgsConstructor, 인자 없는 생성자
  public Fruit() {
    
  }
  */
  
  /* @AllArgsConstructor
  public Fruit(String name, int price) {
    this.name = name;
    this.price = price;
  }
  */
  
  /* @Getter / @Setter
   
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }
  */
  
  /* @ToString
  @Override
  public String toString() {
    return "Fruit [name=" + name + ", price=" + price + "]";
  }
  */
  
  
  
}
