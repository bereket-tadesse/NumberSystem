/**
 * A class which represents an Integer number.
 * @author Bereket
 * @version 1.0
 */

public class IntegerNumber extends RationalNumber implements GausianInterface {
	
	/**
	 * Cretaes an integer number.
	 * @param number Wholenumber representing the integer number
	 */
	public IntegerNumber (WholeNumber number) {
		
		super(number ,  new WholeNumber(new int[] {1} , false));
		
	}

	@Override
	public String toString() {
		return this.getNumerator().toString();
	}
	
	//from interface abstarct method
	@Override
	public GaussianInteger add(GaussianInteger g) {
		
		//stores the numerator part of this integer.
		WholeNumber integerNum = this.getNumerator();
		//stores the result.
		GaussianInteger result = new GaussianInteger(WholeNumber.addWholeNumbers(integerNum, (WholeNumber) g.getReal()), g.getImaginary());
	
		return result;
	}
}

