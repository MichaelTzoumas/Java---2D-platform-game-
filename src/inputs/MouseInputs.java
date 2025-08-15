package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.GamePanel;

public class MouseInputs implements MouseListener, MouseMotionListener { 		//To implement ειναι σαν το extends απλα α) χρησιμοπιείται σε interfaces b) το extends μπορώ να το χρησιμοποιήσω σε μια κλάση το implements σε παραπάνω

	private GamePanel gamePanel;												//Δημιουργώ ενα αντικείμενο GamePanel για να το περάσω σαν όρισμα στον δομητή 
	public MouseInputs(GamePanel gamePanel) {									//Constructor
	this.gamePanel=gamePanel;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {										//Ανιχνεύει τη κίνηση του Mouse	
		//gamePanel.setRectPos(e.getX(),e.getY());								//Καλώ την μέθοδο setRectPos() της κλάσης GamePanel και σαν όρισμα δίνω τις συντεταγμένες που βρίσκεται το Mouse αυτη τη στιγμή (e.getX() * e.getY())
	
	}

	@Override
	public void mouseClicked(MouseEvent e) {									//Ανιχνεύει τo κλικ του Mouse				
		if(e.getButton()==MouseEvent.BUTTON1) {
			System.out.println("Mouse, left button clicked");
			gamePanel.getGame().getPlayer().setAttacking(true);
		}
		if(e.getButton()==MouseEvent.BUTTON3) {
			System.out.println("Mouse, right button clicked");
			gamePanel.getGame().getPlayer().setAttacking2(true);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
