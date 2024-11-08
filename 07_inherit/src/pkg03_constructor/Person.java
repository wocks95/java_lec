package pkg03_constructor;

public class Person {

  private String name;                  //필드
  
  public Person() { //누가 가져다쓸지 몰라서 아무일도 안하는것처럼
                    //보여도 만들어야함
    
  }
  
  public Person(String name) {          //생성자: 생성자가 하나도 없을때는 디폴트형식의 생성자가 자동으로 만들어짐
                                        //생성자는 가능하면 디폴트형식으로 만들고 그 외에 원하는 생성자를 만드는걸 추천
    this.name = name;
  }

  public String getName() {             //메소드
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  
  
  
}
