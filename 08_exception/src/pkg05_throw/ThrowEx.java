package pkg05_throw;

public class ThrowEx {

  public static void main(String[] args) throws RuntimeException {
    
    // try 블록에서 throw 문 : catch 블록이 받는다.
    
   try {
    
     int score = 999; 
     if(score < 0 || score > 100) {
       throw new RuntimeException(score + "점은 잘못된 점수입니다.");
     }
     
     System.out.println(score + "점을 획득했습니다.");
     
  } catch (Exception e) {
    
    System.out.println(e.getMessage());
  }

   // try 블록 외부에서 throw 문 : throws 문으로 예외를 회피한다. try-catch 문이 없어서 main 메소드로 던져서 실행됨
   int age = 500;
   
   if(age < 0 || age > 150) {
     throw new RuntimeException(age + "살은 존재할 수 없습니다.");
   }
   
   System.out.println(age + "살이군요");
   
   
   
   
   
   
  }

}
