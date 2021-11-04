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
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Raluca
 */
public class AboutController implements Initializable {

    @FXML
    private AnchorPane root;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void control_back(ActionEvent event) {
        try {
            Parent fxml=FXMLLoader.load(getClass().getResource("/views/Menu.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);
        } catch(IOException ex)
        {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
}
