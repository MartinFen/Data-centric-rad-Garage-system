package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.*;
import javax.sql.DataSource;

public class DAO {

	private DataSource mysqlDS;
	private ArrayList<Search> search;

	public DAO() throws Exception 
	{
		Context context = new InitialContext();
		String jndiName = "java:comp/env/jdbc/garage";
		mysqlDS = (DataSource) context.lookup(jndiName);
	}

	//Manufacturer methods------------------------------------------------------------------------- 
	public ArrayList<Manufacturer> getManufacturerDetails() throws Exception {

		ArrayList<Manufacturer> manufacturers = new ArrayList<>();

		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("Select * "
				+ "from manufacturer");

		ResultSet rs = myStmt.executeQuery();

		while (rs.next()) {
			String mcode = rs.getString("manu_code");
			String mname = rs.getString("manu_name");
			String mdetails = rs.getString("manu_details");
			manufacturers.add(new Manufacturer(mcode, mname, mdetails));
		}
		conn.close();
		myStmt.close();
		return manufacturers;
		
	}
	
	public void addManufacturer(Manufacturer m) throws SQLException {
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("INSERT INTO Manufacturer values(?, ?, ?)");

		myStmt.setString(1, m.getManucode());
		myStmt.setString(2, m.getManuname());
		myStmt.setString(3, m.getManudetails());

		myStmt.executeUpdate();
		conn.close();
		myStmt.close();
	}
	
