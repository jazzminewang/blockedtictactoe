package tictactoe;


/*
 * Jasmine Wang, 250896533
 * October 20, 2017
 * CS2210 Assignment 2
 */

public class BlockedTicTacToe {
	
	//Declare all instance variable as private to hide the info 
	private char [] [] gameBoard;
	private int board_size;
	private int inline;
	private int max_level;
	private	TTTDictionary dictionaryTable;

	//This constructor will initialize the board with its board size, line number to win and max level
	public BlockedTicTacToe(int board_size, int inline, int max_levels){
		this.board_size = board_size;
		this.inline = inline;
		this.max_level = max_levels;
		
		gameBoard = new char[board_size] [board_size];  //Since the board is a square, it will take the same board size for row and column
		
		//this for loop will go through the board and set each character as ' '.
		for (int x = 0; x < board_size; x++) {
		    for (int y = 0; y < board_size; y++) {
		        gameBoard [x] [y] = ' ';
		    }
		}
	}
	
	//this method will create a new empty dictionary 
	public TTTDictionary createDictionary(){
		dictionaryTable = new TTTDictionary (4517);		//it will create the dictionary of a prime number size between 4000 - 5000
		return dictionaryTable;
	}
	
	
	//this method will represent the board as a string and check if it exist in the dictionary
	public int repeatedConfig(TTTDictionary configurations){
		
		String tempString = "";
		
		//this for loop will go through the board and append each character to the string variable
		for (int i = 0; i < board_size; i++){
			for (int k = 0; k < board_size; k++){
		        tempString = tempString + Character.toString(gameBoard[i] [k]);	        
			}
		}	
		
		//this will return -1 if the string configuration is not in the dictionary
		if(configurations.get(tempString) == null){
			return -1;
			}	
		//it it does exist, it will return the score of that record
		else{
			return configurations.get(tempString).getScore();
		}	
	}
	
	//this method will insert the board in the dictionary
	public void insertConfig(TTTDictionary configurations, int score, int level){
		
		String tempString = "";
		//this for loop will give you the configuration in a string format of the board
		//loop through the entire board 
		for (int i= 0; i < board_size; i++){
			for (int k = 0; k < board_size; k++){
		        tempString = tempString + gameBoard[i] [k];	        
			}
		}	
		//this will create a new record with the board configuration string, score and level
		TTTRecord newRecord = new TTTRecord(tempString, score, level); 
		
		//tries to catch a duplicated key exception if that record already exists
		try {
			configurations.put(newRecord);
		} 
		catch (DuplicatedKeyException e) {
		}		
	}							
	
	//this method will store a symbol in a specific row and column location on the board
	public void storePlay(int row, int col, char symbol){
		
		gameBoard[row] [col] = symbol;
	
	}
	
	//this method tell you if the specified row and column location is empty
	public boolean squareIsEmpty (int row, int col){
		
		//check if that location has no character
		if (gameBoard[row] [col] == ' '){
			return true;		
		} else {
			return false;
		}
	}
	
	//this method will let you know if you've won the game
	public boolean wins (char symbol){
		boolean isWin = false;
		
		//in order to win, you need an inline amount of symbol vertically, horizontally or diagonally
		
		//this for loop will loop through the board
		for (int i = 0; i < board_size; i++) {
			for (int j = 0; j < board_size; j++){
				
				//it will check if any of the test is true. We only need one test to win
				if (testVertical(i, j, symbol) || testHorizontal(i, j,symbol) || testDiagonal(i, j, symbol)){
					isWin = true;
				}
			}
		}
		return isWin;
	}

	//this private method will check if you have an inline symbol horizontally consecutively
	private boolean testHorizontal(int i, int j, char symbol){
		
		int inLineCounter = inline;			//this variable will act as a counter
		int k = i;   						//a temp variable that stores the the row

		//this while loop will loop through each row with the new variable called K
		while(k < board_size){
				//this if statement will check if each position equals to symbol
				if( gameBoard[k][j] == symbol){
					
					inLineCounter --;			//this will decrease the counter when found
					
					//this will check if the counter is ever = to 0, which mean that 
					//a horizontal match of consecutive inline number it is found
					if(inLineCounter == 0){
						return true;
					}
				} else {
					//this has to be consecutive, thus if the next one is not equal then it will reset the counter
					inLineCounter = inline;
				}	
				k++;		//only increment the temp row variable to loop through each row position of that column
			}
			return false;
	}

	
	//this private method will check if you have an inline symbol horizontally consecutively
	private boolean testVertical(int i, int j, char symbol) {
		
		int inLineCounter = inline;				//this variable will act as a counter
		int k = j;								//a temp variable that stores the the column
		
		//this while loop will loop through each column with the new variable called K
		while (k < board_size) {
			
			//this if statement will check if each position equals to symbol
			if( gameBoard[i][k] == symbol){
				inLineCounter --;			//this will decrease the counter when found
				
				//this will check if the counter is ever = to 0, which mean 
				//that a vertically match of consecutive inline number it is found
				if(inLineCounter == 0){
					return true;
				}
			} else {
				//this has to be consecutive, thus if the next one is not equal then it will reset the counter
				inLineCounter = inline;
			}	
			k ++;	//only increment the temp column variable to loop through each column position of that row
		}
		return false;
	}
	
