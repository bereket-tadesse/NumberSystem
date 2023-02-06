/**
 * A class which represents a complex number.
 * @author Bereket
 * @version 1.0
 */
public class ComplexNumber {

	

	/** stores the real part of complex number */
	private FloatingPointNumber real;
	/** stores the imaginary part of the complex number	 */
	private FloatingPointNumber imaginary;
	/** stores the precsission of the real part */
	private int realPrecission;
	/** stores the precision of the imaginary part */
	private int imagPrecission;
	
	/**
	 * creates a complex number.
	 * @param real the real part of the complex number.
	 * @param imaginary the imaginary part of the complex numebr.
	 */
	public ComplexNumber(FloatingPointNumber real, FloatingPointNumber imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}
	
	/**
	 * gets the precssion of the real part.
	 * @return integer representing the precssion of the real part.
	 */
	public int getRealPRecission() {
		return realPrecission;
	}
	
	/**
	 * sets the precssion of the real part.
	 * @param realPRecission the precssion of the real part.
	 */
	public void setRealPrecission(int realPRecission) {
		this.realPrecission = realPRecission;
	}

	/**
	 * gets the precision of the imaginary part.
	 * @return the precssion of the imaginary part.
	 */
	public int getImagPrecission() {
		return imagPrecission;
	}

	/**
	 * sets the precssion of the imaginary part.
	 * @param imagPrecission the precssion of the imaginary part.
	 */
	public void setImagPrecission(int imagPrecission) {
		this.imagPrecission = imagPrecission;
	}

	/**
	 * gets the real part of the complex number.
	 * @return the real part of the complex number.
	 */
	public FloatingPointNumber getReal() {
		return real;
	}

	/**
	 * sets the real part of a complex number.
	 * @param real the real part of the complex number.
	 */
	public void setReal(FloatingPointNumber real) {
		this.real = real;
	}

	/** 
	 * gets the imaginary part.
	 * @return the imaginary part of the complex number
	 */
	public FloatingPointNumber getImaginary() {
		return imaginary;
	}
	
	/**
	 * sets the imaginary part.
	 * @param imaginary the imaginary part of the complext= number.
	 */
	public void setImaginary(FloatingPointNumber imaginary) {
		this.imaginary = imaginary;
	}
	

	/**
	 * A method which adds this complex number with the complex number parameter.
	 * @param c complex numebr operand.
	 * @return the complex number resulting from the addition.
	 */
	public ComplexNumber add(ComplexNumber c) {
		
		//stores the result of the additon
		ComplexNumber result = new ComplexNumber(FloatingPointNumber.helperAddFloats(this.getReal(), c.getReal()), FloatingPointNumber.helperAddFloats(this.getImaginary(), c.getImaginary()));
		
		return result;
		
	}
	
	/**
	 * chages the string represenation of the object to be the digit representation. 
	 * @return the string representation of the complex number. 
	 */
	public String toString() {
		
		//if negative
		if (this.getImaginary().getIsNegative()== true){
			return this.getReal() + " " + this.getImaginary() + "i";
		}
		//if positive
		return this.getReal() + " + " + this.getImaginary() + "i";
	}
	
	/**
	 * compares two complex number and returns true if equal else false.
	 * @param o the complex number to be compared with this complex number.
	 * @return true of the two complex numbers are equal
	 */
	public boolean equals(Object o) {
		
		if (o instanceof ComplexNumber) {
			ComplexNumber c = (ComplexNumber) o;
			
			//comparing real and imaginary parts.
			return (this.getReal().equals(c.getReal())) && 
					(this.getImaginary().equals(c.getImaginary()));
		}
		return false;
	}
	
	

}
