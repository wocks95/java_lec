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

public class OpenapiEx {
  /*"파싱(parsing)"은 데이터를 분석하고 구조적으로 분해하는 과정을 의미합니다. 
   * 주로 컴퓨터 프로그래밍에서 데이터나 문자열을 특정 규칙이나 형식에 따라 분석하여 유용한 정보로 변환하는 작업을 일컫습니다. 
   * 예를 들어, 텍스트 파일을 읽거나 JSON, XML과 같은 형식의 데이터를 처리할 때 파싱이 필요합니다.
      1. 일반적인 파싱의 의미
          파싱은 문법적 분석을 뜻하며, 주로 아래와 같은 작업을 포함합니다:
            구문 분석: 데이터를 의미 있는 단위로 나누어 분석합니다.
             형식 변환: 데이터를 원하는 형식으로 변환하거나, 특정 구조를 해석하여 유용한 정보를 추출합니다.
  */
  public static void a()throws Exception {
  //공공 데이터 포털에서 기상청 단기예보 데이터 가져오기
    String serviceKey = "I2lPplPSMgf6LJiWhMjGGdUuTpEiKSmYLdnbejnfIq4RVR8qsty0L4jIbhvo9zJVB6DaELLvluakRpkBT6ZQuQ%3D%3D";
    StringBuilder builder = new StringBuilder();
    
    builder.append("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst");
    builder.append("?serviceKey=").append(serviceKey);
    builder.append("&pageNo=").append(1);
    builder.append("&numOfRows=").append(1000);
    // builder.append("&dataType=").append("JSON"); JSON 파일을 지원안하는 경우도 있음
    builder.append("&base_date=").append(20241118);
    builder.append("&base_time=").append(0500);
    builder.append("&nx=").append(61);
    builder.append("&ny=").append(125);
    
    URL url = new URL(builder.toString());
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    
    BufferedReader in = null;
    if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
      in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      
    } else {
        in = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
    }
    // 새로 받을 공간 만들기
    StringBuilder responseBody = new StringBuilder();
    String line = null;
    while((line = in.readLine()) !=null)
      responseBody.append(line);
    
    System.out.println(responseBody.toString());
    
