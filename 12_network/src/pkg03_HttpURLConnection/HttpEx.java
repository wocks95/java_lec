package pkg03_HttpURLConnection;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HttpEx {

  public static void main(String[] args) {
    
    try {
      // URL 인스턴스 생성
      URL url = new URL("https://www.google.com/");
      
      // HttpURLConnection 인스턴스 생성 (접속 정보를 관리하는 클래스)
      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
      
      // 응답 코드 (정상 : 200, 클라이언트 측 오류 : 4xx, 서버 측 오류 : 5xx)
      int responseCode = conn.getResponseCode();
      if(responseCode == HttpURLConnection.HTTP_OK) { //(responseCode == 200) {
        System.out.println("정상 접속");
      } else {
        System.out.println("접속 불가");
      }
      // 요청 메소드(GET, POST)
      String method = conn.getRequestMethod(); // 요청 메소드 확인
      System.out.println(method);
      // conn.setRequestMethod("GET");            // 요청 메소드 설정, set은 API 관련
      
      // 요청 헤더(User-Agent, Content-Type, Referer 등)
      String userAgent = conn.getRequestProperty("User-Agent"); //요청 헤더 확인, 키값이라고도 함
      System.out.println(userAgent);
      // conn.setRequestProperty("Content-Type", "application/json"); // 요청 헤더 설정
      
      //접속 해제
      if(conn != null)
        conn.disconnect();
      
      // 모든 요청 헤더 확인
      Map<String, List<String>> map = conn.getRequestProperties();
      for(Entry<String, List<String>> entry : map.entrySet()) {
        System.out.println(entry.getKey() + ": " + entry.getValue());
      }
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    

  }

}
