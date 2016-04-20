package ProjectData;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class NextPage extends JFrame {	
	
	public NextPage(){
		//calls the page
		makePage();
	}
	
	public static void main(String[] args){
		//NextPage nextPage = new NextPage();
		
	}
	
	public void makePage(){
		JFrame frame = this;
		//Sets up the frame
		//JFrame frame = new JFrame("Map");
		try{
			frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:/Users/Danny Hoogeveen/Pictures/Kaart.png")))));
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
		back.setLocation(780, 650);
		frame.add(back);
		
		JButton p_b = new JButton("Policestations");
		p_b.setSize(150, 50);
		p_b.setLocation(780, 500);
		frame.add(p_b);
		
		JButton mon = new JButton("Monuments");
		mon.setSize(150, 50);
		mon.setLocation(780, 440);
		frame.add(mon);
		
		//button actions.
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				//get back to main menu
				MenuMain frame = new MenuMain();
				//frame.setVisible(true);
				
			}
		});
		
		open.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CentrumPage frame = null;
				try {
					frame = new CentrumPage();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//frame.setVisible(true);
			}
		});
		
		p_b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				P_B frame = null;
				try {
					frame = new P_B();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//frame.setVisible(true);
			}
		});
		
		mon.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Monuments frame = null;
				try {
					frame = new Monuments();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//frame.setVisible(true);
			}
		});
		
		
	}
	
	
	

}
