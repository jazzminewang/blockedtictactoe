package tictactoe;


/* CompSci 2210 - Assignment 2
 * Jasmine Wang
 * 250896533
 * Oct 19th, 2017
 * 
 * This class will help you create and manage the nodes in the
 * dictionary class.
 */

public class Node{
	
	//Declare all instance variable as private to hide the info 
	private Node next;
	private TTTRecord record;
	
	//constructor with no parameters will create a null node
	public Node (){
		next = null;
		record = null;
	}
	
	//constructor will create a node with the record in it
	public Node (TTTRecord record){
		next = null;
	    this.record = record;
	  }
	 
	//this getter method will give you the next node
	public Node getNext()
	  {
	    return next;
	  }
	
	//this setter method will set the next node as the given record
	public void setNext (Node nextRecord)
	  {
	    next = nextRecord;
	  }
	 
	//this getter method will return the record in that node
	public TTTRecord getElement()
	  {
	    return record;
	  }
	
	//this setter method will set the current node as the given record
	public void setRecord (TTTRecord newRecord)
	  {
	    record = newRecord;
	  }
}
	