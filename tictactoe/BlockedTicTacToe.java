package tictactoe;

public class BlockedTicTacToe {
	public BlockedTicTacToe(int board_size, int inline, int max_levels) {
		/*
		 * The first parameter specifies the size of the board, the second is the number of symbols in-line needed
to win the game, and the third is the maximum level of the game tree that will be explored by the
program. So, for example, to play the usual (3, 3)-tic-tac-toe, the first two parameters will have value
3.
		 */
		char[][] gameboard = new char[board_size][board_size]; //not sure if this is correct
		//i need to initialize this so that every entry of gameBoar stores a space ’ ’
	}
	
	public TTTDictionary createDictionary() {
		/* returns an empty TTTDictionary of the size
		that you have selected.
		*/
	}
	
	public int repeatedConfig(TTTDictionary configurations) {
		/*
		 * This method first represents
the gameBoard as a string as described above; then it checks whether the string representing
the gameBoard is in the configurations dictionary: If it is in the dictionary this
method returns its associated score, otherwise it returns the value -1.
		 */
	}
	
	public void insertConfig(TTTDictionary configurations, int score, int level) {
		/*
		 * This method first represents the content of gameBoard as a string as described above; then it
inserts this string, score and level in the configurations dictionary.
		 */
	}
	
	public void storePlay(int row, int col, char symbol) {
		/*
		 *  Stores the character symbol in gameBoard[row][col].
		 */
	}
	
	public boolean squareIsEmpty(int row, int col) {
		/*
		 * This method returns true if
gameBoard[row][col] is ’ ’; otherwise it returns false.
		 */
	}
	
	public boolean wins (char symbol) {
		/*
		 *  Returns true if there are k adjacent occurrences of
symbol in the same row, column, or diagonal of gameBoard, where k is the number of required
symbols in-line needed to win the game.
		 */
	}
	
	public boolean isDraw(){
		/*
		 *  Returns true if gameBoard has no empty positions left and no
player has won the game.
		 */
	}
	
	public int evalBoard() {
		/*
		 * Returns one of the following values:
◦ 3, if the computer has won, i.e. there are k adjacent ’o’s in the same row, column, or
diagonal of gameBoard;
◦ 0, if the human player has won.
◦ 1, if the game is a draw, i.e. there are no empty positions in gameBoard and no player
has won.
◦ 2, if the game is still undecided, i.e. there are still empty positions in gameBoard and no
player has won.
		 */
	}
}