    in.close();
    conn.disconnect(); // 연결 종료, 네트워크 연결이나 데이터베이스 연결을 종료한다.
    /* XML -> JSONObject */
    // org.json.JSONObject obj = org.json.XML.toJSONObject(responseBody.toString());
    // System.out.println(obj);
    
  }
  
  public static void b() throws Exception { // 데이터에서 원하는 태그 가져오기
    // 응답 XML 파싱하기
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
    System.out.println("Root tag : " + doc.getDocumentElement().getNodeName()); //<response> 태그 가져오기
    
    NodeList nodeList = doc.getElementsByTagName("item"); // <item> 태그 모두 가져오기
    System.out.println("노드 갯수 : " + nodeList.getLength()); //773개의 <item> 태그가 있음
    System.out.println("-------------------------------");
    //System.out.println(nodeList.item(0).getNodeName()); // <item> 태그 중 첫번째 태그 가져오기, item
    //System.out.println(nodeList.item(0).getChildNodes().getLength()); // <item>태그의 자식들 길이  : 8
    
    for(int i = 0, length = nodeList.getLength(); i < length; i++) {
      Node node = nodeList.item(i); // 각 <item> 태그 
      // Node가 Element의 부모이기 때문에 Element의 성능을 사용하기 위해 다운캐스팅이 필요함
      System.out.println(((Element) node).getElementsByTagName("baseDate").item(0).getTextContent());
      System.out.println(((Element) node).getElementsByTagName("baseTime").item(0).getTextContent());
      System.out.println(((Element) node).getElementsByTagName("category").item(0).getTextContent());
      System.out.println(((Element) node).getElementsByTagName("fcstDate").item(0).getTextContent());
      System.out.println(((Element) node).getElementsByTagName("fcstTime").item(0).getTextContent());
      System.out.println(((Element) node).getElementsByTagName("fcstValue").item(0).getTextContent());
      System.out.println(((Element) node).getElementsByTagName("nx").item(0).getTextContent());
      System.out.println(((Element) node).getElementsByTagName("ny").item(0).getTextContent());
      System.out.println("-------------------------------");
    }
    
  }
  
  public static void c() throws Exception {
   /* JSONOBject 사용법 */
   /*
   JSONObject obj = new JSONObject(" {\"name\": \"kim\", \"age\": 30}");
   System.out.println(obj.getString("name"));
   System.out.println(obj.getInt("age"));
   */
    // {JSONObject [JSONArray] }
    //공공 데이터 포털에서 기상청 단기예보 데이터 가져오기
    String serviceKey = "I2lPplPSMgf6LJiWhMjGGdUuTpEiKSmYLdnbejnfIq4RVR8qsty0L4jIbhvo9zJVB6DaELLvluakRpkBT6ZQuQ%3D%3D";
    StringBuilder builder = new StringBuilder();
    
    builder.append("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst");
    builder.append("?serviceKey=").append(serviceKey);
    builder.append("&pageNo=").append(1);
    builder.append("&numOfRows=").append(1000);
    builder.append("&base_date=").append(20241118);
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
    // 새로 받을 공간 만들기
    StringBuilder responseBody = new StringBuilder();
    String line = null;
    while((line = in.readLine()) !=null)
      responseBody.append(line);
    
    System.out.println(responseBody.toString());
    
    in.close();
    conn.disconnect(); // 연결 종료, 네트워크 연결이나 데이터베이스 연결을 종료한다.
    
    JSONArray item = new JSONObject(responseBody.toString())
                      .getJSONObject("response")
                      .getJSONObject("body")
                      .getJSONObject("items")
                      .getJSONArray("item");
    //System.out.println(item.length());
    //System.out.println(item.getJSONObject(0).getString("category"));
    for(int i = 0, length = item.length(); i < length; i++) {
      System.out.println(item.getJSONObject(i).getString("baseDate"));
      System.out.println(item.getJSONObject(i).getString("baseTime"));
      System.out.println(item.getJSONObject(i).getString("category"));
      System.out.println(item.getJSONObject(i).getString("fcstDate"));
      System.out.println(item.getJSONObject(i).getString("fcstTime"));
      System.out.println(item.getJSONObject(i).getString("fcstValue"));
      System.out.println(item.getJSONObject(i).getInt("nx"));
      System.out.println(item.getJSONObject(i).getInt("ny"));
      System.out.println("--------------------");
    }
    
    
  }
  
 public static void d() throws Exception {
    
    // 기상청 RSS (XML 받아서 Document 이용해서 파싱하기)
    
    String apiURL = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1168066000";
    
    DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = builderFactory.newDocumentBuilder();
    Document doc = docBuilder.parse(apiURL);
    
    doc.getDocumentElement().normalize();
    
    NodeList nodeList = doc.getElementsByTagName("data");  // 19개의 <data> 태그들
    
    for(int i = 0, length = nodeList.getLength(); i < length; i++) {
      
      Node node = nodeList.item(i);      // 각 <data> 태그
      Element element = (Element) node;  // getElementsByTagName() 메소드 사용을 위해서 Node -> Element 변경
      System.out.println("hour : " + element.getElementsByTagName("hour").item(0).getTextContent());
      System.out.println("temp : " + element.getElementsByTagName("temp").item(0).getTextContent());
      System.out.println("tmx : " + element.getElementsByTagName("tmx").item(0).getTextContent());
      System.out.println("tmn : " + element.getElementsByTagName("tmn").item(0).getTextContent());
      System.out.println("wfKor : " + element.getElementsByTagName("wfKor").item(0).getTextContent());
      System.out.println("----------");
      
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
    while((line = in.readLine()) != null) 
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
      System.out.println("-----------------------------------");
    }
   
    
  }
  
  public static void main(String[] args) throws Exception {
    d();
    
  }

}
