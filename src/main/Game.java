package main;

import java.awt.Graphics;

import entities.Player;

public class Game implements Runnable{

	private GameWindow gameWindow;							//Δημιουργώ ένα αντικειμενο τυπου GameWindow και το ονομαζει gameWindow, δεν το κανει σε μια γραμμή GameWindow gameWindow = new GamePanel() γιατι πρεπει να η δήλωση να γίνει εκτος δομητη και η αρχικοποίηση εντος  
	private GamePanel gamePanel;							//Δημιουργώ ένα αντικειμενο τυπου GamePanel και το ονομαζει gamePanel
	private Thread gameThread;								//Δημιουργώ ένα Thread
	private final int FPS_SET=120;							//Δημιουργώ μια μεταβλητη και ορίζω οτι τα FPS θέλω να ειναι 120
	private final int UPS_SET=200;							//Δημιουργώ μια μεταβλητη και ορίζω οτι τα UPS (Update Per Second) θέλω να ειναι 200
	
	private Player player;
	/* ----------------------------------------Η διαφορά ανάμεσα στο UPS(update) και FPS(frames)-------------------------------------------------------*/

					/* _______UPS(game logic/back-end)_____vs________FPS(draw the gamescene,front-end)
					 			* player moves             /			* the level  
					 			* events				   /			* character(player)
					 			* etc					   /            * enemies
					 													* etc
					 */
	
	
	public Game() {											//Constructor
		initClasses();
		gamePanel = new GamePanel(this);						//Αρχικοποιώ ένα αντικειμενο gamePanel
		gameWindow = new GameWindow(gamePanel);				//Αρχικοποιώ ένα αντικειμενο gameWindow και παίρνει σαν όρισμα το GamePanel
		gamePanel.setFocusable(true);			
		gamePanel.requestFocus();							//Υποχρεωτική εντολή για να αντιλαμβάνεται το παιχνίδι τα inputs
		startGameLoop();
		
	}//Game()


	private void initClasses() {
		player=new Player(200,200);		
	}


	private void startGameLoop() {							//Φτιάχνω το GameLoop
		gameThread=new Thread(this);			
		gameThread.start();
	}//startGameLoop()
	
	private void update() {
		player.update();                             
	}//update()
	
	public void render(Graphics g) {
		player.render(g);
	}
	
	@Override	
	public void run() {										//Εδω μεσα δημιουργέιται το Runnable 
		
/*-------------------------------------- ο παρακάτω κώδικας ορίζει το FPS ωστε να μένει σε ένα σταθερό επίπεδο (120FPS) ----------------------------------------*/
		double timePerFrame = 1000000000.0/FPS_SET;			//διαιρεί με το 1000000000 για να μετατρέψει το timePerFrame απο milisecond σε δευτερόλεπτα  
		double timePerUpdate = 1000000000.0/UPS_SET;		//διαιρεί με το 1000000000 για να μετατρέψει το timePerUpdate απο milisecond σε δευτερόλεπτα  
		

		long previousTime=System.nanoTime();
		int frames=0;										//Μεταβλητή για να αποθηκεύονται πόσες αλλαγές γίνονται στην εικόνα και να μετράμε το FPS
		int updates=0;										//Μεταβλητή για να αποθηκεύονται πόσες αλλαγές γίνονται στην εικόνα και να μετράμε το UPS					
		long lastCheck=System.currentTimeMillis();			//Ορίζω την τρέχουσα στιγμή σαν ώρα που έχει γίνει ο τελευταιος έλεγχος . Η συνάρτηση currentTimeMillis() επιστρέφει την τρέχουσα ώρα σε milisecond
		double deltaU=0;
		double deltaF=0;

		
		while(true) {
			long currentTime=System.nanoTime();
			deltaU+=(currentTime-previousTime) / timePerUpdate;
			deltaF+=(currentTime-previousTime) / timePerFrame;
			previousTime=currentTime;
			
			if (deltaU>=1){
				update();
				updates++;
				deltaU--;
			}//if
			
			if(deltaF>=1) {
				gamePanel.repaint();
				frames++;	
				deltaF--;
			}//if
			

			
			if(System.currentTimeMillis()-lastCheck>=1000){	//Τσεκάρει εαν έχει περάσει 1 δευτερόλεπτο απο την στιγμή που έγινε το τελευταίο check (απο την τρέχουσα στιγμή System.currentTimeMillis() αφαιρεί την στιγμή που έγινε ο τελευταίος έλεγχος lastCheck, και βλέπει εαν ειναι μεγαλύτερο 1000nanosecond)
				lastCheck=System.currentTimeMillis();		//"Εαν εχουν περάσει πάνω απο 1000 nanosecond απο το lastCheck, Ορισε τιμή του lastCheck την τρέχουσα ώρα" (την οποία παίρνει απο το σύστημα η μέθοδος System.currentTimeMillis())
				System.out.println("FPS:"+ frames +"| UPS:"+ updates);			//"Tυπώνω πόσα τελικά ηταν τα frames που αλλαξαν το τελευταιο δευτερόλεπτο | και τα ποσα updates αλλαξαν το τελευταιο δευτερόλεπτο
				frames=0;									//Ορίζω το frames 0 για να είναι έτοιμο για την επόμενη καταμέτρηση FPS
				updates=0;
			}//if	
		}//while
/*-------------------------------------- τέλος του κώδικα που ορίζει το FPS και το UPS ωστε να μένει σε ένα σταθερό επίπεδο (120FPS/200UPS) -----------------------------*/

	}//run()

		public Player getPlayer() {
			return player;
		}
}
