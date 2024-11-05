package pkg01_one_dimension;

public class OneEx {

  public static void main(String[] args) {
    
    // 1차원 배열 : 하나의 인덱스를 사용하는 배열
    
    // 배열 선언 
    String[] members;   // 참조 변수(members) 하나가 생성된다.
    // String[] members = "";
    
    
    // 배열 생성(배열의 길이를 만듦)
    members = new String [4]; 
    // 힙(heap, 개발자가 데이터를 만들고 없애고 하는) 영역에 연속된 4개 공간이 생기고 해당 참조를 members 변수에 할당한다.
    // [0]~[3] 생성된 인덱스는 상대적 위치라고 볼 수 있다. 
    // members(참조 변수)가 생성된 위치에서 0번째 인덱스는 [0], 3번째 위치에 있는 인덱스는 [3]이다.
    
    //배열 요소 (배열이름 + 인덱스)
    members[0] = "지수";
    members[1] = "로제";
    members[2] = "리사";
    members[3] = "제니";
    
    System.out.println(members[0]);
    System.out.println(members[1]);
    System.out.println(members[2]);
    System.out.println(members[3]);
    
    
    
    
    
    
    
    
  }

}
