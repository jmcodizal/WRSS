package MyConnection;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JFrame;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.management.remote.JMXConnectorFactory.connect;


public class MyConnection {
    private static String url = "jdbc:mysql://localhost:3306/wrrs";
    private static String username = "root";
    private static String password = "";
    
    private static Connection conn;
    private static MyConnection db;
    
public MyConnection() {
    conn = null;
    try {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn = DriverManager.getConnection(url, username, password);
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Failed: " + e.getMessage());
    }
}



public static MyConnection getDBConnection(){
    if(db == null){
        db = new MyConnection();
    }
    return db;
}

public Connection getConnection(){
    return conn;
}
public static void main(String[] args){
    
}  
}