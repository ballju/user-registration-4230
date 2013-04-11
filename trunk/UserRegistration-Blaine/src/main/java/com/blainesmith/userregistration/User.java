package com.blainesmith.userregistration;

import java.util.Date;

/**
 *
 * @author Blaine
 */
public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String passWord;
    private Date date;
    private int id;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(String fName, String lName, String email, String uName, String pWord) {
        this.firstName = fName;
        this.firstName = lName;
        this.email = email;
        this.userName = uName;
        this.passWord = pWord;
    }
    public User(int id, String fName, String lName, String email, String uName, Date date) {
        this.id = id;
        this.firstName = fName;
        this.lastName = lName;
        this.userName = uName;
        this.email = email;
        this.date = date;
    }

    public User(int id, String fName, String lName, String email, String uName, String pWord, Date date) {
        this.id = id;
        this.firstName = fName;
        this.lastName = lName;
        this.userName = uName;
        this.passWord = pWord;
        this.email = email;
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id;
        return hash;
    }
}
