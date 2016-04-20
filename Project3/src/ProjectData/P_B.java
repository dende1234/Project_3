package ProjectData;
//Politiebureaus

import javax.imageio.ImageIO;
import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class P_B extends JFrame {
	static Connection connection = null;
	
	public P_B() throws SQLException{
		createPage();
	}

	public static void main(String[] args) throws SQLException {
		P_B p_B = new P_B();
	}
	
	public void createPage() throws SQLException{
		String Region[] = {
				"North",
				"South",
				"East",
				"West"
			};
			
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
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select count(pb_code), Region from pb_adres group by Region");
			DefaultPieDataset dataset = new DefaultPieDataset();
			while(resultSet.next()){
				dataset.setValue(
						resultSet.getString("region"),
						Double.parseDouble(resultSet.getString(1)));
			}
			JFreeChart chart = ChartFactory.createPieChart(
					"Policestations in Rotterdam",
					dataset,
					true,
					true,
					false);
			
			int width = 900;
			int height = 370;
			
			JFrame frame = new JFrame("PieChart");
			
			BufferedImage image = chart.createBufferedImage(1080, 780);
			JLabel label = new JLabel();
			label.setIcon(new ImageIcon(image));
			frame.getContentPane().add(label);
			
			frame.pack();
			frame.setVisible(true);
	
	}

}
