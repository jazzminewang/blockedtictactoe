package tictactoe;

public class TTTDictionary implements TTTDictionaryADT{
	//hash table with separate chaining, . You will decide on the size of the table, keeping in mind that the size of the table
	//must be a prime number. A table of size between 4000-5000, should work well.
	
	public TTTDictionary(int size) {
		//constructor method, which must return an empty TTTDictionary of the specified size.
		
	}
	public int put (TTTRecord record) {
		//throws DuplicatedKeyException;
		
		/*
		 * Inserts the given TTTRecord record in the dictionary. This method must throw a
DuplicatedKeyException if record.getConfiguration() is already in the dictionary. You
are required to implement the dictionary using a hash table with separate chaining. To determine
how good your design is, we will count the number of collisions produced by your
hash function. Method put must return the value 1 if the insertion of record produces a
collision, and it must return the value 0 otherwise. In other words, if for example your hash
function is h(key) and the name of your hash table is T, this method will return the value 1
if T[h(record.getConfiguration())] already stores at least one element; it will return 0 if
T[h(record.getConfiguration())] was empty before the insertion.
		 */
	}
	
	public void remove (String config)  {
		//throws InexistentKeyException;
		/*
		 * Removes the record with the given key config from the dictionary. Must throw an
InexistentKeyException if the configuration is not in the dictionary
		 */
	}
	
	public TTTRecord get (String config) {
		/*
		 * A method which returns the TTTRecord stored in the dictionary for the given configuration,
or null if the configuration is not in the dictionary.
		 */
		
	}
	
	public int numElements() {
		//This method returns the number of TTTRecord objects stored in the dictionary.
	}

}
