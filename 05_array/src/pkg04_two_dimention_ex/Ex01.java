package pkg04_two_dimention_ex;

public class Ex01 {

  public static void main(String[] args) {
    
    // 2단부터 9단까지 구구단의 전체 결과를 2차원 배열에 저장하기
    int[][] gugudan = new int[8][9];
    for(int i = 0; i < gugudan.length; i++) {
     for(int j = 0; j < gugudan[i].length; j++) {
       gugudan[i][j] = (i+2) * (j+1);
       //System.out.print(gugudan[i][j]+" ");
       System.out.print(String.format("%3d", gugudan[i][j])); 
     }
     System.out.println();
    }
    
    
    
    
    
    
  }

}
