package pkg01_InetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetPr {

  public static void main(String[] args) {
    try {
      InetAddress addr1 = InetAddress.getByName("google.com");
      System.out.println("IP 주소 : " + addr1.getHostAddress());
      System.out.println("도메인 주소 : " + addr1.getHostName());
      
      InetAddress addr2 = InetAddress.getByAddress(new byte[] {(byte) 172, (byte) 217, 26, (byte) 238});
      System.out.println("IP 주소 : " + addr2.getHostAddress());
      System.out.println("도메인 주소 : " + addr2.getHostName());
      
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }

  }

}