	//this private method will check if you have an inline symbol diagonally consecutively
	private boolean testDiagonal(int i, int j, char symbol) {
		
		//since there are 2 ways of checking the diagonal matches,
		//we only need one of them to match in order for the testDiagonal method to be true
		if (diagLtoR(i, j, symbol) || diagRtoL( i,  j, symbol)) {
			return true;
		}
		return false;
	}

	//this diagonal method will loop from the Top Left side of the board to the Bottom Right side of the board
	private boolean diagLtoR (int i, int j, char symbol){
		
		int inLineCounter = inline;				//this variable will act as a counter

		//This while loop will go through the board from top left to bottom right
		while(i < board_size & j < board_size){
					
			//this if statement will check if each position equals to symbol
			if (gameBoard[i] [j] == symbol) {
				inLineCounter --;		//this will decrease the counter when found				
				
				//this will check if the counter is ever = to 0, which mean 
				//that a diagonally match of consecutive inline number it is found
				if(inLineCounter == 0){
					return true;
				}	
			} else{
				//this has to be consecutive, thus if the next one is not equal then it will reset the counter		
				inLineCounter = inline;
			}	
			
			//both iterators increment by 1 since it's going from top left to bottom right
			//The row will increase and the column will increase to get the next diag position until it reaches board size
			i += 1;			
			j += 1;			
		}
		return false;	
	}
		
	//this diagonal method will loop from the Top Right side of the board to the Bottom Left side of the board
	private boolean diagRtoL(int i, int j, char symbol){
		
		int inLineCounter = inline;				//this variable will act as a counter

		//This while loop will go through the board from top left to bottom right
		//Note that the row can not be smaller then 0 or else it will go out of bound
		while(i< board_size && j < board_size && i >= 0){
			
			//this if statement will check if each position equals to symbol
			if( gameBoard[i] [j] == symbol){
				
				inLineCounter -- ;			//this will decrease the counter when found			
				
				//this will check if the counter is ever = to 0, which mean 
				//that a diagonally match of consecutive inline number it is found
				if(inLineCounter == 0){
					return true;
				}

			}
			//this has to be consecutive, thus if the next one is not equal then it will reset the counter		
			else{
				inLineCounter = inline;
			}	
			
			//Since the direction is changed now to top RIGHT to bottom LEFT
			i=i-1;			// Row will have to decrease by 1 every time
			j=j+1;			// Column will remain the same and increase by 1 every time
		}

		return false;	
	}
	

	//this method will let you know if you've tied the game
	public boolean isDraw() {
		
		boolean draw = false;
		boolean empty = true;		
		
		//if neither the computer or the play have won
		if (!wins('x') && !wins('o')) { 		
			draw = true;
		}	
		
		//this will loop through the board and check if there's an empty space
		for (int i = 0; i < board_size; i++) {
			for (int j = 0; j < board_size; j++) {
				
				//if one of the position had nothing, the board has an empty position
				if (gameBoard[i][j] == ' ') {  
					empty = false;
					break;		//break through the loop if there's 1 empty position
				}
		    }
		}
	
		//if no one won the game and if there's no empty position
		if (draw && empty){
			return true;
		}
		else{
			return false;
		}
	}
	

