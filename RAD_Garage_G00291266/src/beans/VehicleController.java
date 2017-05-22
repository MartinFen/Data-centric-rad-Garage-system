package beans;

import java.util.*;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.*;

@ManagedBean
@SessionScoped
public class VehicleController {

	private ArrayList<Vehicle> vehicles;
	private DAO dao;
	
	public VehicleController() {
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}
	
	public void setVehicles(ArrayList<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public void loadVehicles() throws Exception {
		vehicles=dao.getVehicleDetails();
	}

	public String addVehicle(Vehicle v) throws Exception {
		try {
			dao.addVehicle(v);
			return "Vehicles";
		} catch (Exception e) {
			FacesMessage message = new FacesMessage("Error: " + e); 
			FacesContext.getCurrentInstance().addMessage(null, message);
			e.getMessage();
			return e.toString();
		}
	}

	public String loadAllVehicleDetails(Vehicle v)throws Exception {

		try 
		{
			System.out.println("In the the try of VehicleController.loadAllVehicleDetails");
			
			Vehicle All= dao.getFullVehicleDetails(v);
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			Map<String, Object> requestMap = externalContext.getRequestMap();
			requestMap.put("vehicle", All);	
			
			return "FullVehiclesDetails";
		}
		catch(Exception e) 
		{
			FacesMessage message = new FacesMessage("Error: " + e); 
			FacesContext.getCurrentInstance().addMessage(null, message);
			System.out.println("Catch in the Controller");
			e.printStackTrace();
			return null;
		}
		
		
	}
	
}
