package pkg06_custom_exception;
/**
 * 사용자 예외 클래스
 * 1. Exception 클래스를 상속한다.
 * 2. 클래스명이 Exception 으로 끝나도록 한다.
 */
public class MyException extends Exception {

  /**
   * 예외를 던질때 필요한 직렬화하기(선택사항일뿐 디폴트이기때문에)
   */
  @java.io.Serial
  private static final long serialVersionUID = 2044542506073587784L;
  
  //예외 코드
  private int code;
  
  // constructor (생성자)
  public MyException(String message, int code) {
    super(message);
    this.code = code;
  }
  
  //getter & setter
  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code; 
  }
  
  
  
  
}
