/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import java.util.ArrayList;
import java.util.Collections;
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
/**
 *
 * @author Abel
 */
public class ProductExecutiveView {
    private TableView table = new TableView();
    
    public Group makeExecutiveTableView(boolean sorted){
        ObservableList<Product> data =   ProductManager.makeObservableList(sorted);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        Group root = new Group();
        table.setEditable(true); 
        TableColumn productNameColumn = new TableColumn("Product");
        TableColumn productShippedColumn = new TableColumn("Shipped Unit");
        
       //setting data to columns
        productNameColumn.setCellValueFactory(
            new PropertyValueFactory<Product,String>("productName")
        );
        productShippedColumn.setCellValueFactory(
            new PropertyValueFactory<Product,String>("productTotal")
        );
        table.setItems(data);
        table.getColumns().addAll(productNameColumn , productShippedColumn );
        Label executiveLabel = new Label("Executive view");
        executiveLabel.setFont(new Font("Arial" , 20));
        
        root.getChildren().add(executiveLabel);
        root.getChildren().add(table);
        
        return root;
    
    }
    
}