	public Manufacturer getUpdateDetails(Manufacturer m) {
		
		Manufacturer manufacturers = null;
		
		try
		{
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("Select * from manufacturer where manu_code = ?");
		myStmt.setString(1, m.getManucode());
		ResultSet rs = myStmt.executeQuery();

		while (rs.next()) 
		{
			String mcode = rs.getString("manu_code");
			String mname = rs.getString("manu_name");
			String mdetails = rs.getString("manu_details");
			
			manufacturers = new Manufacturer(mcode, mname, mdetails);
		}
		conn.close();
		myStmt.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return manufacturers;
	}
	
	public void updateManufacturer(Manufacturer m) throws SQLException {
			
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("Update manufacturer"
				+ " Set manu_name = ?,"
				+ " manu_details = ?"
				+ " where manu_code = ?");

		myStmt.setString(1, m.getManuname());
		myStmt.setString(2, m.getManudetails());
		myStmt.setString(3, m.getManucode());
	
		myStmt.executeUpdate();
		conn.close();
		myStmt.close();
		
	}
	
	public void deleteManufacturer(Manufacturer m) throws SQLException {
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("Delete From Manufacturer where manu_code=?");

		myStmt.setString(1, m.getManucode());

		myStmt.executeUpdate();
		conn.close();
		myStmt.close();
	}

	//Model methods--------------------------------------------------------------------------------
	public ArrayList<Model> getModelDetails() throws SQLException {
		
		ArrayList<Model> models = new ArrayList<>();

		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("Select * "
				+ "from model");

		ResultSet rs = myStmt.executeQuery();

		while (rs.next()) {
			String mfcode = rs.getString("manu_code");
			String mcode = rs.getString("model_code");
			String mname = rs.getString("model_name");
			String mdesc = rs.getString("model_desc");
			models.add(new Model(mfcode,mcode ,mname,mdesc));
		}
		conn.close();
		myStmt.close();
		return models;
	}

	public void addModel(Model m) throws SQLException {
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("INSERT INTO Model values(?, ?, ?, ?)");

		myStmt.setString(1, m.getManucode());
		myStmt.setString(2, m.getModelcode());
		myStmt.setString(3, m.getModelname());
		myStmt.setString(4, m.getModeldesc());

		myStmt.executeUpdate();
		conn.close();
		myStmt.close();
	}
	
	//Vehcle methods--------------------------------------------------------------------------------
	public ArrayList<Vehicle> getVehicleDetails() throws SQLException {
		ArrayList<Vehicle> vehicles = new ArrayList<>();

		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("Select * "
				+ "from Vehicle");//Change this to Join-------------------------manu_code is missing from data table-----

		ResultSet rs = myStmt.executeQuery();

		while (rs.next()) {
			String vreg = rs.getString("reg");
			String mfcode = rs.getString("manu_code");
			String mcode = rs.getString("model_code");
			int vmileage = rs.getInt(4);
			float vprice = rs.getFloat(5);
			String vcolour = rs.getString("colour");
			String ftype = rs.getString("fuel");
			vehicles.add(new Vehicle(vreg,mfcode,mcode,vmileage,vprice,vcolour,ftype));
		}
		conn.close();
		myStmt.close();
		return vehicles;
	}

	public void addVehicle(Vehicle v) throws SQLException {
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("INSERT INTO Vehicle values(?, ?, ?, ?, ?, ?, ?)");

		myStmt.setString(1, v.getReg());
		myStmt.setString(2, v.getManucode());
		myStmt.setString(3, v.getModelcode());
		myStmt.setInt(4, v.getMileage());
		myStmt.setFloat(5, v.getPrice());
		myStmt.setString(6, v.getColour());
		myStmt.setString(7, v.getFueltype());
		
		myStmt.executeUpdate();
		conn.close();
		myStmt.close();
	}

	public Vehicle getFullVehicleDetails(Vehicle v) throws SQLException {

		Vehicle vehicle  = null;
		
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("select v.reg, m.manu_code, m.manu_name, "
				+ "m.manu_details, mo.model_code, mo.model_name, "
				+ "mo.model_desc, v.mileage, v.price, v.colour, v.fuel  "
				+ "from vehicle v "
				+ "left join manufacturer m "
				+ "on v.manu_code = m.manu_code "
				+ "left join model mo "
				+ "on m.manu_code = mo.manu_code "
				+ "where v.reg like ?;");
		
		myStmt.setString(1, v.getReg());
		ResultSet rs = myStmt.executeQuery();
		
		System.out.println("before the while loop");
		while (rs.next()) {
			
			String reg = rs.getString("reg");
			String manu_code = rs.getString("manu_code");
			String manu_name = rs.getString("manu_name");
			String manu_details = rs.getString("manu_details");
			String model_code = rs.getString("model_code");
			String model_name = rs.getString("model_name");
			String model_desc = rs.getString("model_desc");
			int mileage = rs.getInt("mileage");
			float price = rs.getFloat("price");
			String colour = rs.getString("colour");
			String fuel = rs.getString("fuel");
			
			vehicle = new Vehicle(reg, manu_code, manu_name, manu_details, model_code, model_name, model_desc, mileage, price, colour, fuel);
		}
		return vehicle;
	}
	
	//Search Methods-------------------------------------------------------------
	public ArrayList<Search> getSearchDetails(Search s) throws SQLException {
		
		ArrayList<Search> search = new ArrayList<>();
		
		try
		{
		System.out.println("Try In DAO");
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = null;
		if (s.getPriceDropdown().contains("Less")) 
		{
			System.out.println("Else if(Less) in DAO before statement");
			myStmt = conn.prepareStatement("select v.reg, v.manu_code, m.manu_name, "
					+ "v.model_code, mo.model_name, "
					+ "v.mileage, v.price, v.colour, v.fuel "
					+ "from vehicle v "
					+ "join manufacturer m "
					+ "on v.manu_code = m.manu_code "
					+ "join model mo "
					+ "on v.model_code = mo.model_code "
					+ "where v.price <= ? "
					+ "and v.colour like ? "
					+ "and v.fuel like ?");
			myStmt.setFloat(1, s.getPrice());
			myStmt.setString(2, s.getColour());
			myStmt.setString(3, s.getFueltype());
		} 
		else if(s.getPriceDropdown().contains("Greater")) 
		{
			System.out.println("Else if(Greater) in DAO Before statement");
			myStmt = conn.prepareStatement("select v.reg, v.manu_code, m.manu_name, "
					+ "v.model_code, mo.model_name, "
					+ "v.mileage, v.price, v.colour, v.fuel "
					+ "from vehicle v "
					+ "join manufacturer m "
					+ "on v.manu_code = m.manu_code "
					+ "join model mo "
					+ "on v.model_code = mo.model_code "
					+ "where v.price >= ? "
					+ "and v.colour like ? "
					+ "and v.fuel like ?");
			myStmt.setFloat(1, s.getPrice());
			myStmt.setString(2, s.getColour());
			myStmt.setString(3, s.getFueltype());
		}
		else if(s.getPriceDropdown().contains("Equal"))
		{
			System.out.println("Else if(Equal) in DAO before statement");
			myStmt = conn.prepareStatement("select v.reg, v.manu_code, m.manu_name, "
					+ "v.model_code, mo.model_name, "
					+ "v.mileage, v.price, v.colour, v.fuel "
					+ "from vehicle v "
					+ "join manufacturer m "
					+ "on v.manu_code = m.manu_code "
					+ "join model mo "
					+ "on v.model_code = mo.model_code "
					+ "where v.price = ? "
					+ "and v.colour like ? "
					+ "and v.fuel like ?");
			myStmt.setFloat(1, s.getPrice());
			myStmt.setString(2, s.getColour());
			myStmt.setString(3, s.getFueltype());
		}
		
		ResultSet rs = myStmt.executeQuery();
		while (rs.next()) 
		{
			String reg = rs.getString("reg");
			String manucode = rs.getString("manu_code");
			String manuname = rs.getString("manu_name");
			String modcode = rs.getString("model_code");
			String modname = rs.getString("model_name");
			int mile = rs.getInt("mileage");
			float price = rs.getFloat("price");
			String colour = rs.getString("colour");
			String fueltype = rs.getString("fuel");
			
			search.add(new Search(reg, manucode, manuname, modcode, modname, mile, price,colour,fueltype));
			System.out.println("RS Loop in DAO");
		}
		conn.close();
		myStmt.close();
		 
		}
		catch (Exception e) 
		{
			System.out.println("Catch In DAO");
			e.printStackTrace();
		}
		System.out.println(search.get(0).getReg().toString());
		return search;
	}
}