/**
 * An interface which allows the Gaussian Integers and its sub classes to implement addition.
 * @author Bereket
 * @version 1.0
 */

public interface GausianInterface {
	/**
	 * Abstract method to add a cpmplex number and its type with gaussian integer.
	 * @param g gaussian integer to be added with this complex number
	 * @return returns complex number resulting from the addition
	 */
	abstract ComplexNumber add(GaussianInteger g);
	
}
