/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blainesmith.userregistration;

import java.util.Calendar;
import java.util.Random;

/**
 *
 * @author Christopher
 */
public class UserService {
    
    public static boolean logUserIn (User user) {
        return true;
    }
    
    public static boolean createUser (User user) {
        return true;
    }
    
    public static boolean resetPassword (User user) {
        Random r = new Random(Calendar.getInstance().getTimeInMillis());
        
        char[] newPassArr = new char[10];
        for (int i = 0; i < 10; i++) {
            int charCode = (r.nextInt() % 127);
            
            if ((charCode >= 0 && charCode <= 32) || charCode == 127 || charCode == 92)
                charCode = 97;
            
            newPassArr[i] = (char)charCode;
        }
        
        String newPass = new String(newPassArr);
        
        System.out.println(newPass);
        
        return true;
    }
    
}
