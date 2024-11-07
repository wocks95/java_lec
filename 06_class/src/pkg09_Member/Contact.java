package pkg09_Member;

public class Contact {

  String tel;
  String mobile;
  
  Contact() {
    
  }
  Contact(String mobile) {
  //  this.mobile = mobile;
  this(null, mobile); // null : 참조가 없다. / 아래 생성자를 호출함
  }
  
  Contact(String tel, String mobile ) {
    this.tel = tel;
    this.mobile = mobile;
  }
  
  void info() {
    System.out.println("Tel: " + (tel == null ? "없음" : tel));
    System.out.println("Mobile: " + (mobile == null ? "없음" : mobile));
  }
  
}