	//this method will return the follow value
	public int evalBoard(){
		
		//if computer wins, return 3
		if(wins('o') == true){
			return 3;
		}
		
		//if human won, return 0
		else if (wins('x') == true){
			return 0;
		}
		
		//if no one won, return 1
		else if (isDraw() == true){
			return 1;
		}
		
		//if the game is still undecided, return 2
		else{
			return 2;
		}
	}	
	
}
//public class BlockedTicTacToe {
//	char[][] gameBoard;
//	int boardSize;
//	int inline;
//	
//	public BlockedTicTacToe(int board_size, int inline, int max_levels) {
//		/*
//		 * The first parameter specifies the size of the board, the second is the number of symbols in-line needed
//to win the game, and the third is the maximum level of the game tree that will be explored by the
//program. So, for example, to play the usual (3, 3)-tic-tac-toe, the first two parameters will have value
//3.
//		 */
//		this.gameBoard = new char[board_size][board_size]; //not sure if this is correct
//		this.boardSize = board_size;
//		this.inline = inline;
//		
//		//Initializing this so that every entry of gameBoar stores a space ’ ’
//		for (int i = 0; i < board_size; i++) {
//			for (int j = 0; j < board_size; j++) {
//				gameBoard[i][j] = ' ';
//			}
//		}
//	}
//	
//	public TTTDictionary createDictionary() {
//		/* returns an empty TTTDictionary of the size
//		that you have selected.
//		*/
//		TTTDictionary dict = new TTTDictionary(this.boardSize);
//		return dict;
//	}
//	
//	public int repeatedConfig(TTTDictionary configurations) {
//		/*
//		 * This method first represents
//the gameBoard as a string as described above; then it checks whether the string representing
//the gameBoard is in the configurations dictionary: If it is in the dictionary this
//method returns its associated score, otherwise it returns the value -1.
//		 */
//		TTTRecord toCheck = configurations.get(boardToString());
//		if (toCheck != null) {
//			return toCheck.getScore();
//		} else {
//			return -1;
//		}
//	}
//	
//	public void insertConfig(TTTDictionary configurations, int score, int level) {
//		/*
//		 * This method first represents the content of gameBoard as a string as described above; then it
//inserts this string, score and level in the configurations dictionary.
//		 */
//		TTTRecord record = new TTTRecord(boardToString(), score, level);
//		try {
//			configurations.put(record);
//		} catch ( DuplicatedKeyException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public void storePlay(int row, int col, char symbol) {
//		/*
//		 *  Stores the character symbol in gameBoard[row][col].
//		 */
//		this.gameBoard[row][col] = symbol;
//	}
//	
//	public boolean squareIsEmpty(int row, int col) {
//		/*
//		 * This method returns true if
//gameBoard[row][col] is ’ ’; otherwise it returns false.
//		 */
//		if (this.gameBoard[row][col] == ' ') {
//			return true;
//		} else {
//			return false;
//		}
//	}
//	
//	public boolean wins (char symbol) {
//		/*
//		 *  Returns true if there are k adjacent occurrences of
//symbol in the same row, column, or diagonal of gameBoard, where k is the number of required
//symbols in-line needed to win the game.
//		 */
//		int k = this.inline;
//		int size = this.gameBoard.length;
//		StringBuilder result = new StringBuilder();
//		for (int i = 0; i < k; i++) {
//			result.append(symbol);
//		}
//		
//		for (int i = 0; i < size; i++) {
//			StringBuilder horizontal = new StringBuilder();
//			for (int j = 0; j < size; j++) {
//				horizontal.append(this.gameBoard[i][j]);
//			}
//			//check if horizontal contains the result
//			if (horizontal.toString().contains(result.toString())) {
//				return true;
//			}
//		}
//		
//		for (int i = 0; i < size; i++) {
//			StringBuilder vertical = new StringBuilder();
//			for (int j = 0; j < size; j++) {
//				vertical.append(this.gameBoard[j][i]);
//			}
//			if (vertical.toString().contains(result.toString())) {
//				return true;
//			}
//		}
//		
//		/*
//		 * TO DO: THIS DIAGONAL PART IS CURRENTLY WRONG....
//		 */
//		
//		for (int i = 0; i < size; i++) {
//			StringBuilder diagonal = new StringBuilder();
//			for (int j = 0; j < size; j++) {
//				//TO DO; Remove this, it's just for testing
//				int difference = i - j;
//				System.out.println(difference);
//				System.out.println(j);
//				diagonal.append(this.gameBoard[difference][j]);
//			}
//			
//			if (diagonal.toString().contains(result.toString())) {
//				return true;
//			}
//		}
//		
//		for (int i = size - 2; i >= 0; i--) {
//			StringBuilder diagonal = new StringBuilder();
//			for (int j = 0; j <= i; j++) {
//				int difference = i - j;
//				System.out.println(size - j - 1);
//				System.out.println(size - difference - 1);
//				diagonal.append(this.gameBoard[size - j - 1][size - difference - 1]);
//			}
//			if (diagonal.toString().contains(result.toString())) {
//				return true;
//			}
//		}
//		return false;
//		
//	}
//	
//	public boolean isDraw(){
//		/*
//		 *  Returns true if gameBoard has no empty positions left and no
//player has won the game.
//		 */
//		if (!boardToString().contains(" ") && !wins('x') && !wins('o')){
//			return true;
//		}
//		else {
//			return false;
//		}
//	}
//	
//	public int evalBoard() {
//		/*
//		 * Returns one of the following values:
//◦ 3, if the computer has won, i.e. there are k adjacent ’o’s in the same row, column, or
//diagonal of gameBoard;
//◦ 0, if the human player has won.
//◦ 1, if the game is a draw, i.e. there are no empty positions in gameBoard and no player
//has won.
//◦ 2, if the game is still undecided, i.e. there are still empty positions in gameBoard and no
//player has won.
//		 */
//		if (wins('o')){
//			return 3;
//		}
//		else if (wins('x')){
//			return 0;
//		}
//		else if (isDraw()){
//			return 1;
//		}
//		else {
//			return 2;
//		}
//	}
//	
//	private String boardToString() {
//		StringBuilder gameBoardString = new StringBuilder();
//		for (int i = 0; i < this.gameBoard.length; i++) {
//			for (int j = 0; j < this.gameBoard[0].length; j++) {
//				gameBoardString.append(this.gameBoard[i][j]);
//			}
//		}
//		return gameBoardString.toString();
//	}
//}
