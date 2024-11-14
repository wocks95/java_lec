package pkg08_Bus;

import java.util.ArrayList;
import java.util.List;

public class Bus {
  
  // field
  private List<Seat> seats;
  public static final int LIMIT = 25;
  private int numOfPerson;
  
  // constructor
  public Bus() { 
   seats = new ArrayList<Seat>(LIMIT);  
   for(int i = 0; i < LIMIT; i++) {
     seats.add(new Seat()); // 25개 좌석을 만든다.
   }
  }
  
  // method
  
  // 버스 탑승 ( 빈 좌석 앞자리부터 채우기, 입석 금지)
  public void on(Person person) throws RuntimeException {
    if(numOfPerson >= LIMIT) {
      throw new RuntimeException("만석입니다. 다음 버스를 이용해 주세요.");
    }
   for(int i = 0; i < LIMIT; i++) {
     Seat seat = seats.get(i); //버스의 각 좌석
     if(seat.getPerson() == null) { //좌석에 앉은 사람이 없다.
       seat.setPerson(person);      //사람이 탑승하기 시작함
       numOfPerson++;                   // 사람 수가 늘어남
       return;                          // break 문도 가능하다.
     }
   }
  
  }
  
  // 버스 하차 (내리는 사람의 좌석 번호를 이용해서 하차)
  public void off(int seatNo) throws RuntimeException {
    if(seatNo < 0 || seatNo > LIMIT) {
      throw new RuntimeException("좌석 번호가 잘못 전달되었습니다.");
    }
    seats.get(seatNo - 1).setPerson(null);
    numOfPerson--; //사람 하차
  }
  
  // 버스 탑승 명단 (1번좌석 :  홍길동, 2번 좌석 :  비어 있음, ...)
  public void info() {
    for(int i = 0; i < LIMIT; i++) {
      Person person = seats.get(i).getPerson(); // 각 좌석에 앉은 사람
      if(person == null)
        System.out.println(String.format("%02d", i + 1) + "번 좌석 : 비어 있음");
      else 
        System.out.println(String.format("%02d", i + 1) + "번 좌석 : "+ person.getName());
    }
  }
  
  
  
}
