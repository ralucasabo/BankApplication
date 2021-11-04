/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Statement;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Raluca
 */
public class CheckbalanceController implements Initializable {
    
    Connection conn;
    Statement stat;
    ResultSet rs;

    @FXML
    private AnchorPane root;
    @FXML
    private TextField user2;
    @FXML
    private Label name1;
    @FXML
    private Label accnum;
    @FXML
    private Label mcr;
    @FXML
    private Label intrest;
    @FXML
    private Label available;
    @FXML
    private Label mob;
    @FXML
    private Label registor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void control_search(ActionEvent event) throws SQLException {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/Raluca/Documents/NetBeansProjects/Bank/src/resource/viewbalance.db");
            stat = (Statement) conn.createStatement();
            rs = stat.executeQuery("SELECT * from viewbalance");
            String user =  this.user2.getText();
            while(rs.next())
            {
                String user1=rs.getString(1);
                if(user.equals(user1)){
                    name1.setText(rs.getString(2));
                    accnum.setText(rs.getString(3));
                    mcr.setText(rs.getString(4));
                    intrest.setText(rs.getString(5));
                    available.setText(rs.getString(6));
                    mob.setText(rs.getString(7));
                    registor.setText(rs.getString(8));
                }
            }
        }catch (SQLException ex) 
            {
            Logger.getLogger(WithdrawController.class.getName()).log(Level.SEVERE,null,ex);
            }
        finally{
                try {
                    conn.close();
                }catch (SQLException ex) {
                    Logger.getLogger(CreateController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    

    @FXML
    private void control_back(ActionEvent event) {
         try {
            Parent fxml =FXMLLoader.load(getClass().getResource("/views/Menu.fxml"));
             root.getChildren().removeAll();
             root.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
