package pkg05_openapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class OpenapiPr {

  public static void a() throws Exception {
    String serviceKey = "I2lPplPSMgf6LJiWhMjGGdUuTpEiKSmYLdnbejnfIq4RVR8qsty0L4jIbhvo9zJVB6DaELLvluakRpkBT6ZQuQ%3D%3D";
    StringBuilder builder = new StringBuilder();
    
    builder.append("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst");
    builder.append("?serviceKey=").append(serviceKey);
    builder.append("&pageNo=").append(1);
    builder.append("&numOfRows=").append(1000);
    builder.append("&base_date=").append(20241119);
    builder.append("&base_time=").append(0500);
    builder.append("&nx=").append(61);
    builder.append("&ny=").append(125);
    URL url = new URL(builder.toString());
    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
    
    BufferedReader in = null;
    if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
      in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    } else {
      in = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
    }
    
    StringBuilder resBody = new StringBuilder();
    String line = null;
    while((line = in.readLine()) != null)
      resBody.append(line);
    
    System.out.println(resBody.toString());
    
    in.close();
    conn.disconnect();
    
    
  }
  
  public static void b() throws Exception {
    String serviceKey = "I2lPplPSMgf6LJiWhMjGGdUuTpEiKSmYLdnbejnfIq4RVR8qsty0L4jIbhvo9zJVB6DaELLvluakRpkBT6ZQuQ%3D%3D"; 
    
    StringBuilder builder = new StringBuilder(); 
    builder.append("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst"); // 요청 주소
    builder.append("?serviceKey=").append(serviceKey); 
    builder.append("&pageNo=").append(1);
    builder.append("&numOfRows=").append(1000);
    // builder.append("&dataType=").append("JSON");
    builder.append("&base_date=").append(20241118);
    builder.append("&base_time=").append(0500);
    builder.append("&nx=").append(61);
    builder.append("&ny=").append(125);
    
    DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = builderFactory.newDocumentBuilder();
    Document doc = docBuilder.parse(builder.toString());
    
    doc.getDocumentElement().normalize();
    System.out.println("Root tag : " + doc.getDocumentElement());
    
    NodeList nodeList = doc.getElementsByTagName("item");
    System.out.println("노드 갯수 : " + nodeList.getLength());
    System.out.println("-----------------------");
    
    for(int i = 0, length = nodeList.getLength(); i < length; i++) {
      Node node = nodeList.item(i);
      System.out.println(((Element)node).getElementsByTagName("baseDate").item(0).getTextContent());
      System.out.println(((Element)node).getElementsByTagName("baseTime").item(0).getTextContent());
      System.out.println(((Element)node).getElementsByTagName("category").item(0).getTextContent());
      System.out.println(((Element)node).getElementsByTagName("fcstDate").item(0).getTextContent());
      System.out.println(((Element)node).getElementsByTagName("fcstTime").item(0).getTextContent());
      System.out.println(((Element)node).getElementsByTagName("fcstValue").item(0).getTextContent());
      System.out.println(((Element)node).getElementsByTagName("nx").item(0).getTextContent());
      System.out.println(((Element)node).getElementsByTagName("ny").item(0).getTextContent());
      System.out.println("---------------------------------");
    }
    
  }

  public static void c() throws Exception {
    String serviceKey = "I2lPplPSMgf6LJiWhMjGGdUuTpEiKSmYLdnbejnfIq4RVR8qsty0L4jIbhvo9zJVB6DaELLvluakRpkBT6ZQuQ%3D%3D";
    StringBuilder builder = new StringBuilder();
    
    builder.append("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst");
    builder.append("?serviceKey=").append(serviceKey);
    builder.append("&pageNo=").append(1);
    builder.append("&numOfRows=").append(1000);
    builder.append("&base_date=").append(20241119);
    builder.append("&base_time=").append(0500);
    builder.append("&nx=").append(61);
    builder.append("&ny=").append(125);
    builder.append("&dataType=").append("JSON");
    
    URL url = new URL(builder.toString());
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    
    BufferedReader in = null;
    if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
      in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    } else {
      in = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
    }
    
    StringBuilder resBody = new StringBuilder();
    String line = null;
    while((line = in.readLine()) != null)
      resBody.append(line);
    
    System.out.println(resBody.toString());
    in.close();
    conn.disconnect();
    
    JSONArray item = new JSONObject(resBody.toString())
                       .getJSONObject("response")
                       .getJSONObject("body")
                       .getJSONObject("items")
                       .getJSONArray("item");
    for(int i = 0, length = item.length(); i < length; i++) {
      System.out.println(item.getJSONObject(i).getString("baseDate"));
      System.out.println(item.getJSONObject(i).getString("baseTime"));
      System.out.println(item.getJSONObject(i).getString("category"));
      System.out.println(item.getJSONObject(i).getString("fcstDate"));
      System.out.println(item.getJSONObject(i).getString("fcstTime"));
      System.out.println(item.getJSONObject(i).getString("fcstValue"));
      System.out.println(item.getJSONObject(i).getInt("nx"));
      System.out.println(item.getJSONObject(i).getInt("ny"));
      System.out.println("-----------------------");
      
    }
    
    
  }
  
  public static void d() throws Exception {
    String apiURL = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1168066000";
    
    DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = builderFactory.newDocumentBuilder();
    Document doc = docBuilder.parse(apiURL);
    
    doc.getDocumentElement().normalize();
    
    NodeList nodeList = doc.getElementsByTagName("data");
    for(int i = 0, length = nodeList.getLength(); i < length; i++) {
      Node node = nodeList.item(i);
      Element element = (Element) node;
      System.out.println("hour : " + element.getElementsByTagName("hour").item(0).getTextContent());
      System.out.println("temp : " + element.getElementsByTagName("temp").item(0).getTextContent());
      System.out.println("tmx : " + element.getElementsByTagName("tmx").item(0).getTextContent());
      System.out.println("tmn : " + element.getElementsByTagName("tmn").item(0).getTextContent());
      System.out.println("wfKor : " + element.getElementsByTagName("wfKor").item(0).getTextContent());
      System.out.println("----------------------------");
      
    }
    
  }
  
  public static void e() throws Exception {
    StringBuilder apiURL = new StringBuilder();
          apiURL.append("http://www.kma.go.kr/wid/queryDFSRSS.jsp");
          apiURL.append("?zone=1162077500");
          
    URL url = new URL(apiURL.toString());
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    BufferedReader in = null;
    if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
      in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    } else {
      in = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
    }
    
    StringBuilder rssBody = new StringBuilder();
    String line = null;
    while ((line = in.readLine()) != null)
      rssBody.append(line);
    
    JSONArray data = org.json.XML.toJSONObject(rssBody.toString())
      .getJSONObject("rss")
      .getJSONObject("channel")
      .getJSONObject("item")
      .getJSONObject("description")
      .getJSONObject("body")
      .getJSONArray("data");
    
    for(int i = 0, length=data.length(); i < length; i++) {
      JSONObject obj = data.getJSONObject(i);
      System.out.println("hour : " + obj.getInt("hour"));
      System.out.println("day : " + obj.getInt("day"));
      System.out.println("temp : " + obj.getInt("temp"));
      System.out.println("tmx : " + obj.getInt("tmx"));
      System.out.println("wdEn : " + obj.getString("wdEn"));
      System.out.println("-----------------------------");
    }
  }
  public static void main(String[] args) throws Exception {
    e();
  }

}
