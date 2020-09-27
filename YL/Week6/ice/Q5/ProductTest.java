import java.io.File;
import java.io.FileWriter;
import java.io.OutputStream;
import java.util.*;

import app.Product;

public class ProductTest {
  public static void main(String[] args){
    ArrayList<Product> products = new ArrayList<>();
    products.add(new Product("apple", 3, 1.2));
    products.add(new Product("apple", 3, 1.2));
    products.add(new Product("apple", 3, 1.2));
  
    save(products,"data\\product.csv");
  }

  public static void save(ArrayList<Product> productList, String pathAndFileName){
    //TODO: goes through products and saves each Product as a line in file
    //format: name,quantity,price
    try {
      File file = new File(pathAndFileName);

      if(file.createNewFile()){
        try(FileWriter writer = new FileWriter(file)){
          
          for (Product product : productList) {
            System.out.println("Writing " + product.toString());
            writer.append(product.toString() + "\n");
          }
          
        } catch(Exception e){
          System.err.println("Exception! " + e.getMessage());
        }
      } else {
        System.err.println("File not created!");
      }

    } catch (Exception e) {
      //TODO: handle exception
      System.err.println("Exception! " + e.getMessage());
    }
    
  }
}
