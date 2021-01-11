package businessobject;

import entity.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

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
    File file = new File(pathAndFileName);
    try {
        if(file.createNewFile()){
            FileWriter writer = new FileWriter(file);
            int products = 0;
            float value = 0;
            
            for (Product product : productList) {
                products += product.getQuantity();
                value += product.getPrice();
                writer.write(String.format("There are %d %s, each $%.2f%n", product.getQuantity(), product.getName(), product.getPrice()));              
            }
            writer.write(String.format("There are %d products with a total value of $%.2f", products, value));

            writer.close();
             
        } else {
            System.out.println("File already exists!");
        }
    } catch (IOException e) {
        //TODO: handle exception
        System.out.println(e.getLocalizedMessage());
    }

  }
}
