package pkg03_one_dimention_ex;

public class Ex04 {

  public static void main(String[] args) {
    
    // 10진수를 2진수로 변환한 결과를 배열에 저장하기
    
    // 10진수
    int number = 35;            // 2 | 35
                                //   └----
                                // 2 | 17  ... 1 → binary[0]
                                //   └----
                                // 2 |  8  ... 1 → binary[1]
                                //   └----
                                // 2 |  4  ... 0 → binary[2]
                                //   └----
                                // 2 |  2  ... 0 → binary[3]
                                //   └----
                                // 2 |  1  ... 0 → binary[4]
                                //   └----
                                //      0  ... 1 → binary[5]
                                // (종료 조건)
    // 2진수                    //   ┌---------------------------------------┐
    int[] binary = new int[10]; //   | 1 | 1 | 0 | 0 | 0 | 1 | 0 | 0 | 0 | 0 |
                                //   └---------------------------------------┘
    
    
    int i = 0;
    while(number > 0) {  // 종료 조건보다 넘지 않게 하기 위해 막음
      binary[i++] = number % 2; //i++는 선 출력 후 증가이기때문에 완료된 시점인 그 다음에 멈춘다. i[5]에 안 멈추고 i[6]에 멈춤
      number /= 2; // number = number / 2; // 나눈 몫을 또 나누기 위해서
    }
    
    for(int j = i - 1; j >= 0; j--) {
      System.out.print(binary[j]);    // System.out.print(); 가로로 나옴. 뒤에 println();이면 세로로 나옴
    }
    
    
  }

}
