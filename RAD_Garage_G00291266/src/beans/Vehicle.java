package beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Vehicle {

	private String reg;
	private String manucode;
	private String manuname;
	private String manudetails;
	private String modelcode;
	private String modelname;
	private String modeldesc;
	private int mileage;
	private float price;
	private String priceDropdown;
	private String colour;
	private String fueltype;
	
	public Vehicle() {
		super();
	}

	public Vehicle(String reg, String manucode, String modelcode, int mileage, float price, String colour,
			String fueltype) {
		super();
		this.reg = reg;
		this.manucode = manucode;
		this.modelcode = modelcode;
		this.mileage = mileage;
		this.price = price;
		this.colour = colour;
		this.fueltype = fueltype;
	}

	public Vehicle(String reg, String manucode, String manuname, String manudetails, String modelcode, String modelname,
			String modeldesc, int mileage, float price, String colour, String fueltype) {
		super();
		this.reg = reg;
		this.manucode = manucode;
		this.manuname = manuname;
		this.manudetails = manudetails;
		this.modelcode = modelcode;
		this.modelname = modelname;
		this.modeldesc = modeldesc;
		this.mileage = mileage;
		this.price = price;
		this.colour = colour;
		this.fueltype = fueltype;
	}

	public Vehicle(float price, String priceDropdown, String colour, String fueltype) {
		this.price = price;
		this.priceDropdown = priceDropdown;
		this.colour = colour;
		this.fueltype = fueltype;
	}

	public String getReg() {
		return reg;
	}

	public String getManucode() {
		return manucode;
	}
	
	public String getManuname() {
		return manuname;
	}

	public String getManudetails() {
		return manudetails;
	}

	public String getModelcode() {
		return modelcode;
	}
	
	public String getModelname() {
		return modelname;
	}

	public String getModeldesc() {
		return modeldesc;
	}

	public int getMileage() {
		return mileage;
	}

	public float getPrice() {
		return price;
	}

	public String getColour() {
		return colour;
	}

	public String getFueltype() {
		return fueltype;
	}

	public void setReg(String reg) {
		this.reg = reg;
	}

	public void setManucode(String manucode) {
		this.manucode = manucode;
	}

	public void setManuname(String manuname) {
		this.manuname = manuname;
	}

	public void setManudetails(String manudetails) {
		this.manudetails = manudetails;
	}
	
	public void setModelcode(String modelcode) {
		this.modelcode = modelcode;
	}
	
	public void setModelname(String modelname) {
		this.modelname = modelname;
	}

	public void setModeldesc(String modeldesc) {
		this.modeldesc = modeldesc;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public void setFueltype(String fueltype) {
		this.fueltype = fueltype;
	}
}
