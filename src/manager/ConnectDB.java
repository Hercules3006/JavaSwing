/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;




/**
 *
 * @author Admin
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    // Phương thức để kết nối cơ sở dữ liệu
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-GK5R6QG\\HOANGTIENHUNG:1433;databaseName=manager;encrypt=true;trustServerCertificate=true","sa","123");
        return con;
    }
}



