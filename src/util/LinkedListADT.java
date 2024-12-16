package util;

/*
* File name : LinkedListADT
* Author : Anson Ling Guang Cheng
* Student number : D22124534
* Description of class : This class is for linked list interface
*/

public interface LinkedListADT<T> {
	
	//Adds function that pushing the values to list 
	public void add(T element);
	
	//add the element to the specific position
	public void add(T element, int position);
	
	//return the next element
	public T getNextElement(LinearNode<T> nextElement);
	
	//return the first value on the list 
	public T remove();
	
	//return the remove element by specific number
	public T remove(int i);
	
	//return the remove element
	public T remove(T element);
	
	//return the first node location
	public LinearNode<T> returnFirstNode();
	
	//return the last node location
	public LinearNode<T> returnLastNode();
	
	//return the first element
	public T returnFirstElement();
	
	//return the last element
	public T returnLastElement();
	
	//return the value to check the is the list empty
	public boolean isEmpty();
	
	//return the element by specific number
	public T get(int i);
	
	//to check and compare both object and return 
	public boolean contains(T element);
	
	//get the size of the list
	public int size();
	
	//return all the value on the list
	public String toString();
}
