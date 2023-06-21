/*
	Class: CMSC 204
	CRN: 40541
	Instructor: Professor Gary C. Thai
	Project: 2
	Due Date: 6/20/23
	Programmer: Abidara Mesfin
*/

import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface<T> {
	private ArrayList<T> queue;
	private int maxSize;

	/**
	 * Constructs a new MyQueue object with the specified size.
	 * 
	 * @param size the maximum size of the queue
	 */
	public MyQueue(int size) {
		queue = new ArrayList<>();
		maxSize = size;
	}

	/**
	 * Adds an element to the end of the queue.
	 * 
	 * @param element the element to enqueue
	 * @return true if the element was successfully enqueued, false otherwise
	 * @throws QueueOverflowException if the queue is full and cannot accept more
	 *                                elements
	 */
	public boolean enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}
		return queue.add(element);
	}

	/**
	 * Removes and returns the element at the front of the queue.
	 * 
	 * @return the element removed from the queue
	 * @throws QueueUnderflowException if the queue is empty and no elements can be
	 *                                 dequeued
	 */
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}
		return queue.remove(0);
	}

	/**
	 * Checks if the queue is empty.
	 * 
	 * @return true if the queue is empty, false otherwise
	 */
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	/**
	 * Checks if the queue is full and cannot accept more elements.
	 * 
	 * @return true if the queue is full, false otherwise
	 */
	public boolean isFull() {
		return queue.size() >= maxSize;
	}

	/**
	 * Returns the current size of the queue.
	 * 
	 * @return the size of the queue
	 */
	public int size() {
		return queue.size();
	}

	/**
	 * Returns a string representation of the elements in the queue.
	 * 
	 * @return a string representation of the queue
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (T element : queue) {
			sb.append(element);
		}
		return sb.toString();
	}

	/**
	 * Returns a string representation of the elements in the queue, separated by
	 * the specified delimiter.
	 * 
	 * @param delimiter the delimiter to use between elements
	 * @return a string representation of the queue with elements separated by the
	 *         delimiter
	 */
	public String toString(String delimiter) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < queue.size(); i++) {
			sb.append(queue.get(i));
			if (i < queue.size() - 1) {
				sb.append(delimiter);
			}
		}
		return sb.toString();
	}

	/**
	 * Fills the queue with elements from the specified list.
	 * 
	 * @param list the list of elements to fill the queue with
	 * @throws QueueOverflowException if the size of the list exceeds the maximum
	 *                                size of the queue
	 */
	public void fill(ArrayList<T> list) throws QueueOverflowException {
		if (list.size() > maxSize) {
			throw new QueueOverflowException();
		}
		queue.addAll(list);
	}
}