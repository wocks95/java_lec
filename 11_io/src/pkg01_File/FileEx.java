package pkg01_File;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
 * java.io.File 클래스
 * 1. 디렉터리/파일의 정보(이름, 경로, 크기, 최종,수정일 등)를 확인 할 수 있다.
 * 2. 디렉터리/파일을 만들거나 삭제할 수 있다.
 */

/*
 * 디렉터리/파일 경로 작성
 * 1. 경로 구분자 (separator)
 *   1) windows : \\
 *   2) linux   : /
 *   3) mac     : /
 *   4) File.separator 필드를 사용하면 플랫폼에 따라서 자동으로 경로 구분자를 넣어준다.
 * 2. 디렉터리
 *   1) 현재 디렉터리 : .
 *   2) 상위 디렉터리 : ..
 *   3)   홈 디렉터리 : ~  - linux
 *   4) 루트 디렉터리 : /  - linux
 */
public class FileEx {
  
  public static void a() {
    
    // 디렉터리 만들기
    
    // File 인스턴스 생성 (디렉터리 경로와 이름을 작성해야 함)
    File dir = new File("D:\\storage");
    
    // 디렉터리가 없으면 만들기
    if(!dir.exists()) { 
      dir.mkdir();
      //확인
      System.out.println(dir.getName() + "디렉터리가 생성되었습니다.");
    }
    
    
    
  }

  public static void b() {
    
    //디렉터리 삭제하기 : 비어 있는 디렉터리만 삭제할 수 있다.
    
    //File 인스턴스 생성
    File dir = new File("D://storage");
    
    //디렉터리가 있으면 삭제하기
    if(dir.exists()) {
      dir.delete();      // JVM이 실행 중이어도 삭제한다.
      // dir.deleteOnExit() JVM이 종료되면 삭제한다.
    }
    // 확인
    System.out.println(dir.exists() ? "삭제 실패" : "삭제 성공");
  }

  public static void c() {
    
    // 디렉터리/파일 정보 확인
    
    // File 인스턴스 생성
    File javaHome = new File("C:\\Program Files\\Java\\jdk-17");
    
    // 하위 디렉터리/파일을 모두 File 인스턴스로 가져오기
    File[] files = javaHome.listFiles();
    
    // for
    for(File file : files) {
      
      StringBuilder builder = new StringBuilder();
      
      // 이름 substring(0, Math.min(file.getName().length(), 20)) 파일 이름의 글자를 최대 20글자 이내로 제한
      builder.append(String.format("%-20s", file.getName().substring(0, Math.min(file.getName().length(), 20))));
      
      // 수정한 날짜
      long lastModified = file.lastModified();
      builder.append(String.format("%-30s", new SimpleDateFormat("yyyy-MM-dd a h:mm").format(lastModified)));
     
      // 유형
      builder.append(String.format("%-10s", file.isFile() ? "파일" : "파일 폴더")); 
      
      // 크기
      long size = file.isDirectory() ? 0 : file.length(); // 파일이 폴더 형태일 경우 0 : 아니면 데이터 크기
      if(size != 0) { 
        long kbSize = (long)Math.ceil(size / 1024.0); //Math.ceil 은 double을 나타내는 실수형태이므로 정수로 나타내기 위해 앞에 (long)을 붙임
        builder.append(String.format("%10s", new DecimalFormat("#,##0").format(kbSize))+ "KB");
      }
      //출력
      System.out.println(builder.toString());
    }
    
  }
   
  public static void d() {
    /* D:\\2024\\11\\15 디렉터리 만들기 실습 */
    String pathname = "D:\\" + DateTimeFormatter.ofPattern("yyyy\\MM\\dd").format(LocalDate.now());
    File dir = new File(pathname);
    if(!dir.exists()) { 
      dir.mkdirs();
    System.out.println(dir.getPath() + "디렉터리가 생성되었습니다.");
    }
  }
  public static void e(String pathname) {
    /* D:\\2024 디렉터리 삭제 실습 */
    /*
     *D:\\2024\\11\\15 삭제 -> e("D:\\2024\\11\\15") "D:\\2024\\11(내가 저장된 경로 : parent) \\15(내가 저장된 곳 : child)"
     *D:\\2024\\11     삭제 -> e("D:\\2024\\11")     "D:\\2024(내가 저장된 경로 : parent) \\11(내가 저장된 곳 : child)"
     *D:\\2024         삭제 -> e("D:\\2024")
     *                      -> e("D:") 종료시점(상위 디렉터리가 없으면 종료)
     */
    
    File dir = new File(pathname);      //
    File parent = dir.getParentFile();  //   
    if(parent == null)                  // 부모가 null 이면 
      return;                           //  종료
    System.out.println(dir.getPath() + "디렉터리를 삭제합니다.");
    dir.delete();                       // 삭제
    
    e(dir.getParent()); // 자신을 지우고 상위 디렉터리(부모)로 전달 (재귀 호출, recursive call = 자기 자신을 부름)
  }
  
  public static void main(String[] args) {
    e("D:\\2024\\11\\15");
  }

}
