package FizzBuzz;

public class FizzBuzzCheck{

	public boolean isFizz(int value) {
		checkMinus(value);
		return remainValue(value, 3) == 0;
	}

	public boolean isBuzz(int value) {
		checkMinus(value);
		return remainValue(value, 5) == 0;
	}

	public boolean isFizzBuzz(int value) {
		return isFizz(value) && isBuzz(value);
	}
	
	/**
	 * @param value
	 * @return
	 */
	private int remainValue(int value, int remainedValue) {
		return value % remainedValue;
	}
	
	/**
	 * @param value
	 */
	private void checkMinus(int value) {
		if(value < 0){
			throw new ArithmeticException();
		}
	}
}