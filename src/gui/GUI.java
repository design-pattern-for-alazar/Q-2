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
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
  

/**
 *
 * @author Abel
 */
public class GUI extends Application {

    /**
     * @param args the command line arguments
     */
    
    private final String customerUsername = "customer";
    private final String customerPassword = "pass";
    private final String executiveUsername = "executive";
    private final String executivePassword = "password";
    private String usernameInput , passwordInput;
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
    public void start(Stage stage ){
        // insert sample data to product list
        ProductManager.populate();
       //set up view for login
       BorderPane bp = new BorderPane();
       bp.setPadding(new Insets(10 , 50 , 50 , 50));
       GridPane gridPane = new GridPane();
       gridPane.setPadding(new Insets(20,20,20,20));
       gridPane.setHgap(5);
       gridPane.setVgap(5);
       Label userNameLabel = new Label("Usrename");
       TextField userNameField = new TextField();
       Label passwordLabel = new Label("password");
       PasswordField passwordField = new PasswordField();
       Button loginButton = new Button("LOGIN");
       Label messageLabel = new Label();
       gridPane.add(userNameLabel, 0, 0);
       gridPane.add(userNameField, 1, 0);
       gridPane.add(passwordLabel, 0, 1);
       gridPane.add(passwordField, 1, 1);
       gridPane.add(loginButton, 1, 3);
       gridPane.add(messageLabel, 1, 2);
       
       
       bp.setCenter(gridPane);
       
       Scene sc = new Scene(bp , 400 ,400);
       //handlers for login
       loginButton.setOnAction(new EventHandler<ActionEvent>(){
       public void handle(ActionEvent event) { 
            usernameInput = userNameField.getText().toString();
            passwordInput = passwordField.getText().toString();
            
            if(usernameInput.equals(customerUsername)&& passwordInput.equals(customerPassword)){
                Scene sc = ProductBridge.makeScene("customerlist");
                ProductBridge.setScene(stage, sc);
            }
            else if (usernameInput.equals(executiveUsername) && passwordInput.equals(executivePassword)){
                Scene sc = ProductBridge.makeScene("executive");
                ProductBridge.setScene(stage, sc);                    
            }
            else { 
                messageLabel.setText("incorrect username or password");
                messageLabel.setTextFill(Color.RED);
                userNameField.setText("");
                passwordField.setText("");
            }   
       }
           
       });
       
       
       stage.setTitle("Login");
       stage.setScene(sc);
       stage.setWidth(450);
       stage.setHeight(300);
       stage.show();
      
   }

        
}
