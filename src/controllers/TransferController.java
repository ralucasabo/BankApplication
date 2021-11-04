/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Raluca
 */
public class TransferController implements Initializable {
    
    Connection conn;
    Statement stat;
    ResultSet rs;

    @FXML
    private AnchorPane root;
    @FXML
    private TextField user;
    @FXML
    private Label name;
    @FXML
    private Label bebt;
    @FXML
    private TextField available;
    @FXML
    private TextField amount;
    @FXML
    private TextField aftertotal;
    @FXML
    private ComboBox<String> accountnum;
    @FXML
    private TextField afteradd;
    @FXML
    private TextField remaining;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/Raluca/Documents/NetBeansProjects/Bank/src/resource/transfer.db");
            stat = (Statement) conn.createStatement();
            rs = stat.executeQuery("Select * from transfer");
            String user=this.user.getText();
            while(rs.next()){
                accountnum.getItems().addAll(rs.getString(7));
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TransferController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conn.close();
            }catch (SQLException ex) {
                Logger.getLogger(CreateController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    

    @FXML
    private void control_search(ActionEvent event) {
        
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/Raluca/Documents/NetBeansProjects/Bank/src/resource/transfer.db");
            stat = (Statement) conn.createStatement();
            rs = stat.executeQuery("Select * from transfer");
            String user=this.user.getText();
            while(rs.next()){
               String user1 = rs.getString(1);
               if(user.equals(user1)){
                   name.setText(rs.getString(2));
                   bebt.setText(rs.getString(3));
                   available.setText(rs.getString(4));
                   
               }
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransferController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conn.close();
            }catch (SQLException ex) {
                Logger.getLogger(CreateController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void control_total(ActionEvent event) {
        
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/Raluca/Documents/NetBeansProjects/Bank/src/resource/transfer.db");
            stat = (Statement) conn.createStatement();
            rs = stat.executeQuery("Select * from transfer");
            int available2 = Integer.parseInt(available.getText());
            int amount2 = Integer.parseInt(amount.getText());
            int total = available2-amount2;
            aftertotal.setText(""+total);
               
        }
        catch (SQLException ex) {
            Logger.getLogger(TransferController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conn.close();
            }catch (SQLException ex) {
                Logger.getLogger(CreateController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @FXML
    private void control_show(ActionEvent event) {
        
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/Raluca/Documents/NetBeansProjects/Bank/src/resource/transfer.db");
            stat = (Statement) conn.createStatement();
            rs = stat.executeQuery("Select *from transfer");
            String accountlist = accountnum.getValue();

            while(rs.next()){
               String acont = rs.getString(7);
               if(accountlist.equals(acont)){
                int abalance = Integer.parseInt(rs.getString(10));
                int transferamount = Integer.parseInt(amount.getText());
                int total = abalance+transferamount;
                afteradd.setText(""+transferamount);
                remaining.setText(""+abalance);

              }
            }
        }catch (SQLException ex) {
            Logger.getLogger(TransferController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
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

    @FXML
    private void control_transfer(ActionEvent event) {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/Raluca/Documents/NetBeansProjects/Bank/src/resource/transfer.db");
            stat = (Statement) conn.createStatement();
            rs = stat.executeQuery("Select * from transfer");
            
            String userr = user.getText();
            String accountlist = accountnum.getValue();
            String sentAmount = amount.getText();
            String afterTot1 = aftertotal.getText();
            String afterTot2 = afteradd.getText();
            Integer newBal1 = Integer.parseInt(available.getText())-Integer.parseInt(sentAmount); 
            Integer newBal2 = Integer.parseInt(afteradd.getText())+Integer.parseInt(remaining.getText());
            
            
            stat.execute("update transfer set amount = '"+sentAmount+"', aftertotal = '"+afterTot1+"', balance = '"+newBal1+"'  where user = '"+userr+"'");
            stat.execute("update transfer set aftertotal2 = '"+sentAmount+"', availablebalance = '"+remaining.getText()+"', balance = '"+newBal2+"'  where credit = '"+accountlist+"'");   
        }
        catch (SQLException ex) {
            Logger.getLogger(TransferController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conn.close();
            }catch (SQLException ex) {
                Logger.getLogger(CreateController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        JOptionPane.showMessageDialog(null,"successfull to transfer");
    }

    private void accountnum_list(DragEvent event){
        
    }
}
