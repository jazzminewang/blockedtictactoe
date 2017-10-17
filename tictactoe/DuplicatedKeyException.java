package tictactoe;

public class DuplicatedKeyException extends Exception {
/*This are just the classes implementing the classes of exceptions thrown by the put and remove
	methods of TTTDictionary.
	*/
	public DuplicatedKeyException(String message) {
		//print message as specified insert/remove methods
		super(message);
	}
}
