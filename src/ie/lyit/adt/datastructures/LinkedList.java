package ie.lyit.adt.datastructures;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LinkedList {
	/**
	 * The first node in the list (or NULL if the list is empty)
	 */
	private Node first;

	/**
	 * Retrieves the first data element in the list (like Peek in stack)
	 * 
	 * @return The first data element
	 * @throws NoSuchElementException
	 *             If the list is empty
	 */
	public Object getFirst() throws NoSuchElementException {
		if (first == null) {
			throw new NoSuchElementException();
		}
		return first.data;
	}

	/**
	 * Adds a data element at the beginning of the list (moving existing
	 * elements back) (like Push in stack)
	 * 
	 * @param data
	 *            The data element to store
	 */
	public void addFirst(Object data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = first;

		first = newNode;
	}

	/**
	 * Removes and returns the first data element in the list (like Pop in
	 * stack)
	 * 
	 * @return The data element retrieved before removing it
	 * @throws NoSuchElementException
	 *             If the list is empty
	 */
	public Object removeFirst() throws NoSuchElementException {
		if (first == null) {
			throw new NoSuchElementException();
		}
		Object obj = first.data;

		first = first.next;
		return obj;
	}

	/**
	 * Reverses the list
	 */
	public void reverse() {
		Node newFirst = null;
		while (first != null) {
			Node currentFirst = first;
			first = first.next;
			
			currentFirst.next = newFirst;
			newFirst = currentFirst;
		}
		
		first = newFirst;
	}

	/**
	 * Creates and returns a new list iterator for this list
	 * 
	 * @return The newly generated iterator
	 */
	@SuppressWarnings("rawtypes")
	public ListIterator listIterator() {
		return new LinkedListIterator();
	}

	/**
	 * Linked list iterator
	 * 
	 * @author markus.korbel@lyit.ie
	 * 
	 */
	@SuppressWarnings("rawtypes")
	private class LinkedListIterator implements ListIterator {
		/**
		 * Our current iterator position
		 */
		private Node position;

		/**
		 * The previously visited position (for remove)
		 */
		private Node previous;

		/**
		 * Moves past the next element in the list
		 * 
		 * @return The data element just passed
		 * @throws NoSuchElementException
		 *             If the iterator is at the end of the list
		 */
		@Override
		public Object next() throws NoSuchElementException {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			previous = position; // Remember for remove
			if (position == null) {
				position = first;
			} else {
				position = position.next;
			}

			return position.data;
		}

		/**
		 * Checks if there is another element in the list (is it save to call
		 * next()?)
		 * 
		 * @return True if there is another element in the list, false if we
		 *         have reached the end
		 */
		@Override
		public boolean hasNext() {
			if (position == null) {
				return first != null;
			} else {
				return position.next != null;
			}
		}

		/**
		 * Removes the element we just passed
		 * 
		 * @throws IllegalStateException
		 *             If the last operation was not next()
		 */
		@Override
		public void remove() throws IllegalStateException {
			if (previous == position) {
				throw new IllegalStateException();
			}
			if (position == first) {
				removeFirst();
			} else {
				previous.next = position.next;
			}

			position = previous;
		}

		/**
		 * Change the data in the last node we passed
		 * 
		 * @throws NoSuchElementException
		 *             If the position of the iterator is either before the
		 *             first or after the last element
		 */
		@Override
		public void set(Object obj) throws NoSuchElementException {
			if (position == null) {
				throw new NoSuchElementException();
			}
			position.data = obj;
		}

		/**
		 * Insert a new data element after the one just passed (note the
		 * iterator immediately passes the newly inserted element) or at the
		 * beginning of the list (if the iterator hasn't moved yet or the list
		 * is empty)
		 */
		@Override
		public void add(Object obj) {
			if (position == null) {
				addFirst(obj);
				position = first;
			} else {
				Node newNode = new Node();
				newNode.data = obj;

				newNode.next = position.next;
				position.next = newNode;
				position = newNode;
			}
			previous = position;
		}

		@Override
		public boolean hasPrevious() {
			// Single linked list, this isn't supported
			return false;
		}

		@Override
		public int nextIndex() {
			// We don't count index positions (you can if you want, add it to
			// the next() method)
			return -1;
		}

		@Override
		public Object previous() {
			// Single linked list, this isn't supported
			return null;
		}

		@Override
		public int previousIndex() {
			// Single linked list, this isn't supported
			return -1;
		}
	}

	/**
	 * Linked list node
	 * 
	 * @author markus.korbel@lyit.ie
	 * 
	 */
	private class Node {
		/**
		 * The data contained in the node
		 */
		public Object data;

		/**
		 * The next node in the list (or NULL if we are the last node)
		 */
		public Node next;
	}

}
