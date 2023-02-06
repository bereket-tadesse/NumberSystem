/**
 * A class which represents n arbitrary Floating point number.
 * @author Bereket
 * @version 1.0
 */

public class FloatingPointNumber {
	
	/** stores the array representing the digits */
	int[] digits;
	/** stores boolean to show - or + */
	boolean isNegative;
	/** stores the precisision. */
	int precission;

	
	/**
	 * returns true if the number is negative
	 * @return a boolean which shows if the number is negative
	 */
	public boolean getIsNegative() {
		return this.isNegative;
	}

	/**
	 * sets the number to be negative or positive
	 * @param isNegative a boolean which shows if the number is negative.
	 */
	public void setIsNegative(boolean isNegative) {
		this.isNegative = isNegative;
	}

	/**
	 * returns the precision of the number
	 * @return an integer which represents the precision.
	 */
	public int getPrecission() {
		return this.precission;
	}
	
	/**
	 * sets the array of a number.
	 * @param digits the array containing each digit in a number
	 */
	public void setDigits(int[] digits) {
		this.digits = digits;
	}

	/**
	 * sets the precision of the number
	 * @param precission integer representing the precision of a floating point number.
	 */
	public void setPrecission(int precission) {
		this.precission = precission;
	}

	/**
	 * gets the array of a floating point number.
	 * @return the array representing each digit in a floating point number
	 */
	public int[] getDigits() {
		return this.digits;
	}
	
	/**
	 * Creates a floating point number.
	 * @param digits  digits the array containing each digit in a number
	 * @param isNegative a boolean which shows if the number is negative.
	 * @param precission integer representing the precision of a floating point number.
	 */
	public FloatingPointNumber(int[] digits, boolean isNegative, int precission) {

		this.digits = digits;
		this.isNegative = isNegative;
		this.precission = precission;	
	}
	
	/** 
	 * returns the string representation of flaoting point number 
	 * @return String version of the floating point number.
	 */
	@Override
	public String toString() throws ArrayIndexOutOfBoundsException {
		
		StringBuilder string = new StringBuilder();
		//throw exception if one of the floating point number is empty.
		if (this.getDigits().length == 0) {
			throw new ArrayIndexOutOfBoundsException("Array is empty");
		} 
	
		// skips the leading zeros
		int i = digits.length-1;
		while (digits[i] == 0 && i >= 0 && this.getPrecission() != i) {
			i--;
		}
		
		
		//if precission is higher than length
		if (precission >= this.getDigits().length) {
			string.append("0.");
			int loop =  precission - this.getDigits().length;  // stores the number of loops 
			
			for (int x = 0; x < loop ; x++) {
				string.append("0");
			}
			
			int j = this.getDigits().length -1;
			while( j >= 0) {
				string.append(digits[j]);
				j--;
			}
	
		} else {
			
			for ( ; i >= 0; i-- ) {	
				if (this.precission == i) {
					
					string.append(digits[i]);
					//to avoid adding . if precssion is 0.
					if(precission == 0 && i == 0) {
						;
					} else {
						string.append(".");
					}
					
					
				} else {	
					string.append(digits[i]);
				}	
			}
		}

		if (this.isNegative == true) {
			return "-" + string.toString();
		}
		else 
			return string.toString();
		
	}
	
