package pkg08_01_Object;

public class ObjectEx {

  public static void main(String[] args) {
    
   Object cafe = new Cafe("Americano", "bagel");
   
   if(cafe instanceof Cafe) {
     System.out.println(((Cafe)cafe).getcoffee());
     System.out.println(((Cafe)cafe).getbakery());
   }
   
   Cafe cafe2 = new Cafe("CafeLatte", "Sandwich");
   
   System.out.println(cafe2);
   System.out.println(cafe2.toString());
   
  }

}
