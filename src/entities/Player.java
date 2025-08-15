package entities;
													
import static utils.Constants.Directions.DOWN;
import static utils.Constants.Directions.LEFT;
import static utils.Constants.Directions.RIGHT;
import static utils.Constants.Directions.UP;
import static utils.Constants.PlayerConstants.RUNNING;
import static utils.Constants.PlayerConstants.STANDING;
import static utils.Constants.PlayerConstants.*;

import static utils.Constants.PlayerConstants.getSnapsAmount;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Player extends Entity{
	
	private BufferedImage[][] animations;				//Δημιουργώ ενα πίνακα τύπου BufferedImage με όνομα idleAni[]
	private int aniTick, aniIndex, aniSpeed =30;		//Φτιάχνω 3 μεταβλητές που θα τις χρεησιμοποιήσω στην χρήση animation
	private int playerAction=STANDING;					//Φτιάχνω playerAction ανάλογα με την "φάση" του χαρακτήρα επιστρέφει Int apo 1-7
	private boolean left, up, right, down;
	private boolean moving=false, attacking=false, attacking2=false;						//Φτιάχνω μια μεταβλητή που όταν κινήται ο χαρακτήρας ειναι true, οταν ειναι σταθερός, false
	private float playerSpeed=2.0f;
	public Player(float x, float y) {
		super(x, y);
		loadAnimations();
		// TODO Auto-generated constructor stub
	}
	
	public void update() {
		updatePosition();  
		updateAnimationTick();
	    setAnimation();
	      
	}
	
	public void render(Graphics g) {
		  g.drawImage(animations[playerAction][aniIndex],(int)x,(int)y,200,200, null);				//Εισάγω την εικόνα που θέλω στις συντεταγμενες xDelta και yDelta οι οποίες δυνονται απο το πληκτρολόγιο / Mouse μεσω των μεθόδων mouseMoved(e)& keyPressed(e) οποτε το αντικειμενο κινείται  
			//μέθοδος drawImage(int img position x, int img position y,int img width, int img height, img observer);       
			//μπορείς να ορίσεις και τις διαστάσεις της εικόνας στο 4ο κ 5ο όρισμα
//repaint();									//Εμφανίζονται οι αλλαγές.(Το βάζω εδω για να μη χρειάζεται να το βάλω σε κάθε μέθοδο χωριστά setRectPos(),changeYDelta(),changeYDelta(int value))
	}
	
	
	private void loadAnimations() {						//Φτιάχνω μια μέθοδο για να διαχειρίζομαι το animation 
		InputStream is=getClass().getResourceAsStream("/char.png");
		try {										//Χρησιμοποιώ μια try catch σε περίπτωση που υπάρχει λάθος στην εισαγωγή εικόνας
			BufferedImage img=ImageIO.read(is);
			animations=new BufferedImage[4][5];				//Φτιάχνω ένα πίνακα idleAni 5 θέσεων γιατι η char.png στη 1η τη γραμμή έχει 5 snaps 												
			for(int j=0; j < animations.length; j++)
				for(int i=0; i < animations[j].length; i++)
					animations[j][i]=img.getSubimage(250*i,250*j,250,250);		//Κοβει απο την εικόνα subImg απο τη θέση 250*i  και την εμφανίζει σε μέγεθος 250*250 pixel 
															//με το 250*1 , και 250*2 παιρνω απο την εικόνα το snap που είναι στη θέση 2x3 (μετριέται και το 0, οπότε 1+1=2 , 2+1=3)
		} catch (IOException e) {
			e.printStackTrace();
		}finally{									//Αναβαθμίζω την Try catch βάζωντας finally ........
			try {
				is.close();							//Κλέινω το streaming is για να μη καταναλώνει τσάμπα μνήμη
			}catch (IOException e) {
				e.printStackTrace();
		}
	}	
	}
	

	
	private void updateAnimationTick() {
		aniTick++;
		if(aniTick >= aniSpeed) {
			aniTick=0;
			aniIndex++;
			if(aniIndex >= getSnapsAmount(playerAction)) {
				attacking=false;
				attacking2=false;
				aniIndex=0;
			}
		}
	}
	
		private void setAnimation() {
			int startAni=playerAction;
			
			if(moving) 
				playerAction=RUNNING;
			else
				playerAction=STANDING;
				
			if(attacking) {
				playerAction=ATTACK1;
			if(startAni!=playerAction)
				resetAniTick();
			} else if(attacking2) {
				playerAction=ATTACK2;
			if(startAni!=playerAction)
				resetAniTick();}
		}
		
		private void resetAniTick() {
			aniTick=0;
			aniIndex=0;
		}

		private void updatePosition() {
			moving=false;

			if (left && !right) {
				x -=playerSpeed;
				moving=true;
					}else if(right && !left){
						x +=playerSpeed;
						moving=true;
						}
			if (up && !down) {
				y -=playerSpeed;
				moving=true;
					}else if(down && !up){
						y +=playerSpeed;
						moving=true;
						}
	
	}//updatePosition()
		
		public void resetDirBooleans() {
			left=false;
			right=false;
			up=false;
			down=false;
		}
		
		public void setAttacking(boolean attacking) {
			this.attacking=attacking;
		}
		public void setAttacking2(boolean attacking2) {
			this.attacking2=attacking2;
		}
		public boolean isLeft() {
			return left;
		}

		public void setLeft(boolean left) {
			this.left = left;
		}

		public boolean isUp() {
			return up;
		}

		public void setUp(boolean up) {
			this.up = up;
		}

		public boolean isRight() {
			return right;
		}

		public void setRight(boolean right) {
			this.right = right;
		}

		public boolean isDown() {
			return down;
		}

		public void setDown(boolean down) {
			this.down = down;
		}
		
		
}
