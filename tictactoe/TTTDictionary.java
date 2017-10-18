package tictactoe;
/*
 *  class that implements a dictionary using a hashtable with separate chainingm
 */
import java.util.*;

public class TTTDictionary implements TTTDictionaryADT{
	//hash table with separate chaining, . You will decide on the size of the table, keeping in mind that the size of the table
	//must be a prime number. A table of size between 4000-5000, should work well.
	
	//attribute declaration
	private Node[] table;
	private int arraySize = 6000;
	
	
	/*
	 * constructor creates a dictionary of specified size
	 * @param size
	 */
	public TTTDictionary(int size) {
		//constructor method
		this.arraySize = size;
		this.table = new Node[size];
		//loop through to create the array, mark each spot as null
		for (int i = 0; i < arraySize; i++) {
			table[i] = null;
		}
	}
	
	/*
	 * DO I NEED THIS FUNCTION? creates a dictionary of default size
	 */
	public TTTDictionary() {
		this.table = new Node[arraySize];
		//loop through to create the array, mark each spot as null
		for (int i = 0; i < arraySize; i++) {
			table[i] = null;
		}
	}
	
	/*
	 * Method that determines a hashcode given a configuration
	 * @param element - a configuration
	 * @return hashcode - to be used to insert element into function
	 */
	
	private int hashCode(String element) {
		int code = 1;
		//apply hash function to each element in configuration
		for (int i = 0; i < element.length(); i++) {
			code = element.charAt(i) % 13;
		}
		//handles codes that are negative
		if (code < 0) {
			code = code * -1;
		}
		return code;
	}
	
	
	public int put (TTTRecord record) throws DuplicatedKeyException{	
		//key is the configuration, value is the record
		Node node = new Node(record);
		String configString = record.getConfiguration();
		int code = hashCode(configString);
		
		//if no collisions occurred
		if (table[code] == null) {
			table[code] = node;
			return 0;
		}
		
		//collision occurred
		else {
			Node nodeCurr = table[code];
			// find the last node in the linked list
			while (nodeCurr.getNext() != null) {
				//check if configuration is already in dictionary
				if (nodeCurr.getElement().getConfiguration().equals(configString)) {
					throw new DuplicatedKeyException("This value is already in the dictionary!");
				}
				nodeCurr = nodeCurr.getNext();
			}
			if (nodeCurr.getElement().getConfiguration().equals(configString)) {
				throw new DuplicatedKeyException("This value is already in the dictionary!");
			}
			//insert the node behind the last node in the list
			nodeCurr.setNext(node);
			return 1;
		}
		
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
	
	public void remove (String config) throws InexistentKeyException {
		//throws InexistentKeyException;
		int code = hashCode(config); //calculate hash code for element that needs to be removed
		// there is nothing at the hash code value in the dictionary for specified configuration
		/*
		 * Removes the record with the given key config from the dictionary. Must throw an
InexistentKeyException if the configuration is not in the dictionary
		 */
		if (table[code] == null) {
			throw new InexistentKeyException("This value is already in the dictionary!");
		}
		//if there is a node at the hash code value in the dictionary for specified configuration
		else {
			Node node = table[code];
			if (node.getNext() == null) {
				table[code] = null; //remove node
			}
			
			else {
				Node nodeCurr = node.getNext();
				Node nodePrev = node;
				//check the configuration of every node in the list
				while (nodeCurr.getNext() != null) {
					if (nodeCurr.getElement().getConfiguration().equals(config)) {
						nodePrev.setNext(nodeCurr.getNext());
					}
				
				if (nodeCurr.getNext() == null) {
					throw new InexistentKeyException("The specified configuration is not in dictionary");
				}
			}
		}
		}
	}
	
	
	
	public TTTRecord get(String config) {
		/*
		 * A method which returns the TTTRecord stored in the dictionary for the given configuration,
or null if the configuration is not in the dictionary.
		 */
		int code = hashCode(config); //find hashcode for configuration that needs to be removed
		//if there is no node in the position of specified configuration's hashcode
		if (table[code] == null) {
			return null;
		} else {
			Node nodeCurr = table[code];
			//check every element in the linkedlist to find matching configuration and score
			while (nodeCurr.getNext() != null) {
				if (nodeCurr.getElement().getConfiguration().equals(config)) {
					return nodeCurr.getElement(); //UHH how do i return the node's data?? 
				}
				nodeCurr = nodeCurr.getNext();
			}
			//if there is only one node in the position
			if (nodeCurr.getElement().getConfiguration().equals(config)) {
				return nodeCurr.getElement(); //UHHHH !?!?!?!
			}
		}
		return null;
		
	}
	
	public int numElements() {
		//This method returns the number of TTTRecord objects stored in the dictionary.
	}

}
