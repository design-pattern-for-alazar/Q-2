/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
/**
 *
 * @author Abel
 */
public class ProductListView {
    
    
    public Group makeListView(){
    Group root = new Group();
    Button salesViewButton = new Button("SALES");
    Button sortedViewButton = new Button("SORT");
    
    ObservableList<Product> data =   ProductManager.makeObservableList(false);
    ListView<String> productListView = new ListView<String>();
    ObservableList<String> listItems = FXCollections.observableArrayList();
    for(int counter =0 ; counter < data.size(); counter ++){
        listItems.add(data.get(counter).getProductName());
    
    }
    productListView.setItems(listItems);
    
    
    salesViewButton.setOnAction(new EventHandler<ActionEvent> (){
        public void handle(ActionEvent event){
            Scene salesScene = ProductBridge.makeScene("customertable");
            Stage stage = ((Stage)root.getScene().getWindow()) ;
            ProductBridge.setScene(stage, salesScene , 267 , 470);            
        }
    });
    sortedViewButton.setOnAction(new EventHandler<ActionEvent>(){
        public void handle(ActionEvent event){
            Scene sortedScene = ProductBridge.makeScene("customersorted");
            Stage stage = ((Stage)root.getScene().getWindow());
            ProductBridge.setScene(stage, sortedScene , 267 , 470);
            
        }
    });
    
    root.getChildren().addAll(productListView , sortedViewButton , salesViewButton);
    sortedViewButton.setLayoutX(60);
    sortedViewButton.setLayoutY(405);
    salesViewButton.setLayoutX(120);
    salesViewButton.setLayoutY(405);
    return root;
    
    }
    
}
