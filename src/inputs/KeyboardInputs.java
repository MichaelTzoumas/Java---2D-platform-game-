package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import main.GamePanel;
import static utils.Constants.Directions.*;
import static utils.Constants.PlayerConstants.*;
import entities.Player.*;
import entities.Entity.*;


public class KeyboardInputs implements KeyListener{   					//To implement ειναι σαν το extends απλα α) χρησιμοπιείται σε interfaces b) το extends μπορώ να το χρησιμοποιήσω σε μια κλάση το implements σε παραπάνω
	    
		private GamePanel gamePanel;									//Δημιουργώ ενα αντικείμενο GamePanel για να το περάσω σαν όρισμα στον δομητή
		public KeyboardInputs(GamePanel gamePanel) {					//Constructor
		this.gamePanel=gamePanel;
		}
		
		@Override
		public void keyTyped(KeyEvent e) {	
	    	 /**
	         * Invoked when a key has been typed.
	         * See the class description for {@link KeyEvent} for a definition of
	         * a key typed event.
	         * @param e the event to be processed
	         */	
	    }
	    @Override
	    public void keyPressed(KeyEvent e) {  							//Πάτημα ενος κουμπιού 
	    	 /**
	         * Invoked when a key has been pressed.
	         * See the class description for {@link KeyEvent} for a definition of
	         * a key pressed event.
	         * @param e the event to be processed
	         */
	    	switch(e.getKeyCode()) {								//Switch. Λέει οταν πατηθεί ενα κουμπί (e), διαβασε την τιμή του με την μέθοδο getKeyCode()
    		case KeyEvent.VK_A:										//"Στην περίπτωση που ο χρήστης πατήσει το πλήκτρο Α στο πληκτρολόγιο κάνε αυτο"	
    			gamePanel.getGame().getPlayer().setLeft(true);
    			break;
    		case KeyEvent.VK_S:										//"Στην περίπτωση που ο χρήστης πατήσει το πλήκτρο S στο πληκτρολόγιο κάνε αυτο"	
    			gamePanel.getGame().getPlayer().setDown(true);
    			break;
    		case KeyEvent.VK_D:										//"Στην περίπτωση που ο χρήστης πατήσει το πλήκτρο D στο πληκτρολόγιο κάνε αυτο"		
    			gamePanel.getGame().getPlayer().setRight(true);
    			break;
    		case KeyEvent.VK_W:										//"Στην περίπτωση που ο χρήστης πατήσει το πλήκτρο W στο πληκτρολόγιο κάνε αυτο"
    			gamePanel.getGame().getPlayer().setUp(true);
    			break;
    	}
	    	
	    }
	    @Override
	    public void keyReleased(KeyEvent e) {	
	    	/**
	         * Invoked when a key has been released.
	         * See the class description for {@link KeyEvent} for a definition of
	         * a key released event.
	         * @param e the event to be processed
	         */
	    	switch(e.getKeyCode()) {								//Switch. Λέει οταν πατηθεί ενα κουμπί (e), διαβασε την τιμή του με την μέθοδο getKeyCode()
    		case KeyEvent.VK_A:										//"Στην περίπτωση που ο χρήστης πατήσει το πλήκτρο Α στο πληκτρολόγιο κάνε αυτο"	
    			gamePanel.getGame().getPlayer().setLeft(false);
    			break;
    		case KeyEvent.VK_S:										//"Στην περίπτωση που ο χρήστης πατήσει το πλήκτρο S στο πληκτρολόγιο κάνε αυτο"	
    			gamePanel.getGame().getPlayer().setDown(false);
    			break;
    		case KeyEvent.VK_D:										//"Στην περίπτωση που ο χρήστης πατήσει το πλήκτρο D στο πληκτρολόγιο κάνε αυτο"		
    			gamePanel.getGame().getPlayer().setRight(false);
    			break;
    		case KeyEvent.VK_W:										//"Στην περίπτωση που ο χρήστης πατήσει το πλήκτρο W στο πληκτρολόγιο κάνε αυτο"
    			gamePanel.getGame().getPlayer().setUp(false);
    			break;
    	}
	    }
}
