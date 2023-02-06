/**
 * A class which represents a rational number type.
 * @author Bereket
 * @version 1.0
 */
public class RationalNumber extends RealNumber{

	
	/** stores the numerator of the rational number. */
	private WholeNumber numerator;
	
	/** stores the denominator of the rational number. */
	private WholeNumber denominator;
	
	
	/**
	 * Creates a Rational Number number.
	 * @param numerator the numerator of the rational number.
	 * @param denomentator the denomentor of the rational number.
	 */
	public RationalNumber(WholeNumber numerator , WholeNumber denomenator) {
		//setting the super constructor to be null value. ( >> updating the real part required)
		super(new FloatingPointNumber(new int[] {}, false, 0));
		this.numerator = numerator;
		this.denominator = denomenator;
		
	}
	

	/**
	 * 
	 * @return the numerator part of the rational number.
	 */
	public WholeNumber getNumerator() {
		return this.numerator;
	}

	/**
	 * sets the numerartor part of the rational number.
	 * @param numerator the upper part of the rational number
	 */
	public void setNumerator(WholeNumber numerator) {
		this.numerator = numerator;
	}

	/**
	 * gets the denominator part of the rational number.
	 * @return the denominator part of the rational number.
	 */
	public WholeNumber getDenominator() {
		return this.denominator;
	}

	/**
	 * sets the denominator of the rational number.
	 * @param denominator the denominator part of the rational number.
	 */
	public void setDenominator(WholeNumber denominator) {
		this.denominator = denominator;
	}	
	
	@Override 
	public String toString() {
		return this.getNumerator() + "/" + this.getDenominator();
	}

	@Override
	public boolean equals(Object o) {
		
		if(o instanceof RationalNumber) {
			RationalNumber r = (RationalNumber) o;
			//compares the denominator and the numerator.
			return this.getNumerator().equals(r.getNumerator()) && 
				   this.getDenominator().equals(r.getDenominator());
		}

		return false;
		
	}
	
	/**
	 * 
	 * @param r the rational number to be added with this rational number.
	 * @return returns the result of the additon.
	 * @throws UnsupportedOperationException if we are trying to give it complex number.
	 * @throws ArrayIndexOutOfBoundsException if we are trying to add with an empty digits of another type.
	 */
	public RationalNumber add(RationalNumber r) throws UnsupportedOperationException , ArrayIndexOutOfBoundsException {
		
		// this is to check if the input is a complex number since rational number constructor is set to garbage value.
		if (r.getReal().getDigits().length != 0) {
			throw new UnsupportedOperationException();
		}
		
		//throw if one of the arrays is empty.	
		if (r.getNumerator().getDigits().length == 0 || r.getDenominator().getDigits().length == 0 ||
				  this.getNumerator().getDigits().length == 0 || this.getDenominator().getDigits().length == 0){
			
			throw new ArrayIndexOutOfBoundsException();

			//throws UnsupportedOperationException() if denominator are not equal.
		} else if (!this.getDenominator().equals(r.getDenominator()) ) {
			throw new UnsupportedOperationException();
			
		} else {
			//stores the result of the additon.
			RationalNumber result = new RationalNumber(WholeNumber.addWholeNumbers(this.getNumerator(), r.getNumerator()), this.getDenominator());
			
			return result;
		}
	}
	
	
}
