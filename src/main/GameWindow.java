package main;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;


import javax.swing.JFrame;

public class GameWindow extends JFrame {
	
	private static final WindowFocusListener WindowFocusListener = null;
	private JFrame jframe;
	
	public GameWindow(GamePanel gamePanel) {									//Constructor, το όρισμα (GamePanel gamePanel) βάζει το gameWindow μεσα στο frame
			jframe = new JFrame();												//Δημιουργεί νεο frame
		  //jframe.setSize(800,800);											//Ορίζει το παραθυρο να εχει διαστασεις 800px * 800px, Απλα το κάνω με την μέθοδο setPanelSize() στην κλάση GamePanel γιατι ειναι πιο σωστό. Δεν περιλαμβάνεται το toolbar στο Height
			jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				//Δίνει την δυνατότητα να κλέινει οταν πατάμε το Χ
			jframe.add(gamePanel);												//Φτιάχνει ενα παράθυρο 
			jframe.setLocationRelativeTo(null);									//κεντράρει το παράθυρο στη μέση της οθόνης
			jframe.setResizable(false);											//Κρατάει σταθερό το μέγεθος του παράθυρου
			jframe.pack(); 
			jframe.setVisible(true);											//Κάνει το παράθυρο visible
			jframe.addWindowFocusListener(new WindowFocusListener() {

				@Override
				public void windowGainedFocus(WindowEvent e) {
				}

				@Override
				public void windowLostFocus(WindowEvent e) {
					gamePanel.getGame().windowFocusLost();
					
				}
			
			});
		}
	}
	
	
	
	
