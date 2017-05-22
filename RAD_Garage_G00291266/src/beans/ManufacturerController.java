package beans;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ManufacturerController {

	private ArrayList<Manufacturer> manufacturers;
	private DAO dao;

	public ManufacturerController() {
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Manufacturer> getManufacturers() throws Exception {
		return manufacturers;
	}

	public void loadManufacturers() throws Exception {
		manufacturers = dao.getManufacturerDetails();
	}
	
	public String addManufacturer(Manufacturer m) throws Exception {
		try
		{
			dao.addManufacturer(m);
			return "Manufacturers";
		} 
		catch (Exception e) 
		{
			FacesMessage message = new FacesMessage("Error: " + e); 
			FacesContext.getCurrentInstance().addMessage(null, message);
			e.getMessage();
			return e.toString();
		}	
	}
	
	public String loadUpdateDetails(Manufacturer m) throws Exception {
		
		try
		{
			Manufacturer Man = dao.getUpdateDetails(m);
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			Map<String, Object> Map = externalContext.getRequestMap();
			Map.put("manufacturer", Man);
		} 
		catch (Exception e) 
		{
			e.getMessage();
			return null;
		}
		return "UpdateManufacturer";
	}
	
	public String updateManufacturer(Manufacturer m) throws Exception{
		
		try {
			dao.updateManufacturer(m);
			return "Manufacturers";
		}
		catch (Exception e) {
			FacesMessage message = new FacesMessage("Error: " + e); 
			FacesContext.getCurrentInstance().addMessage(null, message);
			e.printStackTrace();
			return null;
		}	
	}
	
	public String deleteManufacturer(Manufacturer m) throws Exception {
		try
		{
			dao.deleteManufacturer(m);
			return "Manufacturers";
		} 
		catch (Exception e) 
		{
			FacesMessage message = new FacesMessage("Error: " + e); 
			FacesContext.getCurrentInstance().addMessage(null, message);
			e.getMessage();
			return e.toString();
		}	
	}
}
