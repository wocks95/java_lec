package pkg03_constructor;

import java.util.Arrays;

public class ConstructorEx {

  public static void main(String[] args) {
    
    Developer developer1 = new Developer(new String[] {"자바", "파이썬"});
    developer1.setName("제임스");
    developer1.setNumber(10);
    System.out.println(developer1.getName());
    System.out.println(developer1.getNumber());
    System.out.println(Arrays.toString(developer1.getSkills()));
    
    System.out.println("-----------------------------");
    
    Developer developer2 = new Developer("엘버트", new String[] {"노드", "자바스크립트"});
    System.out.println(developer2.getName());
    System.out.println(developer2.getNumber());
    System.out.println(Arrays.toString(developer2.getSkills()));
  }

}
