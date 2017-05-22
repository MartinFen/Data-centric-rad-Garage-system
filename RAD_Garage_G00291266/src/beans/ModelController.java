package beans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class ModelController {

	private ArrayList<Model> models;
	private DAO dao;

	public ModelController() {
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Model> getModels() {
		return models;
	}
	
	public void loadModels() throws Exception {
		models = dao.getModelDetails();
	}
	
	public String addModels(Model m) throws SQLException {
		try
		{
			dao.addModel(m);
			return "Models";
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
