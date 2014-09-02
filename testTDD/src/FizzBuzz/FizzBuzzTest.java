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
 * ある数値が3で割り切れる時はFizzを表示
 * ある数値が5で割り切れる時はBuzzを表示
 * ある数値が3 and 5で割り切れる時はFizzBuzzを表示 
 */
public class FizzBuzzTest {

	private FizzBuzzCheck fizzBuzz;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		fizzBuzz = new FizzBuzzCheck();
	}
	
	@Test
	public void testFizz(){
		assertTrue(fizzBuzz.isFizz(3));
		assertFalse(fizzBuzz.isFizz(4));
	}
	
	@Test
	public void testBuzz(){
		assertTrue(fizzBuzz.isBuzz(5));
		assertFalse(fizzBuzz.isBuzz(6));
	}
	
	@Test
	public void testFizzBuzz(){
		assertFalse(fizzBuzz.isFizzBuzz(9));
		assertTrue(fizzBuzz.isFizzBuzz(15));
		assertFalse(fizzBuzz.isFizzBuzz(16));
	}
	
	@Test
	public void testFizzMinusValue(){
		try {
			assertFalse(fizzBuzz.isFizz(0));
			assertFalse(fizzBuzz.isFizz(-1));
			fail();
		} catch (ArithmeticException expected) {
			// TODO: handle exception
		}
	}

	@Test
	public void testBuzzMinusValue(){
		try {
			assertFalse(fizzBuzz.isBuzz(0));
			assertFalse(fizzBuzz.isBuzz(-1));
			fail();
		} catch (ArithmeticException expected) {
			// TODO: handle exception
		}
	}
}