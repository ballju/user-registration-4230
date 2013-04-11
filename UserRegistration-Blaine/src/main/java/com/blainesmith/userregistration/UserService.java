/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blainesmith.userregistration;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Blaine
 */
public class UserService {
    private List<User> users = Collections.synchronizedList(new ArrayList<User>());;
    
     public List<User> getEntries()
    {
      Connection conn = ConnectionFactory.getConnection();
      String query = "Select id, email, USERNAME, FIRSTNAME, LASTNAME, created";
      try
          {
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(query);
            users.clear();
            while(rs.next())
              {
                    users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), new Date()));
              }
          } catch (SQLException ex)
          {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
          }
      finally
        {
            try
              {
                conn.close();
              } catch (SQLException ex)
              {
                Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
              }
        }
      return users;
    }
    
    public void addEntry(User c)
      {
            String query = "INSERT INTO user (email, USERNAME, FIRSTNAME, LASTNAME, created, PASSWORD)";
            query = query + "VALUES (?, ?, ?, ?, CURDATE(), ?);";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement pstmt = null;
        try
          {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, c.getUserName());
            pstmt.setString(2, c.getEmail());
            pstmt.setString(3, c.getFirstName());
            pstmt.setString(3, c.getLastName());
            pstmt.setString(3, c.getPassWord());
            pstmt.executeUpdate();
            
          } catch (SQLException ex)
          {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
          }
        finally
          {
            try
              {
                conn.close();
              } catch (SQLException ex)
              {
                Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
        
            
      }
    public void deleteEntry(User c)
      {
        String query = "DELETE FROM user where id = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement pstmt = null;
        try
          {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, c.getId());
            pstmt.executeUpdate();
            
          } catch (SQLException ex)
          {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
          }
        finally
          {
            try
              {
                conn.close();
              } catch (SQLException ex)
              {
                Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
      }
    public User getEntry(int id)
      {
        return users.get(users.indexOf(new User(id)));
      }
       public void editEntry(int id, User c)
      {
            String query = "UPDATE user SET USERNAME = ?, email = ?, FIRSTNAME = ?, LASTNAME = ?, PASSWORD = ? ";
            query = query + "WHERE id = ?;";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement pstmt = null;
        try
          {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(2, c.getEmail());
            pstmt.setString(3, c.getUserName());
            pstmt.setString(4, c.getFirstName());
            pstmt.setString(5, c.getLastName());
            pstmt.setString(7, c.getPassWord());
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            
          } catch (SQLException ex)
          {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
          }
        finally
          {
            try
              {
                conn.close();
              } catch (SQLException ex)
              {
                Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
      }
    
}
