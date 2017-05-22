package beans;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class SearchController {
	
	private ArrayList<Search> search;
	private DAO dao;
	
	public SearchController() {
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Search> getSearch() {
		return search;
	}
	
	/*
	public void loadSearch() throws Exception {
		search = dao.getSearchDetails(null);
	}*/

	public String searchVehicle(Search s) throws Exception {
		try
		{
			System.out.println("Try In controller");
			search = dao.getSearchDetails(s);
		} 
		catch (Exception e) 
		{
			FacesMessage message = new FacesMessage("Error: " + e); 
			FacesContext.getCurrentInstance().addMessage(null, message);
			System.out.println("Catch In controller");
			e.getMessage();
			return e.toString();
		}	
		return "SearchResults";
	}

}
