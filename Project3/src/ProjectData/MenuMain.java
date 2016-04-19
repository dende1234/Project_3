package ProjectData;

import java.awt.*;
import java.sql.SQLException;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MenuMain extends JFrame {
	private JFrame frame;
	private JLabel statusLabel;
	
	public MenuMain(){
		//Calls the Gui.
		prepareGui();
	}

	public static void main(String[] args) {
		MenuMain menuMain = new MenuMain();
	}
	
	public void prepareGui(){
		//Sets up the main menu frame.
		JFrame frame = new JFrame("Project 3");
		try{
			frame.setContentPane(new JLabel(new ImageIcon(
					ImageIO.read(new File("C:/Users/Danny Hoogeveen/Pictures/skyline_rotterdam.jpg")))));
		}catch(IOException e){
			System.out.println("Image doesn't exist");
		}
		
		frame.pack();
		frame.setLayout(null);
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		//create buttons for main menu.
		JButton okButton = new JButton("Map");
		okButton.setSize(125, 50);
		okButton.setLocation(100, 450);
		okButton.setBackground(Color.RED);
		frame.add(okButton);
		
		JButton quitButton = new JButton("Quit");
		quitButton.setSize(125, 50);
		quitButton.setLocation(700, 450);
		quitButton.setBackground(Color.RED);
		frame.add(quitButton);
		

		statusLabel = new JLabel("", JLabel.CENTER);
		statusLabel.setSize(350, 100);	
		
		frame.setVisible(true);
		
		//actions for the buttons
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				statusLabel.setText("Quit program!");
				System.exit(0);
			}
		});
		
		okButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				NextPage frame = null;
				frame = new NextPage();
				frame.setVisible(true);
			}
			
		});
	}

}
