package util;


/*
* File name : LinkedList Class
* Author : Anson Ling Guang Cheng
* Student number : D22124534
* Description of class : This class is for the algorithms for the linked list structure that includes add, remove, contains and toStroing, etc.
*/

public class LinkedList<T> implements LinkedListADT<T> {

	private int count;
	private LinearNode<T> front;
	private LinearNode<T> last;
	
	public LinkedList() {
		this.count = 0;
		this.front = null;
		this.last = null;
	}
	
	public void add(T element) {
		LinearNode<T> node = new LinearNode<T> (element);
		
		if (size() == 0) {
			this.last = node; //last node
			this.front = node; //first node
			this.count++; //once the value is been input, adding another sort in the list
		}//else if the size is not 0
		else {
			last.setNext(node); //add the element to the end of the list 
			last = node; //make this value as the  last value 
			this.count++;
		}
	}
	
	//add function with the object and integer
	public void add(T element, int position) {
		LinearNode<T> node = new LinearNode<T>(element);
		LinearNode<T> current = null;
		
		
		if (this.front == null) {
			front = node;
			last = node;
			count++;
		}
		
		if (position == 1) {
			node.setNext(front);
	        front = node;
	        count++;
		}
		
		if (position > count) {
			last.setNext(node);
			last = node;
			count++;
		} 
			
		current = front;
		for (int i = 1; i < position - 1; i++) {
	        current = current.getNext();
	    }
		node.setNext(current.getNext());
		current.setNext(node);
		count++;;
	}
	
	//get the next element
	public T getNextElement(LinearNode<T> nextElement) {
		return nextElement.getNext().getElement();
	}
	
	//remove the first element from the list
	public T remove() {
		
		LinearNode<T> temp = null;
		T result = null;
		
		if (isEmpty()) {
			System.out.println("The no list is empty!");
		} else {
			result = this.front.getElement();
			temp = this.front;
			this.front = this.front.getNext();
			temp.setNext(null);
			count--;
		}
		
		return result;
	}
	
	//remove function by the specific integer
	public T remove(int index) {
		T removeData = null;
		
		//if index is less then 0 and greater then or equal to the size then return null because nothing is on the list
		if (index < 0 || index >= size()) return null;
		
		//if the index is equal to 0
		if (index == 0) {
			//get the remove element
			removeData = front.getElement();
			
			//this front will get the next element
			front = front.getNext();
			
			if (this.front == null) this.last = null; // List had only one element
	            
		} else {
			LinearNode<T> current = front;
			
			//start from 1 and search through the list until it's get the right element
			for (int i = 1; i < index - 1 ; i++) current = current.getNext();
			
			//skip the code to remove
			removeData = current.getNext().getElement();
			current.setNext(current.getNext().getNext());
		
			if(current.getNext() == null) last = current;
		}
		
		count--; // minus one sort
		return removeData;
	}
	
	//remove function by the specific object
	public T remove(T element) {
		LinearNode<T> current = this.front;
		LinearNode<T> previous = null;
		
		T removeElement = null;
		
		// if the first element and last element is nothing then return null
		if (current == null) {
			return null;
		}
		
		if (current.getElement().equals(element)) {
			removeElement = current.getElement();
			this.front = current.getNext();
			if (this.front == null) { // List had only one element
	            this.last = null;
	        }
		}
			
		
		//keep trap if the current is found something
		while (current != null) {
			if(current.getElement().equals(element)) {
					removeElement = current.getElement(); // point this to the second node which it will automatic dereference
					
					// if the previous is null which mean the list is not connected 
					if(previous == null) {
						this.front = current.getNext();
					} else {
						previous.setNext(current.getNext());
					}
				}
			//move the list forward 
			previous = current;
		    current = current.getNext();
			}
		
		count--;
		return removeElement;
	}
	
	//return the first node
	public LinearNode<T> returnFirstNode() {
		return this.front;
	}
	
	//return the last node
	public LinearNode<T> returnLastNode() {
		// if the front is equal to null
		if (this.front == null ) {
			return null; // return null
		}	
		
		LinearNode<T> current = this.front;
		
		//while the current didn't get the last element then keep searching
		while (current.getNext() != null) {
			current = current.getNext();
		}
		
		//while current has found the element, point the element to last
		this.last = current;
		
		//return the element
		return current;
	}
	
	//function that return the first element
	public T returnFirstElement() {
		//return the first element
		return this.front.getElement();
	}
	
	//function that return the last element
	public T returnLastElement() {
		//return the last element by calling return last node
		return returnLastNode().getElement();
	}
	
	//function that check is the list is empty
	public boolean isEmpty() {
		
		//if the list with empty then return true
		if (this.front == null) {
			return true;
		} //else return false
		else {
			return false;
		}
	}
	
	//get function by searching through the list with specific integer
	public T get(int i) {
		LinearNode<T> index = null;
		int counter = 0;
		//for (index = this.front, counter =1; index != null && counter <= i; index = index.getNext(),counter++);
		for (index = this.front; index != null && counter < i; index = index.getNext())
		{
			counter++;
		}
		
		if (index == null) 
			return null;
		else 
			return index.getElement();
	}
	
	//function to check if the object contains the element
	public boolean contains(T element) {
		LinearNode<T> current = front;
		boolean found = false;
		
		//while the current is equal to null
		while (current != null) {
				//if the current element is equals to the argument element
				if (current.getElement().equals(element)) {
					found = true; //have found the element
				}
				current = current.getNext();
			}
		return found;
	}
	
	//method for size of the list
	public int size() {
		return this.count;
	}
	
	public String toString() {
		LinearNode<T> current = null;
		String fullList = "";
		
		for (current = this.front; current != null; current = current.getNext()) {
			fullList = fullList + current.getElement().toString();
		}
		
		return fullList;
	}
}
