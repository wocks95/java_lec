package pkg03_Stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * package java.util.stream;
 * 
 * public interface Stream<T> {
 *  Stream<T> filter(Predicate<T> predicate); // Predicate 결과가 true 인 데이터만 Stream 으로 반환
 *  Stream<R> map(Function<T, R> mapper);     // Function 의 반환 결과를 Stream 으로 반환
 *  void forEach(Consumer<T> action);         // forEach 메소드를 호출한 Stream 의 모든 요소를 Consumer 로 하나씩 전달한다. 
 * } 
 */
public class StreamEx {
  
  public static void a() throws Exception {
    
    // Stream 생성
    Stream<String> s1 = Stream.of("캥거루", "코알라", "이구아나", "펭귄");
    
    String[] array = {"사과", "바나나", "복숭아", "망고"};
    Stream<String> s2 = Arrays.stream(array);
    
    List<String> list = Arrays.asList("한국", "일본", "중국", "베트남");
    Stream<String> s3 = list.stream();
    
    File license = new File("C:\\Program Files\\Java\\jdk-17", "LICENSE");
    BufferedReader in = new BufferedReader(new FileReader(license));
    Stream<String> s4 = in.lines(); // 파일의 각 라인을 요소로 저장하고 있는 Stream
    StringBuilder builder = new StringBuilder();
    
    
    // forEach 메소드 활용
    s1.forEach(animal -> {
      System.out.println(animal);
    });
    s2.forEach(fruit -> System.out.println(fruit));
    s3.forEach(nation -> System.out.println(nation));
    s4.forEach(line -> builder.append(line).append("\n"));
    System.out.println(builder.toString());
    in.close();
    
    
    // 연습. JAVA_HOME 의 모든 디렉터리/파일 이름 출력하기
    File javaHome = new File("C:\\Program Files\\Java\\jdk-17");
    File[] files = javaHome.listFiles();
    
    Stream<File> s5 = Arrays.stream(files);
    s5.forEach(file -> System.out.println(file.getName()));   

  }

  public static void b() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    numbers.stream()
    // Stream 요소 중 number % 3 == 0 결과가 true 인 요소(3의배수)만 별도 Stream 으로 반환
    .filter(number -> number % 3 == 0) // filter 는 중간에 붙는 메소드
    .forEach(number -> System.out.println(number));
    
    List<Fruit> fruits = Arrays.asList(
        new Fruit("단감", 1000),
        new Fruit("포도", 2000),
        new Fruit("사과", 3000)
        );
    fruits.stream()
      .filter(fruit -> fruit.getPrice() >= 2000)
      .forEach(fruit -> System.out.println(fruit));
    
    //연습. JAVA_HOME 의 디렉터리 이름 출력하기
    File javaHome = new File("C:\\Program Files\\Java\\jdk-17");
    Arrays.stream(javaHome.listFiles())
      .filter(file -> file.isDirectory())
      .forEach(dir -> System.out.println(dir.getName()));
    
    
  }
  
  public static void c() {
    
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    numbers.stream()
      .map(number -> number * number)
      .forEach(number -> System.out.println(number));
    
    List<Fruit> fruits = Arrays.asList(
        new Fruit("단감", 1000),
        new Fruit("포도", 2000),
        new Fruit("사과", 3000)
        );
    
    fruits.stream()
      .filter(fruit -> fruit.getName().equals("포도")) // 과일의 이름이 포도인 경우만 true 로 인정, 반환
      .map(fruit -> new Fruit(fruit.getName(), fruit.getPrice() + 1000))
      .forEach(fruit -> System.out.println(fruit));
    
    // 연습. JAVA_HOME의 이름 뒤에 "폴더","파일" 추가해서 출력하기
    File javaHome = new File("C:\\Program Files\\Java\\jdk-17");
    Arrays.stream(javaHome.listFiles())
      .map(file -> file.isDirectory() ? file.getName() + "폴더" : file.getName() + "파일")
      .forEach(file -> System.out.println(file));
    
  }
  
  public static void d() {
    
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    
    // Mutable List
    List<Integer> evenNumbers = numbers.stream()
      .filter(number -> number % 2 == 0)
      .collect(Collectors.toList()); // collect 메서드를 사용시 원하는대로 작업이 가능하다.
    evenNumbers.add(12); // 작업 가능
    
    // Immutable List
    List<Integer> oddNumbers = numbers.stream()
      .filter(number -> number % 2 == 1)
      .toList(); // toList 메서드를 사용시 원하는대로 작업이 안된다.
    // oddNumbers.add(11); 작업 불가
    
    evenNumbers.stream().forEach(number -> System.out.println(number));
    oddNumbers.stream().forEach(number -> System.out.println(number));
    
  }
  public static void main(String[] args) throws Exception {
    d();

  }

}
