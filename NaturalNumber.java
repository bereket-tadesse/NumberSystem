

/**
 * A class which represents a Natural number.
 * @author Bereket
 * @version 1.0
 */

public class NaturalNumber extends IntegerNumber {
	
	/**
	 * Creates a natural number type.
	 * @param number represents the whole number for the natural number.
	 */
	
	public NaturalNumber(WholeNumber number) {
		super(number);
		
		if (number.isNegative) {
			throw new IllegalArgumentException("Invalid input. Enter a positive number.");
		}
	}
	
}
