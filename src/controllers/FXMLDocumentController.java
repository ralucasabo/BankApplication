/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import models.StaticInfo;

/**
 * FXML Controller class
 *
 * @author Raluca
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private PasswordField password;
    @FXML
    private TextField username;
    @FXML
    private Label lbl;

    String USERNAME = "raluca";
    String PASSWORD = "raluca21";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }


    @FXML
    private void control_login(ActionEvent event) throws IOException {
        StaticInfo.USERNAME = username.getText();
        if (username.getText().equals(USERNAME) && password.getText().equals(PASSWORD)) {
            lbl.setText("");
            Parent fxm = FXMLLoader.load(getClass().getResource("/views/Menu.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxm);
        } else {
            lbl.setText("Invalid Username or Password.");
        }
    }

  
    private void create_control(ActionEvent event){
        try {
            Parent fxm = FXMLLoader.load(getClass().getResource("/views/create.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxm);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void control_rememberme(ActionEvent event) {
        
    }

    @FXML
    private void control_forget(ActionEvent event) {
        lbl.setText("Contact the Administrator");
    }


}