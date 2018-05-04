package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Modules {
	private String modCode;
	private String modName;
	private int modCredits;
	private int modHours;
	
	public Modules(){
		this.modCode = null;
		this.modName = null;
		this.modCredits = 0;
		this.modHours = 0;
	}
	
	//Retrieve Module Credits from the 'modules' table given the module code
	public int getModCredits(String modCode){
		
		try{
			new databaseConnect();
			Connection conn = databaseConnect.getConnection();
			
			PreparedStatement getCreds = conn.prepareStatement("SELECT modCredits FROM modules WHERE modCode = ?");
			getCreds.setString(1,modCode);
			ResultSet result = getCreds.executeQuery();
			
			if(result.first()){
				this.modCredits = result.getInt("modCredits");
			}
			
		}catch(Exception e){System.out.println(e);}
		
		return this.modCredits;
	}
	
	//Retrieve the total Module hours given the module code from the 'modules' table
	public int getModHours(String modCode){
		
		try{
			new databaseConnect();
			Connection conn = databaseConnect.getConnection();
			
			PreparedStatement getHours = conn.prepareStatement("SELECT modHours FROM modules WHERE modCode = ?");
			getHours.setString(1, modCode);
			ResultSet result = getHours.executeQuery();
			
			if(result.first()){
				this.modHours = result.getInt(1);
				return this.modHours;
			}
		}catch(Exception e){}
		
		return this.modHours;
	}
}
