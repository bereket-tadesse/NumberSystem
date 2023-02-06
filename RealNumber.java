
/**
 * A class which represents a Real number.
 * @author Bereket
 * @version 1.0
 */
public class RealNumber extends ComplexNumber{

	
	/**
	 * creates a Real number with only real part.
	 * @param real the real part of the real number. 
	 */
	public RealNumber(FloatingPointNumber real) {
		super(real, new FloatingPointNumber(new int[] {0}, false, 0));
	}
	
	@Override
	public String toString() {
		return this.getReal().toString();
	}
	
	
	
}
	

