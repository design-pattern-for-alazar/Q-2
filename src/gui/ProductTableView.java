/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Abel
 */
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
public class ProductTableView {
    private TableView table = new TableView();
    public Group makeTableView(Boolean sorted){
        
        ObservableList<Product> data =   ProductManager.makeObservableList(sorted);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        Group root = new Group();
        Button backButton = new Button("<---");
        table.setEditable(true); 
        TableColumn productNameColumn = new TableColumn("Product");
        TableColumn productSalesColumn = new TableColumn("sales");
        
       //setting data to columns
        productNameColumn.setCellValueFactory(
            new PropertyValueFactory<Product,String>("productName")
        );
        productSalesColumn.setCellValueFactory(
            new PropertyValueFactory<Product,String>("productSales")
        );
        backButton.setOnAction(new EventHandler<ActionEvent> (){ 
            public void handle(ActionEvent event){
                
               Scene listScene  = ProductBridge.makeScene("customerlist");
               Stage stage = ((Stage)root.getScene().getWindow());
               stage.setScene(listScene);
            }
        });
        
        table.setItems(data);
        table.getColumns().addAll(productNameColumn , productSalesColumn );
        root.getChildren().add(table);
        root.getChildren().add(backButton);
        backButton.setLayoutX(100);
        backButton.setLayoutY(405);
        
        
        
        
    
        return root;
    }
    
}
