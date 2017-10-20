package tictactoe;

/*
 * Jasmine Wang, 250896533
 * October 20, 2017
 * CS2210 Assignment 2
 */


/*
 *  class that implements a dictionary using a hashtable with separate chaining
 */

public class TTTDictionary implements TTTDictionaryADT{
	//hash table with separate chaining, . You will decide on the size of the table, keeping in mind that the size of the table
	//must be a prime number. A table of size between 4000-5000, should work well.
	
	//attribute declaration
	private Node[] table;
	private int arraySize;
	private int count = 0;
	
	/*
	 * constructor creates a dictionary of specified size
	 * @param size
	 */
	public TTTDictionary(int size) {
		//constructor method
		arraySize = size;
		table = new Node[size];
		//loop through to create the array, mark each spot as null
		for (int i = 0; i < size; i++) {
			table[i] = null;
		}
	}
	
	/*
	 * Method that determines a hashcode given a configuration
	 * @param element - a configuration
	 * @return hashcode - to be used to insert element into function
	 */
	
	private int hashCode(String config) {
		int hashValue = config.length();
		for (int i = hashValue-1; i >= 0; i--) {
			char hashChar = config.charAt(i);
			hashValue = (hashValue * 33 + hashChar) % arraySize;
		}
		return hashValue;
	}
	
	
	public int put (TTTRecord record) throws DuplicatedKeyException{	
		Node prev = null;
		int hashKey = hashCode(record.getConfiguration()); 
		Node temp = table[hashKey];
		
		if(table[hashKey] != null){
			while(temp != null) {
				if (!temp.getElement().getConfiguration().equals(record.getConfiguration())){
					prev = temp;
					temp = temp.getNext();
				} else { 
					throw new DuplicatedKeyException("There's 2 of the same record in this key");
				}
			}
			Node newNode = new Node(record);
			prev.setNext(newNode);
			count ++;
			return 1;
		} else {
			Node newNode = new Node(record);
			table[hashKey] = newNode;
			count ++;
		}
		return 0;		
	}
	
	public void remove (String config) throws InexistentKeyException {
		//throws InexistentKeyException;
		int code = hashCode(config); //calculate hash code for element that needs to be removed
		// there is nothing at the hash code value in the dictionary for specified configuration
		Node temp = table[code];
		Node prev = null;
		
		if (table[code] == null) {
			throw new InexistentKeyException("This value is already in the dictionary!");
		} else {
		//if there is a node at the hash code value in the dictionary for specified configuration 
			while(temp != null){
				if(temp.getElement().getConfiguration() != config){
					prev = temp;
					temp = temp.getNext();
				} else if (prev != null){
					//If a node in the middle or last matches the config
						prev.setNext(temp.getNext());					
						count--;
				} else{
						temp = temp.getNext();				
						count--;
				}			
			}
		}
	}
	
	
	public TTTRecord get(String config) {
    	int hashKey = hashCode(config); 
		Node temp = table[hashKey];
    	
    	if (table[hashKey] != null) {
			while(temp != null){
				if(!temp.getElement().getConfiguration().equals(config)){
					temp = temp.getNext();
				} else{
					return temp.getElement();
				}
			}
		}
		return null;
	}
	
	public int numElements() {
		//This method returns the number of TTTRecord objects stored in the dictionary
		return count;
	}

}
