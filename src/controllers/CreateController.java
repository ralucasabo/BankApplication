
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;



public class CreateController implements Initializable {

    Connection conn;
    Statement stat;
    ResultSet rs;
    
    @FXML
    private TextField name;
    @FXML
    private TextField dob;
    @FXML
    private TextField cnic;
    @FXML
    private TextField nation;
    @FXML
    private TextField mob;
    @FXML
    private TextField addr;
    @FXML
    private TextField acc;
    @FXML
    private TextField cast;
    @FXML
    private TextField secrt;
    @FXML
    private TextField gend;
    @FXML
    private TextField accty;
    @FXML
    private AnchorPane root;
    
    @FXML
    private TextField date;
    @FXML
    private TextField user1;
    @FXML
    private TextField username;
    @FXML
    private TextField DOB;
    @FXML
    private TextField nationaliity;
    @FXML
    private TextField address;
    @FXML
    private TextField accountnumber;
    @FXML
    private TextField secorty;
    @FXML
    private TextField g;
    @FXML
    private TextField type;
    
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void control_search(ActionEvent event) throws SQLException
    {
        try {
             conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/Raluca/Documents/NetBeansProjects/Bank/src/resource/createAccount.db");
             stat = (Statement) conn.createStatement();
             rs = stat.executeQuery("Select * from createAccount");
             int usr1 = Integer.parseInt(user1.getText());
             while(rs.next()){
                int usr2 = Integer.parseInt(rs.getString(1));
                 if(usr1 == usr2){
                     name.setText(rs.getString(3));
                     date.setText(rs.getString(2));
                     dob.setText(rs.getString(4));
                     cnic.setText(rs.getString(5));
                     nation.setText(rs.getString(6));
                     mob.setText(rs.getString(7));
                     addr.setText(rs.getString(8));
                     acc.setText(rs.getString(9));
                     cast.setText(rs.getString(10));
                     secrt.setText(rs.getString(11));
                     gend.setText(rs.getString(12));
                    accty.setText(rs.getString(13));
                     
                 }
             }
        }catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex);
        }finally{
            try {
                conn.close();
            }catch (SQLException ex) {
                Logger.getLogger(CreateController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @FXML
    private void control_back(ActionEvent event)
    {
        try {
            Parent fxml=FXMLLoader.load(getClass().getResource("/views/Menu.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);
        } catch (IOException ex)
        {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    @FXML
    private void control_save(ActionEvent event) {
         try {
             conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/Raluca/Documents/NetBeansProjects/Bank/src/resource/createAccount.db");
             stat = (Statement) conn.createStatement();
             String userr =  user1.getText();
             String datee= date.getText();
             String nameee =  name.getText();
             String dobb= dob.getText();
             String cnicc =  cnic.getText();
             String nationalityy= nation.getText();
             String mobb =  mob.getText();
             String addresss= addr.getText();
             String accountnu =  acc.getText();
             String castt= cast.getText();
             String security =  secrt.getText();
             String gender= gend.getText();
             String typee= accty.getText();
             stat.execute("insert into createAccount(user,Date,name,dateofbirth,cnic,nationality,mob,address,accountnum,cast,security,g,type) values('"+userr+"','"+datee+"','"+nameee+"','"+dobb+"','"+cnicc+"','"+nationalityy+"','"+mobb+"','"+addresss+"','"+accountnu+"','"+castt+"','"+security+"','"+gender+"','"+typee+"')");
             JOptionPane.showMessageDialog(null, "save Successfull");                                       
         } catch (SQLException ex) {
                         JOptionPane.showMessageDialog(null, ex);
         }finally{
            try {
                conn.close();
            }catch (SQLException ex) {
                Logger.getLogger(CreateController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void control_edit(ActionEvent event) {
         try {
             conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/Raluca/Documents/NetBeansProjects/Bank/src/resource/createAccount.db");
              stat = (Statement) conn.createStatement();
             rs = stat.executeQuery("select * from createAccount");
             String userr =  user1.getText();
             String datee= date.getText();
             String nam =  name.getText();
             String dobb= dob.getText();
             String cnicc =  cnic.getText();
             String nationalityy= nation.getText();
             String mobb =  mob.getText();
             String addresss= addr.getText();
             String accountnu =  acc.getText();
             String castt= cast.getText();
             String security =  secrt.getText();
             String gender= gend.getText();
             String typee= accty.getText();
             stat.execute("update createAccount set name = '"+nam+"',dateofbirth  = '"+dobb+"',cnic = '"+cnicc+"',nationality = '"+nationalityy+"',mob = '"+mobb+"',address = '"+addresss+"',accountnum = '"+accountnu+"',cast = '"+castt+"',security = '"+security+"',g = '"+gender+"',type = '"+typee+"' where user = '"+userr+"'");
                 JOptionPane.showMessageDialog(null, "upadate successful");
         
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
         }finally{
             try {
                 conn.close();
             } catch (SQLException ex) {
                 Logger.getLogger(CreateController.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
    }
    
}