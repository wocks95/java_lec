package pkg03_constructor;

public class Developer extends Person {
  
  private String[] skills;

  public Developer(String[] skills) {     
    //자식이 부모를 부르지 않으면 디폴트형식으로 (자동)작동한다.
    super(); //public Person() { } 생성자 호출!
    this.skills = skills; 
  }

  public Developer(String name, String[] skills) {
    // 자식은 반드시 슈퍼 클래스의 생성자를 호출해야 한다.
    // 자식의 생성자코드 첫번째는 무조건 super()부터 만든다.
    // 자식을 만들고 싶으면 부모부터 만든다.
    super(name);   // public Person(String name) { } 생성자 호출
    this.skills = skills;
  }
  
  
  public String[] getSkills() {
    return skills;
  }

  public void setSkills(String[] skills) {
    this.skills = skills;
  }
  
  
  
  
}
