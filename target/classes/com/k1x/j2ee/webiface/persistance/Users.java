/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.k1x.j2ee.webiface.persistance;

/**
 *
 * @author k1x
 */
public class Users {
    
    private int id;
    private String name;
    private String password;
    private String fullname;
    
    private boolean loggedIn = false;
    
    public Users(String name, String password, String fullname)
    {
        this.name=name;
        this.password=password;
        this.fullname=fullname;
        this.loggedIn = true;
    }
    
    public Users()
    {
    	
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

    @Override
    public boolean equals(Object U)
    {
        if (this == U)
            return true;
        if (!(U instanceof Users))
            return false;
        Users USR = (Users) U;
        return (this.getId() == USR.getId() && name.equals(USR.getName()) && this.password.equals(USR.getPassword()) && this.fullname.equals(USR.getFullname())) ;

    }

    @Override
    public int hashCode() {
        return 1 + id + name.hashCode() + password.hashCode() + fullname.hashCode();
    }
}
