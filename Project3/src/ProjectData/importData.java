package ProjectData;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.io.IOException;

public class importData extends MenuMain{
	//Sets connection to the data sources
	static Connection connection = null;

	public static void main(String[] args) {
		//Sets connection to the database
		System.out.println("---PostgreSQL " + " JDBC connection Testing---");
		
		try{
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e){
			System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
			e.printStackTrace();
			return;
		}
		System.out.println("PostgreSQL JDBC Driver Registered!");
		
		//Sets connection to the data sources
		
		try{
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Project 3", "postgres", "euro2004");
		}catch (SQLException e){
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
		
		if(connection != null){
			System.out.println("You made it, take control of your database now!");
		}else{
			System.out.println("Failed to make connection!");
		}
		try{
			query_1();
		}catch(SQLException e){
			System.out.println(e);
		}
		// Runs the main menu
		MenuMain.main(args);		
		
		}
	public static void query_1() throws SQLException{
		Statement statement = connection.createStatement();
		String query = "select * from monument";
		ResultSet rs = statement.executeQuery(query);
		System.out.println(rs);
		while(rs.next()){
			System.out.println(rs.getString("mon_onthulling"));
			
		}
	}

}


