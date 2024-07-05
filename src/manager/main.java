/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package manager;
import manager.ConnectDB;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author Admin
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // TODO code application logic here
        Connection con= ConnectDB.getConnection();
        if(con!= null)
            System.out.println("connect thanh cong");
        else System.out.println("fail");
    }
    
}
