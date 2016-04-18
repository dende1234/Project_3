package ProjectData;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class CentrumPage extends JFrame{
	private static Con_sql con_sql;
	
	public CentrumPage(){
		createPage();
		
	}

	public static void main(String[] args) {
		CentrumPage centrumPage = new CentrumPage();
	}
	
	public void createPage(){
		//creates frame
		JFrame frame = new JFrame("Diagram");
		frame.pack();
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setSize(1080, 780);
		
		//sets button on the frame
		JButton back = new JButton("Back to Map");
		back.setSize(150, 50);
		back.setLocation(900, 670);
		frame.add(back);
		
		//add action to the button
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				NextPage frame = new NextPage();
				frame.setVisible(true);
			}
		});
	}

}
