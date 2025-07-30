package main;
															
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import inputs.KeyboardInputs;
import inputs.MouseInputs;
import static utils.Constants.PlayerConstants.*;
import static utils.Constants.Directions.*;


public class GamePanel extends JPanel {
	
		private MouseInputs mouseInputs;					//Δημιουργω ενα αντικειμενο τυπου MouseInputs και το ονομαζει mouseInputs
		private Game game;
	
		
		public GamePanel(Game game) {						  		//Constructor
				mouseInputs = new MouseInputs(this);		//Αρχικοποιω ενα αντικειμενο mouseInputs
				this.game=game;
				setPanelSize();
				addKeyListener(new KeyboardInputs(this));   //καλώ την μέθοδο KeyListener, της κλάσης KeyboardInputs, του πακέτου inputs που μέσα έχει τις μεθόδου χειρισμού  keyTyped,keyPressed & keyReleased
				addMouseListener(mouseInputs);				//καλώ την μέθοδο addMouseListener, της κλάσης ΜouseInputs, του πακέτου inputs που μέσα έχει τις μεθόδου χειρισμού  mouseClicked κτλ
				addMouseMotionListener(mouseInputs);		//καλώ την μέθοδο addMouseListener, της κλάσης ΜouseInputs, του πακέτου inputs που μέσα έχει τις μεθόδου χειρισμού  mouseMoved κτλ			
			}


		private void setPanelSize() {						//Φτιάχνω μια μέθοδο setPanelSize() για να ορίζω τις διαστάσεις του "παράθηρου" 
			Dimension size= new Dimension(1250,750);		//Φτιάχνω ενα νεο αντικείμενο τύπου Dimension με διαστάσεις 1280,800.
			setMinimumSize(size);							//Ελάχιστο μέγεθος
			setPreferredSize(size);							//Προτιμώμενο μέγεθος 
			setMaximumSize(size);							//Μέγιστο μέγεθος
		}
		
/*-------------------------------------- Αντικαθηστώ τις μεθόδους changeXDelta(),changeYDelta() & setRectPos() με την μέθοδο setMoving()----------------------------------------------
		public void changeXDelta(int value) {				//Μετακινω το αντικείμενο στον οριζόντιο άξονα ανάλογα το πόσα Pixel του περάσουμε σαν όρισμα
			this.xDelta += value;
			//repaint();									//Εμφανίζονται οι αλλαγές.(Ενας πιο σωστός τρόπος είναι να τα απενεργοποιήσω απο εδω και να το βάλω μια και καλή στο paintComponent(Graphics g)
		}
		
		public void changeYDelta(int value) {				//Μετακινω το αντικείμενο στον κάθετο άξονα ανάλογα το πόσα Pixel του περάσουμε σαν όρισμα
			this.yDelta += value;
			//repaint();									//Εμφανίζονται οι αλλαγές.(Ενας πιο σωστός τρόπος είναι να τα απενεργοποιήσω απο εδω και να το βάλω μια και καλή στο paintComponent(Graphics g) 
		}
		
/*------------------------------------ η μέθοδος setRectPos() είναι σε περίπτωση που θέλω να μετακινώ το αντικείμενο με το Mouse------------------------------------------------------	
		public void setRectPos(int x, int y) {				//Μετακινω τον κερσορα του Mouse απο την θέση στην οποία βρίσκεται (xDelta * yDelta), στις συντεταγμένες που του στέλνουμε σαν όρισμα (x, y) 
			this.xDelta=x;									//Βάζω την τιμή του ορίσματος x στην μεταβλητή xDelta ετσι ώστε το αντικειμενο να μετακινηθει στην θέση xDelta στον οριζόντιο άξονα
			this.yDelta=y;									//Βάζω την τιμή του ορίσματος y στην μεταβλητή yDelta ετσι ώστε το αντικειμενο να μετακινηθει στην θέση xDelta στον κάθετο άξονα
			//repaint();									//Εμφανίζονται οι αλλαγές.(Ενας πιο σωστός τρόπος είναι να τα απενεργοποιήσω απο εδω και να το βάλω μια και καλή στο paintComponent(Graphics g)
		}	
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
		public void updateGame() {

		}
		
		public void paintComponent(Graphics g) {	  		//Περνώντας το gamePanel σαν όρισμα στον δομητή του GameWindow() τοποθετέι μεσα στην οθόνη όλο το content που θα φτιάξουμε σε αυτη τη κλάση 	
			super.paintComponent(g);				
		    game.render(g);
			//subImg=img.getSubimage(250*1, 250*2, 250, 250);
/*-------------------------------------------Κοβει απο την εικόνα subImg απο τη θέση 250*1 , και 250*2 και την εμφανίζει σε μέγεθος 250*250 pixel---------------------------------------------------/ 
 -------------------------------------------με το 250*1 , και 250*2 παιρνω απο την εικόνα το snap που είναι στη θέση 2x3 (μετριέται και το 0, οπότε 1+1=2 , 2+1=3)---------------------------------*/
		}							
		
		public Game getGame() {
		    return game;	
		}
		



/*---------------------------------------Αυτη η μόθοδος ορίζει οταν το αντικείμενο φτάσει στα ορια του panel να αλλάζει κατευθυνση 
		private void updateRectangle() {					
			xDelta+=xDir;
				if(xDelta>1280 || xDelta<0) 
					xDir*=-1;
			yDelta+=yDir;
				if(yDelta>800 || yDelta<0) 
					yDir*=-1;					
		}
*/
}
