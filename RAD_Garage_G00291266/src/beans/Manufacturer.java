package beans;

import javax.faces.bean.*;

@ManagedBean
public class Manufacturer {
	//Instance variables start here---------------------------------------------
	private String manucode;
	private String manuname;
	private String manudetails;
	
	//Constructors start here----------------------------------------------------
	public Manufacturer() {}

	public Manufacturer(String manucode, String manuname, String manudetails) {
		super();
		this.manucode = manucode;
		this.manuname = manuname;
		this.manudetails = manudetails;
	}
	
	//Accessor methods start here------------------------------------------------
	//Getters--------------------------------------------------------------------
	public String getManucode() {
		return manucode;
	}

	public String getManuname() {
		return manuname;
	}

	public String getManudetails() {
		return manudetails;
	}
	
	//Setters--------------------------------------------------------------------
	public void setManucode(String manucode) {
		this.manucode = manucode;
	}

	public void setManuname(String manuname) {
		this.manuname = manuname;
	}
	
	public void setManudetails(String manudetails) {
		this.manudetails = manudetails;
	}
}
