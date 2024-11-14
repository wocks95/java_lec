package pkg02_date_time;

import java.text.SimpleDateFormat;

public class Class03_System {

  public static void main(String[] args) {
    
    // 1. 현재 timestamp 가져오기
    long timestamp = System.currentTimeMillis();
    System.out.println(timestamp);
    
    SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd HH:mm:ss.SSS");
    System.out.println(sdf.format(timestamp));
    
    // 2. 특정 시간을 nano 초 단위로 가져오기
    // 2개의 시간을 가져와서 차이를 구할 때 사용한다.
    long start = System.nanoTime();
    System.out.println("hello world");
    long end = System.nanoTime();
    System.out.println(end - start + "ns");

  }

}