package beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Search {
	
	private String priceDropdown;
	private String reg;
	private String manucode;
	private String manuname;
	private String modcode;
	private String modname;
	private int mileage;
	private float price;
	private String colour;
	private String fueltype;
	
	public Search() {
		super();
	}

	public Search(String priceDropdown, float price, String colour, String fueltype) {
		super();
		this.priceDropdown = priceDropdown;
		this.price = price;
		this.colour = colour;
		this.fueltype = fueltype;
	}

	public Search(String reg, String manucode, String manuname, String modcode, String modname, int mileage,
			float price, String colour, String fueltype) {
		this.reg = reg;
		this.manucode = manucode;
		this.manuname = manuname;
		this.modcode = modcode;
		this.modname = modname;
		this.mileage = mileage;
		this.price = price;
		this.colour = colour;
		this.fueltype = fueltype;
	}
	

	public String getPriceDropdown() {
		return priceDropdown;
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

	public void setPriceDropdown(String priceDropdown) {
		this.priceDropdown = priceDropdown;
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
	
	public String getReg() {
		return reg;
	}

	public String getManucode() {
		return manucode;
	}

	public String getManuname() {
		return manuname;
	}

	public String getModcode() {
		return modcode;
	}

	public String getModname() {
		return modname;
	}

	public int getMileage() {
		return mileage;
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

	public void setModcode(String modcode) {
		this.modcode = modcode;
	}

	public void setModname(String modname) {
		this.modname = modname;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
}
