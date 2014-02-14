package ie.lyit.adt.datastructures;

import java.util.NoSuchElementException;

/**
 * Generic stack data structure
 * 
 * @author markus.korbel
 */
public class Stack<T> {
	/**
	 * Our internal data array
	 */
	private T[] stackArray;
	
	/**
	 * Our current top of the stack pointer
	 */
	private int top = -1;

	/**
	 * Default constructor (stack maximum size 5)
	 */
	public Stack() throws Exception {
		// Just passing the default value on to our other constructor
		// Should never throw Exception, but declared just in case
		this(5);
	}

	/**
	 * Constructor
	 * 
	 * @param maxSize
	 *            The maximum size of the new stack
	 *            @throws Exception If the maximum stack size is invalid
	 */
	@SuppressWarnings("unchecked")
	public Stack(int maxSize) throws Exception {
		if(maxSize<=0){
			throw new Exception("Invalid stack size!");
		}
		
		this.stackArray = (T[]) new Object[maxSize];
	}

	/**
	 * Pushes an element onto the stack
	 * 
	 * @param value
	 *            The element to push
	 * @throws Exception
	 *             If the stack is already full
	 */
	public void push(T value) throws Exception {
		if (this.isFull()) {
			throw new Exception("Stack already full!");
		}

		this.stackArray[++this.top] = value;
	}

	/**
	 * Pops the top element of the stack
	 * 
	 * @return The top element
	 * @throws NoSuchElementException
	 *             If there is no element on the stack
	 */
	public T pop() throws NoSuchElementException {
		if (this.isEmpty()) {
			throw new NoSuchElementException("Stack is empty!");
		}

		return this.stackArray[this.top--];
	}

	/**
	 * Gives a "peek" preview of the top element without removing it
	 * 
	 * @return The top element
	 * @throws NoSuchElementException
	 *             If there is no element on the stack
	 */
	public T peek() throws NoSuchElementException {
		if (this.isEmpty()) {
			throw new NoSuchElementException("Stack is empty!");
		}

		return this.stackArray[this.top];
	}

	/**
	 * Checks if the stack is empty
	 * 
	 * @return True/False indicating whether the stack is empty
	 */
	public boolean isEmpty() {
		return this.top == -1;
	}

	/**
	 * Checks if the stack is full
	 * 
	 * @return True/False indicating whether the stack is full
	 */
	public boolean isFull() {
		return this.top == this.stackArray.length - 1;
	}

	/**
	 * Resets the stack (deletes all elements)
	 */
	public void reset() {
		this.top = -1;
	}

	/**
	 * Overridden toString method displaying current stack elements
	 */
	@Override
	public String toString() {
		String formatted = "Stack [";
		if (this.isEmpty()) {
			return formatted +"]";
		}
		
		for (int i = 0; i <= this.top; i++)
			formatted += this.stackArray[i] + ", ";
		formatted = formatted.substring(0, formatted.length() - 2);
		formatted += "]";
		return formatted;
	}
}
