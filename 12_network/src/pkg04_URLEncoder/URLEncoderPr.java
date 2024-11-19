package pkg04_URLEncoder;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLEncoderPr {

  public static void main(String[] args) {
    //인코딩과 디코딩
    try {
      
      String url = "https://www.google.com:9090?id=아이디&no=100";
      String encode = URLEncoder.encode(url, "UTF-8");
      System.out.println(encode);
      
      String decoded = URLDecoder.decode(url, "UTF-8");
      System.out.println(decoded);
      
      
    } catch (UnsupportedEncodingException e) {
       e.printStackTrace();
    }

  }

}
