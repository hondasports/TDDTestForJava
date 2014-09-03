package testTDD;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import static org.junit.Assert.fail;

import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Test;

/**
 * @author miyamoto
 * This practice is http://objectclub.jp/technicaldoc/testing/stack_tdd.pdf
 *
 */
public class StackTest {

	Stack stack;

	@Before
	public void setUp(){
		stack = new Stack();
	}
	
	@Test
	public void testCreate(){		
		assertThat(true, is( stack.isEmpty()));
	}
	
	@Test
	public void testPushAndTop(){
		Stack stack = new Stack();
		stack.push(1);

		assertThat(false, is( stack.isEmpty()));
		assertThat(1, is( stack.top()));
	}
	
	@Test
	public void testPushAndSize(){
		stack.push(1);
		assertThat(1, is( stack.size()));
		
		stack.push(2);		
		assertThat(2, is( stack.size()));
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
		assertThat(0, is(stack.size()));
	}
	
	@Test
	public void testPushPushPopTop(){
		stack.push(1);
		stack.push(2);

		assertThat(2, is( stack.size()));
		stack.pop();

		assertThat(1, is( stack.top()));
	}
}