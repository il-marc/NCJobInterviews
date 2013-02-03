/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.k1x.j2ee.webiface.util;

/**
 *
 * @author k1x
 */
public class UserData {
    protected int id;
    protected String username;
    protected String password;
    protected String fullname;
   
    public UserData(int id, String username, String password, String fullname)
    {
    	this.id = id;
    	this.username = username;
    	this.password = password;
    	this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
        
}
