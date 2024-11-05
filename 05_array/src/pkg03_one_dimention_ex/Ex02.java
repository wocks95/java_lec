package pkg03_one_dimention_ex;

import java.util.Arrays;

public class Ex02 {

  public static void main(String[] args) {
    
    // 알파벳 대문자 ('A', 'B', ...'Z')26개 -> 배열에 저장하기
    char[] arr = new char[26];            //아스키 코드(A : 65, a : 97) 활용하기
    for(int i = 0; i < arr.length; i++) {
      arr[i] = (char)(65+i); // arr[i] = (char) ('A' + i);
    }
    System.out.println(Arrays.toString(arr));

    
    
  }
}
