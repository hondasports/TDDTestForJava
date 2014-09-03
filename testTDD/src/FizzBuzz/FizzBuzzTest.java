package FizzBuzz;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * @author miyamoto
 * Contents URL : http://www.slideshare.net/t_wada/tddbc-exercise
 *
 * ���鐔�l��3�Ŋ���؂�鎞��Fizz��\��
 * ���鐔�l��5�Ŋ���؂�鎞��Buzz��\��
 * ���鐔�l��3 and 5�Ŋ���؂�鎞��FizzBuzz��\�� 
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
		assertThat(true, is( fizzBuzz.isFizz(3) ));
		assertThat(true, is( not( fizzBuzz.isFizz(4))));
	}

	@Test
	public void testBuzz(){
		assertThat(true, is( fizzBuzz.isBuzz(5)));
		
		// same as assertThat(true, is( not( fizzBuzz.isBuzz(6))));
		assertThat(false, is( fizzBuzz.isBuzz(6)));
	}
	
	@Test
	public void testFizzBuzz(){
		
		assertThat(false, is( fizzBuzz.isFizzBuzz(9)));
		assertThat(true, is( fizzBuzz.isFizzBuzz(15)));
		assertThat(false, is( fizzBuzz.isFizzBuzz(16)));
	}
	
	@Test
	public void testFizzMinusValue(){
		try {
			assertThat(true, is( fizzBuzz.isFizz(0)));
			assertThat(false, is(fizzBuzz.isFizz(-1)));
			fail();
		} catch (ArithmeticException expected) {
			// TODO: handle exception
		}
	}

	@Test
	public void testBuzzMinusValue(){
		try {
			assertThat(true, is( fizzBuzz.isBuzz(0)));
			assertThat(false, is( fizzBuzz.isBuzz(-1)));			
			fail();
		} catch (ArithmeticException expected) {
			// TODO: handle exception
		}
	}
}