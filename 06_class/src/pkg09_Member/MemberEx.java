package pkg09_Member;

public class MemberEx {

  public static void main(String[] args) {
    
    // Member 타입의 인스턴스 m 생성
    Address address = new Address("12345", "서울시 강남구 테헤란로", "장연빌딩 5층");
    Contact contact = new Contact("010-3333-4444");
    Member m = new Member("chan", address, contact);
    
    m.info();
    
    
    
    /*Member m2 = new Member("alice"
                    new Address(null, null, null)
                      new Contact()
                ); */
    

  }

}
