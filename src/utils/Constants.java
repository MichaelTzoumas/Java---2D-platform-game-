package utils;

public class Constants{	
	public static class Directions{
		public static final int LEFT=0;
		public static final int UP=1;
		public static final int RIGHT=2;
		public static final int DOWN=3;


	}//Directions
	
	
	
	public static class PlayerConstants{
		public static final int STANDING = 0;
		public static final int RUNNING = 1;
		public static final int ATTACK1 = 2;
		public static final int ATTACK2 = 3;
		public static final int JUMPATTACK1 = 4;
		public static final int JUMPATTACK2 = 5;
		public static final int INJURED = 6;
		public static final int DEATH = 7;
		
		public static int getSnapsAmount(int playerAction) {
			
			switch(playerAction) {
			case STANDING:
				return 5;	
			case RUNNING:
				return 3;
			case ATTACK1:
				return 3;
			//case ATTACK2:5;
			//case JUMPATTACK1:5;
			//case JUMPATTACK2:5;
			//case INJURED:5;
			//case DEATH:5;
			default:
				return 1;

			}//switch
			
		}//method getSnapsAmount
		
	}//class PlayerConstants

}//class Constants
