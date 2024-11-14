package pkg07_Cart;

import java.util.ArrayList;
import java.util.List;

public class Cart {

  private List<Product> products;
  

  public Cart() {
    products = new ArrayList<Product>();
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }


  //카트에 물건 담기
  public void addProduct(Product product) throws RuntimeException {
     
    if(product == null) {
      throw new RuntimeException("Cart 에 담을 Product 이 없습니다.");
    }
    products.add(product);
    
    } 
    
  
  
  // 카트에 담긴 물건 다시 빼기
  public Product removeProduct(int removeIdx) throws RuntimeException {
    
    int size = products.size();
    
    if(size == 0) {
      throw new RuntimeException("Cart 가 비어있습니다.");
      
    }
    if(removeIdx < 0 || removeIdx >= size) {
      throw new RuntimeException("존재하지 않는 인덱스입니다.");
      
    }
    
    return products.remove(removeIdx);
    
  }
  
  
  
  
  
  
}
