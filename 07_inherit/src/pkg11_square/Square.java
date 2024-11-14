package pkg11_square;

public class Square extends Rectangle {

  //new square(4);
  
  public Square(int side) {  //생성자 : 자동완성할때 source >from Superclass...를 클릭! 다만, 원하는 값을 얻으려면 수정이 필요할때도 있음
    super(side, side);
  }
  
  
}
