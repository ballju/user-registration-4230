
package com.cs4230final.userregistration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserServiceTest {
    
    public UserServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
        User user = new User();
        user.setEmail("ninteycaliberlupara@yahoo.com");
        user.setPassWord("Aa@12345");
        user.setFirstName("Chris");
        user.setLastName("Pink");
        
        UserService.updateUserInfo("christopherbyronpink@yahoo.com", user);
        UserService.updateUserPassword(user);
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        
    }

    /**
     * Test of logUserIn method, of class UserService.
     */
    @Test
    public void testLogUserIn() {
        System.out.println("logUserIn");
        
        User user = new User();
        user.setEmail("ninteycaliberlupara@yahoo.com");
        user.setPassWord("Aa@12345");
        
        User expResult = new User();
        expResult.setEmail("ninteycaliberlupara@yahoo.com");
        expResult.setFirstName("Chris");
        expResult.setLastName("Pink");
        
        User result = UserService.logUserIn(user);
        
        assertEquals(expResult.getEmail(), result.getEmail());
        assertEquals(expResult.getFirstName(), result.getFirstName());
        assertEquals(expResult.getLastName(), result.getLastName());
        
        assertEquals(expResult.getError(), null);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of createUser method, of class UserService.
     */
    @Test
    public void testCreateUser() {
        System.out.println("createUser");
        
        User user = new User();
        user.setEmail("christopherbyronpink@yahoo.com");
        user.setPassWord("Aa@12345");
        user.setFirstName("Don");
        user.setLastName("Juan");
        
        User expResult = new User();
        expResult.setEmail("christopherbyronpink@yahoo.com");
        //expResult.setPassWord("Aa@12345");
        expResult.setFirstName("Don");
        expResult.setLastName("Juan");
        
        User result = UserService.createUser(user);
        
        assertEquals(expResult.getEmail(), result.getEmail());
        assertEquals(expResult.getFirstName(), result.getFirstName());
        assertEquals(expResult.getLastName(), result.getLastName());
        
        assertEquals(expResult.getError(), null);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of deleteUser method, of class UserService.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        
        User user = new User();
        user.setEmail("christopherbyronpink@yahoo.com");
        
        String expResult = "SUCCESS";
        String result = UserService.deleteUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateUserInfo method, of class UserService.
     */
    @Test
    public void testUpdateUserInfo() {
        System.out.println("updateUserInfo");
        String email = "ninteycaliberlupara@yahoo.com";
        
        User user = new User();
        user.setEmail("christopherbyronpink@yahoo.com");
        user.setFirstName("Ricky");
        user.setLastName("Ricardo");
        
        User expResult = new User();
        expResult.setEmail("christopherbyronpink@yahoo.com");
        expResult.setFirstName("Ricky");
        expResult.setLastName("Ricardo");
        
        User result = UserService.updateUserInfo(email, user);
        
        assertEquals(expResult.getEmail(), result.getEmail());
        assertEquals(expResult.getFirstName(), result.getFirstName());
        assertEquals(expResult.getLastName(), result.getLastName());
        
        assertEquals(expResult.getError(), null);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateUserPassword method, of class UserService.
     */
    @Test
    public void testUpdateUserPassword() {
        System.out.println("updateUserPassword");
        
        User user = new User();
        user.setEmail("christopherbyronpink@yahoo.com");
        user.setPassWord("Bb$98765");
        
        User expResult = new User();
        expResult.setEmail("christopherbyronpink@yahoo.com");
        expResult.setPassWord("Bb$98765");
        
        User result = UserService.updateUserPassword(user);
        assertEquals(expResult.getEmail(), result.getEmail());
        assertEquals(expResult.getPassWord(), result.getPassWord());
        
        assertEquals(expResult.getError(), null);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of resetPassword method, of class UserService.
     */
    @Test
    public void testResetPassword() {
        System.out.println("resetPassword");
        
        User user = new User();
        user.setEmail("christopherbyronpink@yahoo.com");
        
        String expResult = "SUCCESS";
        String result = UserService.resetPassword(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
}
