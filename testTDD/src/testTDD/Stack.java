/**
 * 
 */
package testTDD;

import java.util.EmptyStackException;

/**
 * @author miyamoto
 *
 */
public class Stack {

	private int[] value = new int[10];
	private int size;
	public boolean isEmpty() {
		return size == 0;
	}

	public void push(int i) {
		value[size++] = i;
	}

	public int top() {
		emptyCheck();
		return value[size-1];
	}

	public int size() {
		return size;
	}

	public void pop() {
		emptyCheck();
		size--;
	}

	private void emptyCheck() {
		if(isEmpty()) throw new EmptyStackException();
	}
}