	/**
	 * compares two floating point numbers and returns true if equal
	 * @return true if the floating point number and this are equal floating point numbers.
	 */
	@Override
	public boolean equals(Object o) {
		
		if (o instanceof FloatingPointNumber ) {
			
			FloatingPointNumber f = (FloatingPointNumber) o;
			
			//if both numbers are {0} used for real number class and subclasses.
			
			if (this.getDigits().length == 1 && this.getDigits()[0] == 0 && 
					f.getDigits().length == 1 && f.getDigits()[0] == 0 ) {
				return true;
			}
				
			//throw exception if one of the floating point number is empty.
			if (this.getDigits().length == 0 || f.getDigits().length == 0) {
				throw new ArrayIndexOutOfBoundsException("Array is Empty");
			} 
			
			if (this.getPrecission() == f.getPrecission() && this.getIsNegative()== f.getIsNegative()) {
				int i_f = 0;
				int i_this = 0;
				
				int[] digits_f = f.getDigits();
				int[] digits_this = this.getDigits();
				
				// skips first 0s for 'f' digits
				while (digits_f[i_f] == 0 && i_f < digits_f.length) {
					i_f++;
				}
				
				// skips first 0s for 'this' digits
				while (digits_this[i_this] == 0 && i_this < digits_this.length) {
					i_this++;
				}
				
				//if one of the diigts is d/t return zero.
				while (i_f < digits_f.length && i_this < digits_this.length) {
					if (digits_this[i_this] != digits_f[i_f]) {
						return false;
					}
					else {
						i_f++;
						i_this++;
					}
				}
				
				
				// to identify which digit array has some trailing elements to be checked.
				try {
					
					while(i_this <= digits_this.length-1) {
					   if (digits_this[i_this]!=0) {
						   return false;
					   }
					   i_this++;
					}
				} catch (Exception e) {
					
					while(i_f <= digits_f.length-1) {
					   if (digits_f[i_f]!=0) {
						   return false;
					   }
					   i_f++;
					}
				}
				
				return true;
			}
			
		return false;
			
		}
		else {
			return false;
		}
	}
	
