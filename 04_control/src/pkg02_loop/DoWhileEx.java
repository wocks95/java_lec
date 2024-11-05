package pkg02_loop;

public class DoWhileEx {

  public static void main(String[] args) {
    
    // 최초 1번은 반드시 수행되는 while 문
    
    int a = 10;
     do {
      System.out.println(a); // a를 먼저 1번 출력함 
    } while(a < 10); // 다만, 조건에 맞지 않으니 여기서 종료함
    
  }

}
