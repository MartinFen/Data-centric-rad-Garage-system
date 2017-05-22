package beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Model {

	private String manucode;
	private String modelcode;
	private String modelname;
	private String modeldesc;

	public Model() {
	}

	public Model(String manucode, String modelcode, String modelname, String modeldesc) {
		super();
		this.manucode = manucode;
		this.modelcode = modelcode;
		this.modelname = modelname;
		this.modeldesc = modeldesc;
	}

	public String getManucode() {
		return manucode;
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

	public void setManucode(String manucode) {
		this.manucode = manucode;
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
	
}
