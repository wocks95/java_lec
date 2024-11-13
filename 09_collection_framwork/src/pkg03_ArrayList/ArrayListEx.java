package pkg03_ArrayList;

import java.util.*;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

//import java.lang.String; //자바에서 자주쓰이는 건 java.lang에 저장(디폴트)되어있어 따로 import를 하지 않아도 됨. 
//Ctrl + Shift + O 를 하면 쓰이지 않는 import를 없애주거나 메소드안에 작성되어있는 상태에 누르면 import가 저장됨.


public class ArrayListEx {
  /**
   * Mutable 객체
   * 저장된 요소의 갯수를 변경할 수 있다.
   * 크기는 자동으로 조정된다.
   */
  public static void a() {
 
    // ArrayList 선언 : 타입은 List 인터페이스 타입 사용
    List<String> members;
    // <E> : Element 요소
    
    // ArrayList 생성 : 제네릭 타입 생략 가능
    members = new ArrayList<String>(); // members = new ArraysList<>(); 기본 크기 10
    
    // 요소 추가하기 (인덱스 [0]부터 순차적으로 추가된다.)
    members.add("제니");
    members.add("지수");
    members.add("태양");
    members.add("리사");
    members.add("로제");
     
    // 요소 삭제하기 (삭제된 요소 자리로 이후 요소들이 이동한다.)
    members.remove(2);
    
    // 요소 수정하기
    members.set(0, "jenny");
    members.set(1, "jisu");
    members.set(2, "lisa");
    members.set(3, "rose");
    
    // 요소 전체 확인
    System.out.println(members);
    
    // 요소 개별 확인
    System.out.println(members.get(0));
    System.out.println(members.get(1));
    System.out.println(members.get(2));
    System.out.println(members.get(3));
    
    // 요소 개수
    System.out.println(members.size());
    
  }
  
  /**
   * Immutable 객체 (객체의 불변성)
   * 저장된 요소의 갯수를 변경할 수 없다.
   */
  
  public static void b() {
    // (배열) 초기화를 이용한 ArrayList 생성
    
    List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50, 60, 70); 
    
    // 요소 추가하기,  Immutable 이므로 변경할 수 없다.
    // numbers.add(60);
    
    // 요소 삭제하기   Immutable 이므로 변경할 수 없다.
    // numbers.remove(0);
    
    // 요소 수정하기
    numbers.set(3, 100);
    
    // 전체 요소 확인
    System.out.println(numbers);
  }
  
  public static void c() {
    
    String[] words = {"봄", "여름", "가을", "겨울"};
    List<String> seasons = Arrays.asList(words);
    
    
    // length 필드는 변수이므로 여러 번 참조해도 괜찮다.
    for(int i = 0; i < words.length; i++) {
      System.out.println(words[i]);
    }
    
    // size() 메소드는 한 번만 호출할 수 있도록 초기화 영역에서 변수로 처리한다.
    
    for(int i = 0, size= seasons.size(); i < size; i++) {
      System.out.println(seasons.get(i));
    }
  }
  
  public static void main(String[] args) {
    b();

  }
  

}
