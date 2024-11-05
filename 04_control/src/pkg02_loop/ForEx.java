package pkg02_loop;

public class ForEx {

  public static void main(String[] args) {
    
    //5,4,3,2,1 출력하기
    for(int a = 5; a >= 1; a--) {
      System.out.println(a);
    }

    
    // 1~10사이 홀수의 평균 (합계 / 개수)
    int total = 0, count = 0;
    for(int b = 1; b <= 10; b++) {
      if(b % 2 == 1) {
        total += b;
        count++;
      }
    }
    System.out.println((double)total / count);
    System.out.println(total / (double)count);
    
    // 3단 출력하기
    for(int a = 1; a <= 9; a++) {
      System.out.println("3 x " + a + " = " +(3 * a));
     
    }
  
  }
}
   
    
    
  
