package com.blainesmith.userregistration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christopher Pink
 */
public class DAO {
    
    private static final String CONNECTION_STRING = "jdbc:mysql://scarlet.arvixe.com";
    private static final String USER_NAME = "Justin";
    private static final String PASSWORD = "admin";
    
    private static Connection c;
    
    public static void closeConnection () throws SQLException {  
        if (c != null) {
            c.close();
            c = null;
        }
    }
    
    private static void prepareConnection () throws SQLException, ClassNotFoundException {
       
        if (c == null) {
            Class.forName("com.mysql.jdbc.Driver");
            
            c = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD);
        }
    }
    
    public static User getUser(User user) throws SQLException {
        
        try {
            prepareConnection();
            
            String statement = "SELECT ID, first_name, last_name, password FROM UserAdministration.User WHERE email = ?";
            
            PreparedStatement ps = c.prepareStatement(statement);
            
            ps.setString(1, user.getEmail());
            
            ResultSet rs = ps.executeQuery();
            
            if (!rs.isBeforeFirst()) {
                user.setError("The user was not found");
                
                return user;
            }
            
            if (rs.next()) {
                user.setId(rs.getInt(1));
                
                String r = rs.getString(2);
                if (r != null && !r.equals(""))
                    user.setFirstName(r);

                r = rs.getString(3);
                if (r != null && !r.equals(""))
                    user.setLastName(r);

                r = rs.getString(4);
                String storedPassword = "";
                if (r != null && !r.equals(""))
                    storedPassword = r;

                if (storedPassword.equals("")) {
                    user.setError("Password not found in database");

                    return user;
                }

                boolean success = Password.check(user.getPassWord(), storedPassword);

                if (!success) {
                    user.setError("Password is incorrect");
                    return user;
                }     
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
            user.setError(ex.getMessage());
            return user;
        }
        finally {
            closeConnection();
        }
        
        return user;
    }
    
    public static boolean checkUserByEmail(String email) {
        User user = new User();
        
        try {
            prepareConnection();
            
            String statement = "SELECT * FROM UserAdministration.User WHERE email = ?";
            
            PreparedStatement ps = c.prepareStatement(statement);
            
            ps.setString(1, email);
            
            ResultSet rs = ps.executeQuery();
            
            if (!rs.isBeforeFirst()) {
                return false;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        finally {
            try {
                closeConnection();
            } 
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        return true;
    }
    
    public static User insertUser(User user) throws SQLException {
        
        try {         
            prepareConnection();
            
            String statement = "SELECT * FROM UserAdministration.User WHERE email = ?";
            
            PreparedStatement ps = c.prepareStatement(statement);
            
            ps.setString(1, user.getEmail());
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.isBeforeFirst()) {
                user.setError("User already exists");          
                return user; 
            } 
            
            statement = "INSERT INTO UserAdministration.User (email, first_name, last_name, password) VALUES (?, ?, ?, ?)";
            
            ps = c.prepareStatement(statement, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, user.getEmail());
            ps.setString(2, user.getFirstName());
            ps.setString(3, user.getLastName());
            
            String sh = Password.getSaltedHash(user.getPassWord());
            ps.setString(4, sh);

            ps.executeUpdate();
            
            if (!ps.getGeneratedKeys().isBeforeFirst()){
                user.setId(ps.getGeneratedKeys().getInt(1));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
            user.setError(ex.getMessage());          
            return user;
        }
        finally {
            closeConnection();
        }
        
        return user;
    }
    
    public static User updateUserInfo(User user) throws SQLException {
        try {         
            prepareConnection();           
            
            String statement = "INSERT INTO UserAdministration.User (email, first_name, last_name, password) VALUES (?, ?, ?, ?)";
            
            PreparedStatement ps = c.prepareStatement(statement, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, user.getEmail());
            ps.setString(2, user.getFirstName());
            ps.setString(3, user.getLastName());

            ps.executeUpdate();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            user.setError(ex.getMessage());          
            return user;
        }
        finally {
            closeConnection();
        }
        
        return user;
    }
}
