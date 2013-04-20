/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blainesmith.userregistration;

import com.sun.mail.smtp.SMTPTransport;
import java.security.Security;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christopher
 */
public class UserService {

    
    private final static String emailAddress = "cs4230.7654@gmail.com";
    private final static String emailPassword = "brought$67";

    
    public static User logUserIn (User user) {
        try {
            user = DAO.getUser(user);
            
            return user;
        }
        catch (Exception ex) {
            user.setError(ex.getMessage());
            return user;
        }
    }
    
    public static User createUser (User user)
    {
        try {
            if (user.getEmail() == null || user.getEmail().equals("")) {
                user.setError("Email can not be null");          
                return user;
            }
            
            if (user.getPassWord() == null || user.getPassWord().equals("")) {
                user.setError("Password can not be null");          
                return user;
            }
            
            return DAO.insertUser(user);
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
            user.setError(ex.getMessage());          
            return user;
        }
    }
    
    public static User updateUserInfo (User user)
    {
        try {
        user = DAO.updateUserInfo(user);
        }
        catch (Exception ex) {
            user.setError(ex.getMessage());
            return user;
        }
        
        return user;
    }
    
    public static User updateUserPassword (User user) {
        try {
            user = DAO.updateUserPassword(user);
        }
        catch (Exception ex) {
            user.setError(ex.getMessage());
            return user;
        }
        
        return user;
    }
    
    public static String resetPassword (User user) {
        try {
            boolean found = DAO.checkUserByEmail(user.getEmail());

            if (!found)
                return "That user was not found";

            Random r = new Random(Calendar.getInstance().getTimeInMillis());

            char[] newPassArr = new char[10];
            for (int i = 0; i < 10; i++) {
                int charCode = r.nextInt(128);

                if ((charCode >= 0 && charCode <= 32) || charCode == 127 || charCode == 92)
                    charCode = 97;
                System.out.println(charCode);
                newPassArr[i] = (char)charCode;
            }

            String newPass = new String(newPassArr);
            
            user.setPassWord(newPass);
            user = DAO.updateUserPassword(user);
            
            if (user.getError() != null && !user.getError().equals("")) {
                return user.getError();
            }

            sendEmail(user.getEmail(), newPass);

            return "SUCCESS";
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }
    }
    
    private static void sendEmail(String recipientEmail, String newPassword) {
        try {
            String title = "Password reset for user on CS4230 project";
            String message = "Your password has been reset to " + newPassword;
            
            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

            // Get a Properties object
            Properties props = System.getProperties();
            props.setProperty("mail.smtps.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            props.setProperty("mail.smtp.port", "465");
            props.setProperty("mail.smtp.socketFactory.port", "465");
            props.setProperty("mail.smtps.auth", "true");

            /*
            If set to false, the QUIT command is sent and the connection is immediately closed. If set 
            to true (the default), causes the transport to wait for the response to the QUIT command.

            ref :   http://java.sun.com/products/javamail/javadocs/com/sun/mail/smtp/package-summary.html
                    http://forum.java.sun.com/thread.jspa?threadID=5205249
                    smtpsend.java - demo program from javamail
            */
            props.put("mail.smtps.quitwait", "false");

            Session session = Session.getInstance(props, null);

            // -- Create a new message --
            final MimeMessage msg = new MimeMessage(session);

            // -- Set the FROM and TO fields --
            msg.setFrom(new InternetAddress(emailAddress));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail, false));

    //        if (ccEmail.length() > 0) {
    //            msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccEmail, false));
    //        }

            msg.setSubject(title);
            msg.setText(message, "utf-8");
            msg.setSentDate(new Date());

            SMTPTransport t = (SMTPTransport)session.getTransport("smtps");

            t.connect("smtp.gmail.com", emailAddress, emailPassword);
            t.sendMessage(msg, msg.getAllRecipients());      
            t.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
