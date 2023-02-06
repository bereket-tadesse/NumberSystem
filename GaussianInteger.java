/**
 * A class which represents a Gaussian Integer number.
 * @author Bereket
 * @version 1.0
 */

public class GaussianInteger extends ComplexNumber implements GausianInterface{


	/**
	 * Creates a Gaussian integer.
	 * @param real real part of the gaussian 
	 * @param imaginary
	 */
	public GaussianInteger(WholeNumber real, WholeNumber imaginary) {
		super(real, imaginary);
	}

	/**
	 * Creates a Gaussian integer.
	 * @param real real part of the gaussian 
	 * @param imaginary
	 */
	public GaussianInteger(WholeNumber real, FloatingPointNumber imaginary) {
		super(real, imaginary);
	}
	
	
	//from interface
	@Override
	public ComplexNumber add(GaussianInteger g) {
		return super.add(g);
	}
	

}
