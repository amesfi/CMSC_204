/*
	Class: CMSC 204
	CRN: 40541
	Instructor: Professor Gary C. Thai
	Project: 2
	Due Date: 6/20/23
	Programmer: Abidara Mesfin
*/

import java.util.ArrayList;

public class MyStack<T> implements StackInterface<T> {
	private ArrayList<T> stack;
	private int maxSize;

	/**
	 * Constructs a new MyStack object with the specified size.
	 *
	 * @param size the maximum size of the stack
	 */
	public MyStack(int size) {
		stack = new ArrayList<>();
		maxSize = size;
	}

	/**
	 * Checks if the stack is empty.
	 *
	 * @return true if the stack is empty, false otherwise
	 */
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	/**
	 * Checks if the stack is full and cannot accept more elements.
	 *
	 * @return true if the stack is full, false otherwise
	 */
	public boolean isFull() {
		return stack.size() >= maxSize;
	}

	/**
	 * Removes and returns the element at the top of the stack.
	 *
	 * @return the element removed from the top of the stack
	 * @throws StackUnderflowException if the stack is empty and no elements can be
	 *                                 popped
	 */
	public T pop() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException();
		}
		return stack.remove(stack.size() - 1);
	}

	/**
	 * Returns the element at the top of the stack without removing it.
	 *
	 * @return the element at the top of the stack
	 * @throws StackUnderflowException if the stack is empty and no elements are
	 *                                 available at the top
	 */
	public T top() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException();
		}
		return stack.get(stack.size() - 1);
	}

	/**
	 * Returns the current size of the stack.
	 *
	 * @return the size of the stack
	 */
	public int size() {
		return stack.size();
	}

	/**
	 * Pushes an element onto the top of the stack.
	 *
	 * @param element the element to push onto the stack
	 * @return true if the element was successfully pushed, false otherwise
	 * @throws StackOverflowException if the stack is full and cannot accept more
	 *                                elements
	 */
	public boolean push(T element) throws StackOverflowException {
		if (isFull()) {
			throw new StackOverflowException();
		}
		return stack.add(element);
	}

	/**
	 * Returns a string representation of the elements in the stack.
	 *
	 * @return a string representation of the stack
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < stack.size(); i++) {
			sb.append(stack.get(i));
			if (i < stack.size() - 1) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	/**
	 * Returns a string representation of the elements in the stack, separated by
	 * the specified delimiter.
	 *
	 * @param delimiter the delimiter to use between elements
	 * @return a string representation of the stack with elements separated by the
	 *         delimiter
	 */
	public String toString(String delimiter) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < stack.size(); i++) {
			sb.append(stack.get(i));
			if (i < stack.size() - 1) {
				sb.append(delimiter);
			}
		}
		return sb.toString();
	}

	/**
	 * Fills the stack with elements from the specified list.
	 *
	 * @param list the list of elements to fill the stack with
	 * @throws StackOverflowException if the size of the list exceeds the maximum
	 *                                size of the stack
	 */
	public void fill(ArrayList<T> list) throws StackOverflowException {
		if (list.size() > maxSize) {
			throw new StackOverflowException();
		}
		stack.addAll(list);
	}
}