/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.Collections;
import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
/**
 *
 * @author Abel
 */
public class ProductBridge {
    
    public static Scene makeScene(String type){
        
        Scene scene = null ;
        Group root = null;
        if(type.equalsIgnoreCase("executive")){
            ProductExecutiveView executiveView = new ProductExecutiveView();
            root= executiveView.makeExecutiveTableView(false);
            scene = new Scene(root ,250 , 250 , Color.WHITE );
        
        }
        else if(type.equalsIgnoreCase("customerlist")){
            ProductListView customerListView = new ProductListView();
            root = customerListView.makeListView();
            scene = new Scene(root ,250 , 250 , Color.WHITE );
        }
        else if(type.equalsIgnoreCase("customertable")){
            ProductTableView customerTableView = new ProductTableView();
            root = customerTableView.makeTableView(false);
            scene = new Scene(root ,250 , 250 , Color.WHITE );
            
        }
        else if(type.equalsIgnoreCase("customersorted")){
            ProductTableView customerTableView = new ProductTableView();
            root = customerTableView.makeTableView(true);
            scene = new Scene(root ,250 , 250 , Color.WHITE );
        }
        
       
        return scene;
    }
    public static void setScene(Stage mainStage , Scene scene){
        mainStage.setScene(scene);
        mainStage.setTitle("PRODDUCT--LIST");
        mainStage.setWidth(267);
        mainStage.setHeight(474);
        mainStage.show();
    
    }
    public static void setScene(Stage mainStage , Scene scene , int width , int height ){
        mainStage.setScene(scene);
        mainStage.setTitle("PRODDUCT--LIST");
        mainStage.setWidth(width);
        mainStage.setHeight(height);
        mainStage.show();
    }
    
}   
