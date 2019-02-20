/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import java.util.ArrayList;
import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author Abel
 */
public class ProductManager {
    
   private static ArrayList<Product> productList =  new ArrayList<Product>();
   public static ObservableList<Product> data = FXCollections.observableArrayList() ;
   
   public static void addProduct(Product products){ 
       ProductManager.productList.add(products);
   }
   
   public static ObservableList<Product> makeObservableList(boolean sorted ){
       data = FXCollections.observableArrayList();
       if(sorted){ 
           ArrayList<Product> productListCopy = new ArrayList<Product>(); 
           
           for(int i =0 ; i< productList.size() ; i++){
               productListCopy.add(productList.get(i));
           }
                  
           Collections.sort(productListCopy, Product.productComparator);
           for(int counter = 0 ; counter < productListCopy.size(); counter ++){
                data.add(productListCopy.get(counter));
            
            }

       }
       else { 
           for(int counter = 0 ; counter < productList.size(); counter ++){
           data.add(productList.get(counter));
       
            }
       
       }
       
              
       return data;
   
   }
   public static ArrayList<Product> getProductList(){ 
   
        return ProductManager.productList; 
   }
   //create sample product data
  public static void populate(){ 
        ProductManager.addProduct(new Product("Mercedes" , 3000 , 10 , 6 ,4) );
        
        ProductManager.addProduct(new Product("Bentley" , 3000 , 20 , 10 ,10) );
        
        ProductManager.addProduct(new Product("Audi" , 3000 , 30 , 20 ,10) );
       
  }
   
   
    
}
