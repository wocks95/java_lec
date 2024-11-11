package pkg00_Carrier;

/*
  ┌-------------------┐
  │ Coffee            │ 슈퍼 클래스
  │-------------------│
  │ String name       │
  │ Coffee(String)    │
  │ getName()         │
  │ setName(String)   │
  └-------------------┘
*/

public class Coffee {

  private String Name;

  public Coffee(String name) {
    this.Name = name;
  }

  public String getName() {
    return Name;
  }

  public void setName(String name) {
    this.Name = name;
  }

  
 
  
  
}
