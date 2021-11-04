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
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Raluca
 */
public class WithdrawController implements Initializable {
    
    Connection conn =  null;
    Statement stat;
    ResultSet rs;

    @FXML
    private AnchorPane root;
    @FXML
    private TextField user;
    @FXML
    private Label name;
    @FXML
    private TextField debit;
    @FXML
    private TextField available;
    @FXML
    private TextField amount;
    @FXML
    private TextField totalamount;


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
    private void control_search(ActionEvent event) {
        try {
        conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/Raluca/Documents/NetBeansProjects/Bank/src/resource/withdraw.db");
        stat = (Statement) conn.createStatement();
        rs = stat.executeQuery("SELECT * from Withdraw");
        String user =  this.user.getText();
        while(rs.next())
        {
            String user1 = rs.getString(1);
            if(user.equals(user1)){
                name.setText(rs.getString(2));
                debit.setText(rs.getString(3));
                available.setText(rs.getString(4)); 
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
    private void control_total(ActionEvent event) 
        {
        int availablebalance =  Integer.parseInt(available.getText());
        int amount1 = Integer.parseInt(amount.getText());
        int total = availablebalance-amount1;
        totalamount.setText(""+total);
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

    @FXML
    private void control_deposit(ActionEvent event) {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/Raluca/Documents/NetBeansProjects/Bank/src/resource/withdraw.db");
            stat = (Statement) conn.createStatement();
            String userr =  user.getText();
            String newAvail = totalamount.getText();
            stat.execute("update withdraw set availablebalance = '"+newAvail+"' where user = '"+userr+"'");
         
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CreateController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        JOptionPane.showMessageDialog(null, "Withdraw successful");
    }
    
}
