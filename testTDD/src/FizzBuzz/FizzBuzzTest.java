/**
 * 
 */
package FizzBuzz;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author miyamoto
 * Contents URL : http://www.slideshare.net/t_wada/tddbc-exercise
 *
 */
public class FizzBuzzTest {

	private FizzBuzz fizzBuzz;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		fizzBuzz = new FizzBuzz();
	}
	
	@Test
	public void testFizz(){
		assertTrue(fizzBuzz.isFizz());
	}
	
	@Test
	public void testBuzz(){
		assertTrue(fizzBuzz.isBuzz());
	}
	
	@Test
	public void testFizzBuzz(){
		assertTrue(fizzBuzz.isFizzBuzz());
	}
}