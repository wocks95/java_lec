package pkg04_Functional_Interface_praice;

import java.util.function.Supplier;

public class Class01_SupplierPr {

  public static void main(String[] args) {
    Supplier<String> supplier = () -> {
      return "hello world";
    }; // 본문이 하나라서 {} 생략, return도 생략 가능
    System.out.println(supplier.get());
    
    a(() -> 10);
  }

  public static void a(Supplier<Integer> supplier) {
    System.out.println(supplier.get());
  }
}
