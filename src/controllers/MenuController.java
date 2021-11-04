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
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Raluca
 */
public class MenuController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private Label lbl;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void control_create(ActionEvent event) {
        try {
            Parent fxm =FXMLLoader.load(getClass().getResource("/views/create.fxml"));
             root.getChildren().removeAll();
             root.getChildren().setAll(fxm);
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }

    @FXML
    private void control_showcustomer(ActionEvent event) {
          try {
            Parent fxm =FXMLLoader.load(getClass().getResource("/views/customerlist.fxml"));
             root.getChildren().removeAll();
             root.getChildren().setAll(fxm);
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @FXML
    private void control_deposit(ActionEvent event) {
          try {
            Parent fxm =FXMLLoader.load(getClass().getResource("/views/deposit.fxml"));
             root.getChildren().removeAll();
             root.getChildren().setAll(fxm);
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @FXML
    private void control_withdraw(ActionEvent event) {
          try {
            Parent fxm =FXMLLoader.load(getClass().getResource("/views/withdraw.fxml"));
             root.getChildren().removeAll();
             root.getChildren().setAll(fxm);
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @FXML
    private void control_balance(ActionEvent event) {
          try {
            Parent fxm =FXMLLoader.load(getClass().getResource("/views/checkbalance.fxml"));
             root.getChildren().removeAll();
             root.getChildren().setAll(fxm);
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @FXML
    private void control_changepass(ActionEvent event) {
          try {
            Parent fxm =FXMLLoader.load(getClass().getResource("/views/changeusername.fxml"));
             root.getChildren().removeAll();
             root.getChildren().setAll(fxm);
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @FXML
    private void control_transfer(ActionEvent event) {
          try {
            Parent fxm =FXMLLoader.load(getClass().getResource("/views/transfer.fxml"));
             root.getChildren().removeAll();
             root.getChildren().setAll(fxm);
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @FXML
    private void control_about(ActionEvent event) {
          try {
            Parent fxm =FXMLLoader.load(getClass().getResource("/views/About.fxml"));
             root.getChildren().removeAll();
             root.getChildren().setAll(fxm);
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @FXML
    private void control_logout(ActionEvent event) {
          try {
            Parent fxm =FXMLLoader.load(getClass().getResource("/views/FXMLDocument.fxml"));
             root.getChildren().removeAll();
             root.getChildren().setAll(fxm);
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}