
/**
 * A class which represents an arbitirary Whole number.
 * @author Bereket
 * @version 1.0
 */

public class WholeNumber extends FloatingPointNumber{
	 
	/**
	 * creates a whole number.
	 * @param digits the array containing each digits of the whole number
	 * @param isNegative boolean showing the sign of the whole number.
	 */
	public WholeNumber(int[] digits , boolean isNegative) {
		super(digits,isNegative,0);
		this.digits = digits;
		this.isNegative = isNegative;
		}
	
	/** 
	 * returns the string representation of Whole number 
	 * @return String version of the Whole number.
	 */
	@Override
	public String toString() {
		//stores the final rsult to be returned.
		StringBuilder string = new StringBuilder();
		//index
		int i = this.getDigits().length-1;
		
		//skips zeros
		while (this.getDigits()[i] == 0 && i >= 0) {
			i--;
		}
		//append
		while( i >= 0) {
			string.append(this.getDigits()[i]);
			i--; 
		}
		//if negative add '-'.
		if (this.isNegative == true) {
			return "-" + string.toString();
		}
		else 
			return string.toString();
		
	}
	
	/**
	 * compares two Whole numbers and returns true if equal
	 * @return true if the Whole number and this are equal Whole numbers.
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof WholeNumber ) {
					
			WholeNumber f = (WholeNumber) o;
			
			//if they have same sign.
			if ( this.getIsNegative()== f.getIsNegative()) {
				int i_f = f.getDigits().length - 1;
				int i_this = this.getDigits().length - 1;
				
				// skips leading 0s for 'f' digits from the end of f array
				while (f.getDigits()[i_f] == 0 && i_f >=0) {
					i_f--;
				}
				
				// skips leading 0s for 'this' digits from end of this array
				while (this.getDigits()[i_this] == 0 && i_this >= 0) {
					i_this--;
				}
				
				//if one of the elements are differnt returns false else keep decreamenting.
				while (i_f >= 0 && i_this >= 0) {
					if (this.getDigits()[i_this] != f.getDigits()[i_f]) {
						return false;
					}
					else {
						i_f--;
						i_this--;
					}
				}
				// if there is any leading element left after the above loop, the number will never be same
				if (i_this >= 0 || i_f >= 0) {
				   return false;
				}
				
				return true; //all test passed so it is equal.
			}
		
		return false;
			
		}
		else {
			return false;
		}
	}

	
	/**
	 * adds two whole numbers
	 * @param wn1 first Whole number to be added.
	 * @param wn2 second Whole number to be added.
	 * @return returns the result of the addition.
	 */
	public static WholeNumber addWholeNumbers( WholeNumber wn1, WholeNumber wn2) throws ArrayIndexOutOfBoundsException{
		
		// stores the result of the addition
		WholeNumber result = new WholeNumber(null, false);
		
		
		//throw exception if one of the floating point number is empty.
		if (wn1.getDigits().length == 0 || wn2.getDigits().length == 0) {
			throw new ArrayIndexOutOfBoundsException();
		} 
		
		//check and throws if the two inputs are of different sign.
		if (wn1.getIsNegative() == true && wn2.getIsNegative() == true) {
			result.setIsNegative(true);	
		} else if (wn1.getIsNegative() ==false && wn2.getIsNegative() == false) {
			result.setIsNegative(false);
		} else {
			// throws unsupported operation
			throw  new UnsupportedOperationException();
		}
		
		//stores the size of the digits array.
		int size;
		// computing the fit size for the final result.
		if ( wn1.getDigits().length > wn2.getDigits().length) {
			size = wn1.getDigits().length ;
		} else {
			size = wn2.getDigits().length ;
		}
		
		//instantiate the array and set the size
		int[] digitsResult = new int[size+1];
		boolean wn1Bigger = false;
	
		//identifies which fpn has higher [recssion and computes the d/ce.
		if(wn1.getDigits().length > wn2.getDigits().length) {
			wn1Bigger = true;
		} 
		
		//if fpt1 precssion is bigger.
		if(wn1Bigger) {
	
			//adding corresponding indexes and considering carry.
			int i_wn1 = 0;
			int i_wn2 = 0;
			int carry = 0;
			
			while(i_wn1 <= wn1.getDigits().length -1 && i_wn2 <= wn2.getDigits().length -1) {
				
				if (wn1.getDigits()[i_wn1] + wn2.getDigits()[i_wn2] + carry >= 10) {
					
					digitsResult[i_wn1] = wn1.getDigits()[i_wn1] + wn2.getDigits()[i_wn2] + carry - 10;
					carry = 1;
				} else {
					digitsResult[i_wn1] = wn1.getDigits()[i_wn1] + wn2.getDigits()[i_wn2] + carry;
					carry = 0;
				}
				i_wn1++;
				i_wn2++;
			}
			
			// adds the remaining elements at the end of the array of bigger size
			while(i_wn1 <= wn1.getDigits().length - 1) { 
				
			   digitsResult[i_wn1] =  wn1.getDigits()[i_wn1] + carry;
			   i_wn1++;
			   carry = 0;
			  
			}
			
			while(i_wn2 <= wn2.getDigits().length - 1 ) {
			   digitsResult[i_wn2] =   wn2.getDigits()[i_wn2] + carry;
			   i_wn2++; 
			   carry = 0;
			}
			
			//if carry is still not added and != 0
			if(carry!=0) {
				digitsResult[digitsResult.length-1] = carry;
			}
			
		
		//if fpn2 precission is bigger.
		} else {
			
			
			//adding corresponding indexes and considering carry.
			int i_wn1 = 0;
			int i_wn2 = 0;
			int carry = 0;
			
			while(i_wn1 <= wn1.getDigits().length -1 && i_wn2 <= wn2.getDigits().length -1) {
				
				if (wn1.getDigits()[i_wn1] + wn2.getDigits()[i_wn2] + carry >= 10) {
					
					digitsResult[i_wn2] = wn1.getDigits()[i_wn1] + wn2.getDigits()[i_wn2] + carry - 10;
					carry = 1;
				} else {
					digitsResult[i_wn2] = wn1.getDigits()[i_wn1] + wn2.getDigits()[i_wn2] + carry;
					carry = 0;
				}
				i_wn1++;
				i_wn2++;
			}
			
			
			// adds the remaining elements at the end of the array of bigger size
			while(i_wn1 <= wn1.getDigits().length - 1) {
			   
			   digitsResult[i_wn1 ] = wn1.getDigits()[i_wn1] + carry;
			   i_wn1++;
			   carry = 0;
			}
			while(i_wn2 <= wn2.getDigits().length - 1 ) {
			   digitsResult[i_wn2] = wn2.getDigits()[i_wn2] + carry;
			   i_wn2++;
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
