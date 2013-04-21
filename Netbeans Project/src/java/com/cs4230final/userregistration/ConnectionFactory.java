
package com.cs4230final.userregistration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Blaine
 */
public class ConnectionFactory {
    
    public static Connection getConnection()
      {
        Properties props = new Properties();
        props.setProperty("user", "blaine-web");
        props.setProperty("password", "blaine");
        Connection conn = null;
        try
          {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://cs.weber.edu:3306/blainesmith", props);
          } catch (SQLException ex)
          {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException e)
          {
            e.printStackTrace();
          }
        return conn;
      }
    
}
