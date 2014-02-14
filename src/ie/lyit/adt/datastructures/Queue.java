package ie.lyit.adt.datastructures;

import java.util.NoSuchElementException;

/**
 * Queue data structure for Strings
 * 
 * @author markus.korbel
 * 
 */
public class Queue<T> {
	/**
	 * The array containing our queued values
	 */
	private T[] queueArray;

	/**
	 * The "front" of the queue (next element to be removed)
	 */
	private int front = 1;

	/**
	 * The "rear" of the queue (after which the next element will be added)
	 */
	private int rear = 0;

	/**
	 * Default constructor (queue maximum size 5)
	 */
	public Queue() throws Exception {
		// Just passing the default value on to our other constructor
		// Should never throw Exception, but declared just in case
		this(5);
	}

	/**
	 * Constructor
	 * 
	 * @param maxQueueSize
	 *            The maximum size of the queue
	 * @throws Exception
	 *             If the maximum queue size is invalid
	 */
	@SuppressWarnings("unchecked")
	public Queue(int maxQueueSize) throws Exception {
		if (maxQueueSize <= 0) {
			throw new Exception("Invalid max queue size!");
		}

		// This implementation needs to "waste" a position in the array to differentiate
		// between empty and full
		this.queueArray = (T[])new Object[maxQueueSize + 1];
	}

	/**
	 * Appends an element at the end of the queue
	 * 
	 * @param value
	 *            The value to add
	 * @throws Exception
	 *             If the queue is already full
	 */
	public void Append(T value) throws Exception {
		if (this.isFull()) {
			throw new Exception("Sorry, queue is full!");
		}

		rear = (rear + 1) % this.queueArray.length;
		this.queueArray[rear] = value;
	}

	/**
	 * Removes and returns the first element in the queue (at the front)
	 * 
	 * @return The value removed from the queue
	 * @throws NoSuchElementException
	 *             If there is no element in the queue
	 */
	public T Remove() throws Exception {
		if (this.isEmpty()) {
			throw new NoSuchElementException("No elements left in the queue!");
		}

		T value = this.queueArray[this.front];
		this.front = (this.front + 1) % 6;
		return value;
	}

	/**
	 * Returns the first element in the queue without removing it
	 * 
	 * @return The first element in the queue
	 * @throws NoSuchElementException
	 *             If there is no element in the queue
	 */
	public T Peek() {
		if (this.isEmpty()) {
			throw new NoSuchElementException("No elements left in the queue!");
		}

		return this.queueArray[this.front];
	}

	/**
	 * Returns the current length (not max length!) of the queue
	 * 
	 * @return The number of elements queued
	 */
	public int Size() {
		if (this.isEmpty()) {
			return 0;
		}

		int calcRear = this.rear;
		if ((this.rear + 1) < this.front) {
			calcRear += this.queueArray.length;
		}

		return calcRear - this.front + 1;
	}

	/**
	 * Checks if the queue is empty
	 * 
	 * @return True/False indicating whether the queue is empty
	 */
	private boolean isEmpty() {
		return front == (rear + 1) % this.queueArray.length;
	}

	/**
	 * Checks if the queue is full
	 * 
	 * @return True/False indicating whether the queue is full
	 */
	private boolean isFull() {
		return front == (rear + 2) % this.queueArray.length;
	}

	/**
	 * Overridden toString method displaying current queue elements
	 */
	@Override
	public String toString() {
		String formatted = "Queue[";
		if(this.isEmpty()) {
			return formatted + "]";
		}
		
		for (int i = this.front; i < (this.front + this.Size()); i++) {
			formatted += this.queueArray[i % this.queueArray.length] + ", ";
		}

		formatted = formatted.substring(0, formatted.length() - 2);
		return formatted + "] " + this.Size();
	}
}
