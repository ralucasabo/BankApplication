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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Raluca
 */
public class CustomerlistController implements Initializable {
    
    Connection conn;
    Statement stat;
    ResultSet rs;

    @FXML
    private AnchorPane root;
    @FXML
    private TableColumn<Customerlisttt, String> accountnum;
    @FXML
    private TableColumn<Customerlisttt, String> name;
    @FXML
    private TableColumn<Customerlisttt, String> dateof;
    @FXML
    private TableColumn<Customerlisttt, String> gend;
    @FXML
    private TableColumn<Customerlisttt, String> mob;
    @FXML
    private TableColumn<Customerlisttt, String> add;
    @FXML
    private TableView<Customerlisttt> tbl_customerlisttt;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        accountnum.setCellValueFactory(new PropertyValueFactory<>("accountnumber") );
        name.setCellValueFactory(new PropertyValueFactory<>("name") );
        dateof.setCellValueFactory(new PropertyValueFactory<>("dateofbirth") );
        gend.setCellValueFactory(new PropertyValueFactory<>("gender") );
        mob.setCellValueFactory(new PropertyValueFactory<>("mob") );
        add.setCellValueFactory(new PropertyValueFactory<>("address") );
        
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/Raluca/Documents/NetBeansProjects/Bank/src/resource/customerlist.db");
            stat = (Statement) conn.createStatement();
            rs = stat.executeQuery("select * from customerlist");
            while(rs.next()){
                String account = rs.getString(1);
                String namee = rs.getString(2);
                String dateofb = rs.getString(3);
                String gend = rs.getString(4);
                String mobb = rs.getString(5);
                String addre = rs.getString(6);
                
                Customerlisttt c = new Customerlisttt(account,namee,dateofb,gend,mobb,addre);
                
                tbl_customerlisttt.getItems().add(c);
            }
        } catch (SQLException ex) {
        Logger.getLogger(CustomerlistController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }    

    @FXML
    private void control_back(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/views/Menu.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);
    }
    
}
