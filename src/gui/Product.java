/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import java.util.Comparator;
/**
 *
 * @author Abel
 */
public class Product {
    private String productName;
    private double productPrice;
    private int productTotal;
    private int productSales;
    private int productRemaining;
    
    
    public Product(String name , double price ,int total , int sales ,int remaining ){ 
        productName = name;
        productPrice = price;
        productTotal = total;
        productSales = sales;
        productRemaining = remaining;
        
    }
    
    public Product (String name , double price , int total , int sales) { 
        productName = name;
        productPrice = price;
        productTotal = total;
        productSales = sales;
        productRemaining = total - sales;    
    }
            
    public String getProductName(){ 
        return this.productName;
    }
    public Double getProductPrice(){ 
        return this.productPrice;
    }
    public int getProductSales(){ 
        return this.productSales;
    }
    public int getProductTotal(){ 
        return this.productTotal;
    }
    public int getProductRemaining(){ 
        return this.productRemaining;
    }
    
   public static Comparator<Product> productComparator = new Comparator<Product>(){
       public int compare(Product p1 , Product p2){
           String product1Name = p1.getProductName().toUpperCase();
           String product2Name = p2.getProductName().toUpperCase();
           return product1Name.compareTo(product2Name);
       
       }
   
   };
    
}
