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
public class ChangeusernameController implements Initializable {
    
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
    private TextField oldpass;
    @FXML
    private TextField newpass;
    @FXML
    private TextField confirm;

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
            conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/Raluca/Documents/NetBeansProjects/Bank/src/resource/changepassword.db");
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from changeuserpassword");
            String user = this.user2.getText();
            while(rs.next()){
                String user1 = rs.getString(1);
                if(user.equals(user1)){
                    name1.setText(rs.getString(2));
                    oldpass.setText(rs.getString(3));
                
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ChangeusernameController.class.getName()).log(Level.SEVERE, null, ex);
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
    private void control_save(ActionEvent event) {
        try{
        
        conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/Raluca/Documents/NetBeansProjects/Bank/src/resource/changepassword.db");
        stat = conn.createStatement();

        String usr = user2.getText();
        String newpassword = newpass.getText();
        String cnfrmpass = confirm.getText();
        if(newpassword.equals(cnfrmpass))
        {
            stat.execute("update changeUserPassword set password = '"+newpassword+"' where user = '"+usr+"'");
            JOptionPane.showMessageDialog(null,"change is successfull");
        }else {
            JOptionPane.showMessageDialog(null,"wrong password");
        }   
        }catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null,ex);
        }finally{
            try {
                conn.close();
            }catch (SQLException ex) {
                Logger.getLogger(CreateController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
