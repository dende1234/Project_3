package ProjectData;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class NextPage extends JFrame {
	private static Con_sql con_sql;
	
	
	public NextPage(){
		//calls the page
		makePage();
		con_sql = new Con_sql();
	}
	
	public static void main(String[] args){
		NextPage nextPage = new NextPage();
		
	}
	
	public void makePage(){
		//Sets up the frame
		JFrame frame = new JFrame("Map");
		try{
			frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:/Users/Danny Hoogeveen/Pictures/rotterdam_wijken.png")))));
		}catch(IOException e){
			System.out.println("Image doesn't exist");
		}
		
		frame.pack();
		frame.setLayout(null);
		frame.setVisible(true);
		
		//creates the buttons on the map
		JButton open = new JButton("");
		open.setSize(125, 50);
		open.setLocation(310, 180);
        open.setBorderPainted(true);
        open.setContentAreaFilled(false);
        open.setOpaque(false);
		frame.add(open);
		
		JButton back = new JButton("Back to Main Menu");
		back.setSize(150, 50);
		back.setLocation(1050, 800);
		frame.add(back);
		
		//button actions.
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				//get back to main menu
				MenuMain frame = new MenuMain();
				frame.setVisible(true);
				
			}
		});
		
		open.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				List<Integer> years = new ArrayList<Integer>();
				//see the visualizationpage
				try {
					years = con_sql.query_1();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				CentrumPage frame = new CentrumPage();
				frame.setVisible(true);
			}
		});
		
		
	}
	
	
	

}
