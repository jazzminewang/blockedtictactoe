package tictactoe;

public class TTTRecord {
	static String config;
	static int score;
	static int level;
	
	public TTTRecord(String config, int score, int level) {
		 /*A constructor which returns
		 a new TTTRecord with the specified configuration, score, and level. The String config will be
		 used as the key attribute for every TTTRecord object.
		 */
			 this.config = config;
			 this.score = score;
			 this.level = level;
		 
		 //DO I NEED TO RETURN SHIT
	}
	 
	 public String getConfiguration() {
		 //Returns the configuration stored in the TTTRecord.
		 return config;
	 }
	 
	 public int getScore() {
		 //Returns the score in the TTTRecord.
		 return score;
	 }
	 
	 public int getLevel() {
		 //Returns the level in the TTTRecord
		 return level;
	 }
	 
	 /*
	  * You can implement any other methods that you want to in this class, but they must be declared as
private methods (i.e. not accessible to other classes).
	  */
}
