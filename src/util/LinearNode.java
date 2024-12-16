package util;

/*
* File name : LinearNode Class
* Author : Anson Ling Guang Cheng
* Student number : D22124534
* Description of class : This is a user define class for linked list structure that allow the data been store in and assign it into two element  
*/

public class LinearNode<T> {

	/*
	 * Instance and reference variable 
	 */
	
	//get the next element
	private LinearNode<T> next;
	
	//get the specific element
	private T element;
	
	public LinearNode() {
		this.next = null;
		this.element = null;
	}
	
	public LinearNode(T e) {
		this.next = null;
		this.element = e;
	}
	
	public LinearNode<T> getNext() {
		return this.next;
	}
	
	public T getElement() {
		return this.element;
	}
	
	public void setNext(LinearNode<T> node) {
		this.next = node;
	}
	
	public void setElement(T e) {
		this.element = e;
	}
}
