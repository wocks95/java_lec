package pkg05_condition;

public class ConditionEx {

  public static void main(String[] args) {
    
    // 조건 연산
    int hour = 10;
    String ampm = hour < 12 ? "오전" : "오후";
    System.out.println(ampm);
    
    int score = 50; // 60이상 합격 50 이상 재 시험 나머지 불합격
    String pass = score >= 60 ? "합격": score >= 50 ? "재시험" : "불합격";
    System.out.println(pass);

  }

}
