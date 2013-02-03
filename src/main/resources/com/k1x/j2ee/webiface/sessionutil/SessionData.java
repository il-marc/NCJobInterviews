package com.k1x.j2ee.webiface.sessionutil;

import com.k1x.j2ee.webiface.persistance.Users;

public class SessionData {

    private String sessionID;
	private int Mode;
	private Users user;
	private int calcId;

	public static final int CALCULATIONS_LIST = 1;
	public static final int REGISTER = 2;
	public static final int ADD_CALCULATION = 3;
	public static final int VIEW_CALCULATION = 4;
	

	public int getMode() {
		return Mode;
	}
	public void setMode(int mode) {
		Mode = mode;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public boolean isUserLoggedIn() {
		return user!=null;
	}
	public void setUserLoggedIn(boolean userLogedIn) {
		user.setLoggedIn(userLogedIn);
	}
	public int getCalcId() {
		return calcId;
	}
	public void setCalcId(int calcId) {
		this.calcId = calcId;
	}
    public String getSessionID() {
        return sessionID;
    }
    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    @Override
    public boolean equals(Object U)
    {
        if (this == U)
            return true;
        if (!(U instanceof SessionData))
            return false;
        SessionData sd = (SessionData) U;
        return sessionID.equals(sd.getSessionID())&& user.equals(sd.getUser());
    }

    @Override
    public int hashCode() {
        if(sessionID!=null && user!=null)
        return 1 + sessionID.hashCode() + user.hashCode();
        else return 2;
    }
}
