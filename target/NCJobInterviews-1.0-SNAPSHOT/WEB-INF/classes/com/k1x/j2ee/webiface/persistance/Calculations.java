package com.k1x.j2ee.webiface.persistance;

import java.io.Serializable;

public class Calculations implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -126190253735318671L;
	
	private int id;
	private int complete;
	private int uid;
	private int n;
	private int k;
	private String name;
	private String data;
	
	public Calculations(int id, int complete, int uid, String name, String data, int n, int k)
	{
		setId(id);
		setComplete(complete);
		setUid(uid);
		setName(name);
		setData(data);
		setN(n);
		setK(k);
	}
	
	public Calculations(int complete, int uid, String name, String data)
	{
		setComplete(complete);
		setUid(uid);
		setName(name);
		setData(data);
	}

	public Calculations()
	{
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getComplete() {
		return complete;
	}
	public void setComplete(int complete) {
		this.complete = complete;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getData() {
		return data;
	}
	@Override
	public String toString() {
		String seperator = "|";
		StringBuffer sb = new StringBuffer();
		sb.append(id).append(seperator)	
		.append(complete).append(seperator)	
		.append(uid).append(seperator)	
		.append(name).append(seperator)	
		.append(data).append(seperator)
		.append(super.toString());

		return sb.toString();
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}

    @Override
    public boolean equals(Object U)
    {
        if (this == U)
            return true;
        if (!(U instanceof Calculations))
            return false;
        Calculations C = (Calculations) U;
            return (this.id == C.getId() && this.complete == C.getComplete() && this.uid ==C.getUid() && this.n == C.getN() && this.k == C.getK()) ;

    }

    @Override
    public int hashCode() {
        return id + complete + uid + n + k + name.hashCode() + data.hashCode();
    }
}