	/**
	 * Adds two floating point numbers with the same sign.
	 * @param fpn1 first floating point number to be added.
	 * @param fpn2 second floating point number to be added.
	 * @return the result of addition of the two floating point numbers.
	 * @throws ArrayIndexOutOfBoundsException if adding with empty digits.
	 * @throw UnsupportedOperationException if adding different signs.
	 */
	public static FloatingPointNumber helperAddFloats( FloatingPointNumber fpn1, FloatingPointNumber fpn2) throws ArrayIndexOutOfBoundsException{
		
		//stores the result of the addition.
		FloatingPointNumber result = new FloatingPointNumber(null, false, 0);
		
		
		//throw exception if one of the floating point number is empty.
		if (fpn1.getDigits().length == 0 || fpn2.getDigits().length == 0) {
			throw new ArrayIndexOutOfBoundsException("Array is Empty");
		} 
		
		//setting the sign of the final result.
		if (fpn1.getIsNegative() == true && fpn2.getIsNegative() == true) {
			result.setIsNegative(true);	
		} else if (fpn1.getIsNegative() ==false && fpn2.getIsNegative() == false) {
			result.setIsNegative(false);
		} else {
			// if both are different signs
			throw  new UnsupportedOperationException();
		}
		
		//setting the precission of the final result to be the highest of the two
		if(fpn1.getPrecission()> fpn2.getPrecission()) {
			result.setPrecission(fpn1.getPrecission());
		} else {
			result.setPrecission(fpn2.getPrecission());	
		}
		
		//stores the size of the final result.
		int size;
		// computing the fit size for the final result.
		if (fpn1.getPrecission() > fpn2.getPrecission()) {
			size = fpn1.getPrecission();
		} else {
			size = fpn2.getPrecission();
		}
		
		//adds to the size based on the precssion
		if ( (fpn1.getDigits().length - fpn1.getPrecission()) > (fpn2.getDigits().length - fpn2.getPrecission())) {
			size = size + (fpn1.getDigits().length - fpn1.getPrecission());
		} else {
			size = size + (fpn2.getDigits().length - fpn2.getPrecission());
		}
		
		//instantiate the array and sets the size
		int[] digitsResult = new int[size+1]; 
		boolean fpt1PrnBigger = false;  // boolean to identify which one precssion is bigger.
		int precissionOffset = 0;  // stores the d/ce in precsiion between the two fpt numbers.
		
		//identifies which fpn has higher [recssion and computes the d/ce.
		if(fpn1.getPrecission() > fpn2.getPrecission()) {
			fpt1PrnBigger = true;
			precissionOffset = fpn1.getPrecission() - fpn2.getPrecission();
		} else {
			precissionOffset = fpn2.getPrecission() - fpn1.getPrecission();
		}
		
		//if fpt1 precssion is bigger.
		if(fpt1PrnBigger) {
			
			//adding the leading free numbers to the array
			int i = 0;
			while(i<= precissionOffset -1 ) {
				digitsResult[i] = fpn1.getDigits()[i];
				i++;
			}
			
			//adding corresponding indexes and considering carry.
			int i_fpn1 = precissionOffset;       //stores the index of floating point number 1
			int i_fpn2 = 0;       //stores the index of floating point number 2
			int carry = 0; 
			
			//appending the the added coresponding elements.
			while(i_fpn1 <= fpn1.getDigits().length -1 && i_fpn2 <= fpn2.getDigits().length -1) {
				
				if (fpn1.getDigits()[i_fpn1] + fpn2.getDigits()[i_fpn2] + carry >= 10) {
					
					digitsResult[i_fpn1] = fpn1.getDigits()[i_fpn1] + fpn2.getDigits()[i_fpn2] + carry - 10;
					carry = 1;
				} else {
					digitsResult[i_fpn1] = fpn1.getDigits()[i_fpn1] + fpn2.getDigits()[i_fpn2] + carry;
					carry = 0;
				}
				i_fpn1++;
				i_fpn2++;
			}
			
			// adds the remaining elements at the end of the array of bigger size
			while(i_fpn1 <= fpn1.getDigits().length - 1) { 
				
			   digitsResult[i_fpn1] =  fpn1.getDigits()[i_fpn1] + carry;
			   i_fpn1++;
			   carry = 0;
			  
			}
			
			while(i_fpn2 <= fpn2.getDigits().length - 1 ) {
			   digitsResult[i_fpn2 + precissionOffset] =   fpn2.getDigits()[i_fpn2] + carry;
			   i_fpn2++; 
			   carry = 0;
			}
			
			//if carry is still not added and != 0
			if(carry!=0) {
				digitsResult[digitsResult.length-1] = carry;
			}
			
		} else {   //if fpn2 precission is bigger.
			
			//adding the leading free numbers to the array
			int i = 0;
			while(i<= precissionOffset -1 ) {
					digitsResult[i] = fpn2.getDigits()[i];
					i++;
					digitsResult[i] = 0;
			}
			
			//adding corresponding indexes and considering carry.
			int i_fpn1 = 0;
			int i_fpn2 = precissionOffset;
			int carry = 0;
			
			while(i_fpn1 <= fpn1.getDigits().length -1 && i_fpn2 <= fpn2.getDigits().length -1) {
				
				if (fpn1.getDigits()[i_fpn1] + fpn2.getDigits()[i_fpn2] + carry >= 10) {
					
					digitsResult[i_fpn2] = fpn1.getDigits()[i_fpn1] + fpn2.getDigits()[i_fpn2] + carry - 10;
					carry = 1;
				} else {
					digitsResult[i_fpn2] = fpn1.getDigits()[i_fpn1] + fpn2.getDigits()[i_fpn2] + carry;
					carry = 0;
				}
				i_fpn1++;
				i_fpn2++;
			}
			
			
			// both while loops adds the remaining elements at the end of the array of bigger size
			while(i_fpn1 <= fpn1.getDigits().length - 1) {
			   
			   digitsResult[i_fpn1 + precissionOffset] = fpn1.getDigits()[i_fpn1] + carry;
			   i_fpn1++;
			   carry = 0;
			}
			while(i_fpn2 <= fpn2.getDigits().length - 1 ) {
			   digitsResult[i_fpn2] = fpn2.getDigits()[i_fpn2] + carry;
			   i_fpn2++;
			   carry = 0;
			}
			
			//if carry is still not added and != 0
			if(carry!=0) {
				digitsResult[digitsResult.length-1] = carry;
			}
		}

		result.setDigits(digitsResult);
		return result;
		
	}

	
}
