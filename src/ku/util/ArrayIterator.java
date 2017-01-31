package ku.util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ArrayIterator<T> implements Iterator<T> {

	/** attribute for the array we want to iterate over */
	private T[] array;
	/** index of an array. */
	private int index;
	/** */
	private boolean isNext;

	/**
	 * Initialize a new array iterator with the array to process.
	 * 
	 * @param array
	 *            is the array to iterate over
	 */
	public ArrayIterator(T[] array) {
		this.array = array;
		index = 0;
	}

	/**
	 * Return the next non-null element from array, if any.
	 * 
	 * @return the next non-null element in the array.
	 * @throws NoSuchElementException
	 *             if there are no more elements to return.
	 */
	public T next() {
		if (hasNext()) {
			if (array[index] == null) {
				index++;
			}
			index++;
			isNext = true;
			return array[index - 1];
		} else {
			throw new NoSuchElementException();
		}
	}

	/**
	 * Return true if next element of the array not last index, false if last.
	 * 
	 * @return true if next index of the array is not last index, false if last.
	 */
	public boolean hasNext() {
		if (index < array.length) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 */
	public void remove() {
		if (isNext) {
			array[index - 1] = null;
			isNext = false;
		} else {
			throw new IllegalStateException();
		}
	}
}
