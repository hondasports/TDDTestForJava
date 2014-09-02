package testTDD;

import java.util.EmptyStackException;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * @author miyamoto
 * This practice is http://objectclub.jp/technicaldoc/testing/stack_tdd.pdf
 *
 */
public class StackTest extends TestCase{

	Stack stack;
	public void setUp(){
		stack = new Stack();
	}
	
	@Test
	public void testCreate(){
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void testPushAndTop(){
		Stack stack = new Stack();
		stack.push(1);
		assertFalse(stack.isEmpty());
		assertEquals(1, stack.top());
	}
	
	@Test
	public void testPushAndSize(){
		stack.push(1);
		assertEquals(1, stack.size());
		
		stack.push(2);
		assertEquals(2, stack.size());
	}
	
	@Test
	public void testEmptyPop(){
		try {
			stack.pop();
			fail();
			
		} catch (EmptyStackException expected) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void testEmptyTop(){
		try {
			stack.top();
			fail();
			
		} catch (EmptyStackException expected) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void testPushAndPop(){
		stack.push(1);
		stack.pop();
		assertEquals(0, stack.size());
	}
	
	@Test
	public void testPushPushPopTop(){
		stack.push(1);
		stack.push(2);
		assertEquals(2,stack.size());
		stack.pop();
		assertEquals(1,stack.top());
	}
}