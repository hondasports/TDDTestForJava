package FizzBuzz;

public class FizzBuzz {

	public static void main(String[] args) {
		FizzBuzzCheck checker = new FizzBuzzCheck();
		for (int i = 1; i < 100; i++) {
			if( checker.isFizzBuzz(i)) System.out.println("FizzBuzz");
			else if (checker.isFizz(i)) System.out.println("Fizz");
			else if (checker.isBuzz(i)) System.out.println("Buzz");
			else System.out.println(i);
		}
	}
}
