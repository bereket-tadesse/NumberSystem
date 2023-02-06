import static org.junit.Assert.*;

import org.junit.Test;

/**
 * A class which tests the six classes of project 3.
 * @author Bereket Tadesse
 * @version 1.0
 *
 */

public class Project3Tester {

	// Initializing complex numbers to test different methods of ComplexNumber class interchangabily.

	// for test 0 
	ComplexNumber c1 = new ComplexNumber (new FloatingPointNumber(new int[] {}, false, 2),new FloatingPointNumber(new int[] {}, true, 4)); //with empty list
	ComplexNumber c2 = new ComplexNumber (new FloatingPointNumber(new int[] {}, false, 3),new FloatingPointNumber(new int[] {}, true, 1)); //with empty list

	// for test 1
	// 0.08 - 0.004i
	ComplexNumber c4 = new ComplexNumber (new FloatingPointNumber(new int[] {8}, false, 2),new FloatingPointNumber(new int[] {4}, true, 3));  
	// 0.7 - 0.06i
	ComplexNumber c5 = new ComplexNumber (new FloatingPointNumber(new int[] {7}, false, 1),new FloatingPointNumber(new int[] {6}, true, 2)); 
	
	//for test many 
	// 76.57 + 23.16i
	ComplexNumber c6 = new ComplexNumber (new FloatingPointNumber(new int[] {7,5,6,7,0,0}, false, 2),new FloatingPointNumber(new int[] {6,1,3,2,0}, false, 2));
	//10025.700 + 6310.700i
	ComplexNumber c7 = new ComplexNumber (new FloatingPointNumber(new int[] {0,0,7,5,2,0,0,1,0,0}, false, 3),new FloatingPointNumber(new int[] {0,0,7,0,1,3,6,0,0}, false, 3));

	// for test first
	//10025.7 + 631.6i
	ComplexNumber c8 = new ComplexNumber (new FloatingPointNumber(new int[] {7,5,2,0,0,1,0,0}, false, 1),new FloatingPointNumber(new int[] {6,1,3,6}, false, 1));
	//10025.7 + 631.6i
	ComplexNumber c88 = new ComplexNumber (new FloatingPointNumber(new int[] {7,5,2,0,0,1,0,0}, false, 1),new FloatingPointNumber(new int[] {6,1,3,6}, false, 1));
	
	
	//for test middle 
	//100.257 + 63.16i
	ComplexNumber c9 = new ComplexNumber (new FloatingPointNumber(new int[] {7,5,2,0,0,1,0,0}, false, 3),new FloatingPointNumber(new int[] {6,1,3,6}, false, 2));
	//100.257 + 63.16i
	ComplexNumber c10 = new ComplexNumber (new FloatingPointNumber(new int[] {7,5,2,0,0,1,0,0}, false, 3),new FloatingPointNumber(new int[] {6,1,3,6}, false, 2));
	
	//for test last
	//0.100257 + 0.6316i
	ComplexNumber c11 = new ComplexNumber (new FloatingPointNumber(new int[] {7,5,2,0,0,1,0,0}, false, 6),new FloatingPointNumber(new int[] {6,1,3,6}, false, 4));
	//0.100257 + 0.6316i
	ComplexNumber c12 = new ComplexNumber (new FloatingPointNumber(new int[] {7,5,2,0,0,1,0,0}, false, 6),new FloatingPointNumber(new int[] {6,1,3,6}, false, 4));
	
	
	
	
	/** 
	 * A method which tests get real method of complex number 
	 */
	@Test
	public void testGetRealComplexNumber() {
		
		//Test 0
		try {   		
			 System.out.println(c1.getReal());
			 fail("getting real of empty list did not throw an exception.");
		} catch ( ArrayIndexOutOfBoundsException e){
			//everything is good
		} catch (Exception e) {
		      fail("getting real of empty list throw the wrong type of exception.");
	    }
		
		assertEquals("0.08", c4.getReal().toString()); //Test 1
		assertEquals("76.57", c6.getReal().toString()); //Test many
		assertEquals("10025.7", c8.getReal().toString()); // Test first
		assertEquals("100.257", c9.getReal().toString()); // Test middle
		assertEquals("0.100257", c11.getReal().toString()); // Test last
		
	}
	
	/** 
	 * A method which tests getImaginary method of complex number 
	 */
	@Test
	public void testGetImaginaryComplexNumber() {
		
		//Test 0
		try {   		
			 assertEquals("",c1.getImaginary());
			 fail("getting real part of empty list did not throw an exception.");
		} catch ( ArrayIndexOutOfBoundsException e){
			//everything is good
		} catch (Exception e) {
		      fail("getting real of empty list throw the wrong type of exception.");
	    }
		
		assertEquals("-0.004", c4.getImaginary().toString()); //Test 1
		assertEquals("23.16", c6.getImaginary().toString()); //Test many
		assertEquals("631.6", c8.getImaginary().toString()); // Test first
		assertEquals("63.16", c9.getImaginary().toString()); // Test middle
		assertEquals("0.6316", c11.getImaginary().toString()); // Test last
	}
	
	/** 
	 * A method which tests Add method of complex Number
	 */
	@Test
	public void testAddComplexNumber() {

		//Test 0
		try {   		
			 c1.add(c4);
			 fail("Adding with empty list did not throw an exception.");
		} catch ( ArrayIndexOutOfBoundsException e){
			//everything is good
		} catch (Exception e) {
		      fail("Adding to empty list throw the wrong type of exception.");
	    }
		
		
		assertEquals("0.78 -0.064i", c4.add(c5).toString()); 	  //Test 1  
		assertEquals("10102.270 + 6333.860i", c6.add(c7).toString()); //Test many
		
		assertEquals("0.78 -0.064i", c4.add(c5).toString()); //Test 1st
		assertEquals("200.514 + 126.32i", c9.add(c10).toString()); //Test middle
		
		//this also tests overflow since the imaginary part has overflow
		assertEquals("0.200514 + 1.2632i", c11.add(c12).toString()); //Test last
		
		//Test for adding two different signs in imaginary part.
		try {   		
			 c4.add(c6);
			 fail("Adding two differnt did not throw an exception.");
		} catch ( UnsupportedOperationException uoe){
			//everything is good
		} catch (Exception e) {
		      fail("Adding to empty list throw the wrong type of exception.");
	    }
	}
	
	/** 
	 * A method which tests equals method of complex number 
	 */
	@Test
	public void testEqualsComplexNumber() {
		
		//copys for testing equals method
		// copy of c4
		ComplexNumber c44 = new ComplexNumber (new FloatingPointNumber(new int[] {8}, false, 2),new FloatingPointNumber(new int[] {4}, true, 3));
		// copy of c6
		ComplexNumber c66 = new ComplexNumber (new FloatingPointNumber(new int[] {7,5,6,7,0,0}, false, 2),new FloatingPointNumber(new int[] {6,1,3,2,0}, false, 2));
		// copy of c8
		ComplexNumber c88 = new ComplexNumber (new FloatingPointNumber(new int[] {7,5,2,0,0,1,0,0}, false, 1),new FloatingPointNumber(new int[] {6,1,3,6}, false, 1));
		//copy of c9
		ComplexNumber c99 = new ComplexNumber (new FloatingPointNumber(new int[] {7,5,2,0,0,1,0,0}, false, 3),new FloatingPointNumber(new int[] {6,1,3,6}, false, 2));
		//copy of c11
		ComplexNumber c111 = new ComplexNumber (new FloatingPointNumber(new int[] {7,5,2,0,0,1,0,0}, false, 6),new FloatingPointNumber(new int[] {6,1,3,6}, false, 4));
		
		
		
		//Test 0 
		try {   		
			 assertEquals(true,c1.equals(c2));
			 fail("comparing two empty list did not throw an exception.");
		} catch ( ArrayIndexOutOfBoundsException e){
			//everything is good
		} catch (Exception e) {
		      fail("comparing two empty list throw the wrong type of exception.");
	    }
		
		
		assertEquals(true, c44.equals(c4));  // Test 1
		assertEquals(false, c4.equals(c5));  //Test 1 (false)
		assertEquals(true, c66.equals(c6));  // Test many
		
		assertEquals(true, c8.equals(c88));  // Test first
		assertEquals(true, c9.equals(c99));  //Test middle 
		assertEquals(true, c11.equals(c111));  // Test last 
		assertEquals(false, c99.equals(c88));  // test for false
		
		//Test for Special cases
		// 2.3 + 0.1i & 2.300 + 0.1i
//		ComplexNumber c13 = new ComplexNumber (new FloatingPointNumber(new int[] {3,2}, false, 1),new FloatingPointNumber(new int[] {1}, false, 1));
//		ComplexNumber c14 = new ComplexNumber (new FloatingPointNumber(new int[] {0,0,3,2}, false, 3),new FloatingPointNumber(new int[] {1}, false, 1));
//		
//		assertEquals(true, c13.equals(c14));  // Test 1
	}
	
	/** 
	 * A method which tests toString method of complex number.
	 */
	@Test
	public void testtoStringComplexNumber() {
		//Test 0 
		try {   		
			 assertEquals("",c1.toString());
			 fail("empty list did not throw an exception.");
		} catch ( ArrayIndexOutOfBoundsException e){
			//everything is good
		} catch (Exception e) {
		      fail("empty list throw the wrong type of exception.");
	    }
		
		
		assertEquals("0.08 -0.004i", c4.toString()); // Test 1
		assertEquals("10025.700 + 6310.700i", c7.toString()); // Test many 
		

		assertEquals("10025.7 + 631.6i", c8.toString()); //Test first
		assertEquals("100.257 + 63.16i", c9.toString()); //Test middle
		assertEquals("0.100257 + 0.6316i", c11.toString()); //Test last
		
		
	}
	
	
	
	

	// Initializing real numbers to test different methods of real number class interchangabily.
	

	// for Test 0
	RealNumber r0 = new RealNumber(new FloatingPointNumber(new int[] {}, false, 1));
	RealNumber r1 = new RealNumber(new FloatingPointNumber(new int[] {}, false, 1));
	
	// for Test 1
	//-0.003
	RealNumber r2 = new RealNumber(new FloatingPointNumber(new int[] {3}, true, 3));
	//-0.0006
	RealNumber r3 = new RealNumber(new FloatingPointNumber(new int[] {6}, true, 4));
	
	// for Test many
	//-5.430
	RealNumber r4 = new RealNumber(new FloatingPointNumber(new int[] {0,3,4,5,0}, true, 3));
	//-250008.4300
	RealNumber r5 = new RealNumber(new FloatingPointNumber(new int[] {0,0,3,4,8,0,0,0,5,2,0}, true, 4));
	
	// for Test first
	//-312.0
	RealNumber r6 = new RealNumber(new FloatingPointNumber(new int[] {0,2,1,3,0}, true, 1));
	//-543.0
	RealNumber r7 = new RealNumber(new FloatingPointNumber(new int[] {0,3,4,5,0}, true, 1));
	
	// for Test middle
	//-3.120
	RealNumber r8 = new RealNumber(new FloatingPointNumber(new int[] {0,2,1,3,0}, true, 3));
	//-5.430
	RealNumber r9 = new RealNumber(new FloatingPointNumber(new int[] {0,3,4,5,0}, true, 3));
	
	// for Test last
	//-0.3120
	RealNumber r10 = new RealNumber(new FloatingPointNumber(new int[] {0,2,1,3,0}, true, 4));
	//-0.5430
	RealNumber r11 = new RealNumber(new FloatingPointNumber(new int[] {0,3,4,5,0}, true, 4));
	
	//0.5430
	RealNumber r12 = new RealNumber(new FloatingPointNumber(new int[] {0,3,4,5,0}, false, 4));
	
	
	
	
	/**
	 * Tests the Add method of real number class
	 */
	@Test
	public void testAddRealNumber() {

		
		//Test 0 
		try {   		
			 assertEquals("",r0.add(r1));
			 fail("empty list did not throw an exception.");
		} catch ( ArrayIndexOutOfBoundsException e){
			//everything is good
		} catch (Exception e) {
		      fail("empty list throw the wrong type of exception.");
	    }
		
		
		// real part is showing 0i the reason is not because i didnot implemented tostring but because i am using tostring on the tester and add method is inherite so it return complex, normally it doesnot show imaginary part if i print out r2.add(r3) only.
		assertEquals("-0.0036 + 0i", r2.add(r3).toString()); //Test 1
		assertEquals("-250013.8600 + 0i", r4.add(r5).toString()); //Test many
		
		assertEquals("-855.0 + 0i", r6.add(r7).toString()); //Test first
		assertEquals("-8.550 + 0i", r8.add(r9).toString()); //Test middle
		assertEquals("-0.8550 + 0i", r10.add(r11).toString()); //Test last
		
		//Test for adding two different signs in real part.
		try {   		
			 r11.add(r12);
			 fail("Adding two differnt did not throw an exception.");
		} catch ( UnsupportedOperationException uoe){
			//everything is good
		} catch (Exception e) {
		      fail("Adding to empty list throw the wrong type of exception.");
	    }
	}
	
	/**
	 * tests the equlas method of real number class
	 */
	@Test
	public void testEqualsRealNumber() {
		// copy
		RealNumber r22 = new RealNumber(new FloatingPointNumber(new int[] {3}, true, 3));
		RealNumber r44 = new RealNumber(new FloatingPointNumber(new int[] {0,3,4,5,0}, true, 3));
		
		
		//Test 0 
		try {   		
			 assertEquals("",r0.equals(r1));
			 fail("empty list did not throw an exception.");
		} catch ( ArrayIndexOutOfBoundsException e){
			//everything is good
		} catch (Exception e) {
		      fail("empty list throw the wrong type of exception.");
	    }
		
		
		assertEquals(true, r2.equals(r22));   //Test 1
		assertEquals(true, r4.equals(r44)); //Test many
		
		
		
		
		
	}
	
	/**
	 * tests the toString method of the real Number class
	 */
	@Test
	public void testToStringRealNumber() {
		
		//Test 0 
		try {   		
			 assertEquals("",r0.toString());
			 fail("empty list did not throw an exception.");
		} catch ( ArrayIndexOutOfBoundsException e){
			//everything is good
		} catch (Exception e) {
		      fail("empty list throw the wrong type of exception.");
	    }
		
		
		//Test 1
		assertEquals("-0.003", r2.toString());
		//Test many
		assertEquals("-250008.4300", r5.toString());
		
		//Test first
		assertEquals("-312.0", r6.toString());
		//Test middle
		assertEquals("-5.430", r9.toString());
		//Test Last
		assertEquals("-0.5430", r11.toString());
		
	}
	
	
	
	// Initializing Gaussian numbers to test different methods of Gaussian Integer number class interchangabily.
	
	//for test 0
	GaussianInteger g1 = new GaussianInteger(new WholeNumber(new int[] {}, false), new WholeNumber(new int[] {}, false));
	
	//for test 1
	//g2: 3 + 4i
	GaussianInteger g2 = new GaussianInteger(new WholeNumber(new int[] {3}, false), new WholeNumber(new int[] {4}, false));
	//g3: 8 + 3i
	GaussianInteger g3 = new GaussianInteger(new WholeNumber(new int[] {8}, false), new WholeNumber(new int[] {3}, false));
	
	//for test many
	//g4: -76540 -942i
	GaussianInteger g4 = new GaussianInteger(new WholeNumber(new int[] {0,4,5,6,7}, true), new WholeNumber(new int[] {2,4,9}, true));
	//g5: -4765400 -46942i
	GaussianInteger g5 = new GaussianInteger(new WholeNumber(new int[] {0,0,4,5,6,7,4,0,0}, true), new WholeNumber(new int[] {2,4,9,6,4}, true));
	
	
	

	
	/**
	 * Tests the Add method of gaussian intger class as well as the toString method since comparison of the Strings is used.
	 */
	@Test
	public void testAddGaussianInteger() {
		//Test 0 
		try {   		
			 assertEquals("",g1.add(g2));
			 fail("empty list did not throw an exception.");
		} catch ( ArrayIndexOutOfBoundsException e){
			//everything is good
		} catch (Exception e) {
		      fail("empty list throw the wrong type of exception.");
	    }
		
		
		assertEquals("11 + 7i", g2.add(g3).toString()); //Test 1
		assertEquals("-4841940 -47884i", g4.add(g5).toString()); //Test many
		
	}
	
	/**
	 * tests the equals method of Gaussian INteger number class
	 */
	@Test
	public void testEqualsGaussianInteger() {
		
		// copys
		GaussianInteger g22 = new GaussianInteger(new WholeNumber(new int[] {3}, false), new WholeNumber(new int[] {4}, false));
		GaussianInteger g44 = new GaussianInteger(new WholeNumber(new int[] {0,4,5,6,7}, true), new WholeNumber(new int[] {2,4,9}, true));
		
		//Test 0 
		try {   		
			 assertEquals("",g1.equals(g2));
			 fail("empty list did not throw an exception.");
		} catch ( ArrayIndexOutOfBoundsException e){
			//everything is good
		} catch (Exception e) {
		      fail("empty list throw the wrong type of exception.");
	    }
		
		
		assertEquals(true, g2.equals(g22));  //Test 1
		assertEquals(true, g4.equals(g44) ); //Test many
		
		
	}
	
	/**
	 * tests the toString method of the Gaussian Number class
	 */
	//already tested by the add method and assertEquals
	@Test
	public void testtoStringGaussianIneteger() {}
	
	
	// Initializing rational numbers to test different methods of Rational number class interchangabily.
	
	// for Test 0
	RationalNumber rt1 = new RationalNumber(new WholeNumber(new int[] {}, false), new WholeNumber(new int[] {}, false));
	
	// for Test 1
	RationalNumber rt2 = new RationalNumber(new WholeNumber(new int[] {8}, false), new WholeNumber(new int[] {2}, false));
	RationalNumber rt3 = new RationalNumber(new WholeNumber(new int[] {7}, false), new WholeNumber(new int[] {2}, false));
	
	// for Test many 
	RationalNumber rt4 = new RationalNumber(new WholeNumber(new int[] {0,2,8,3,4,0,0}, false), new WholeNumber(new int[] {2,3,4}, false));
	RationalNumber rt5 = new RationalNumber(new WholeNumber(new int[] {1,2,4}, false), new WholeNumber(new int[] {2,3,4}, false));
	
	


	/**
	 * Tests the Add method of rational number class
	 */
	@Test
	public void testAddRationalNumber() {
		
		//Test 0
		try {
			assertEquals("",rt1.add(rt2));
			fail("empty list did not throw an exception.");
		} catch (ArrayIndexOutOfBoundsException uoe) {
			//Everything is good
		} catch (Exception e) {
		      fail("empty list threw wrong type of exception.");
	    }
		
		assertEquals("15/2", rt2.add(rt3).toString()); //Test 1
		assertEquals("44241/432", rt4.add(rt5).toString()); // //test many (also test zeros in first middle, and last)
		
		//Test for adding with complex throwing exception
		try {
			rt5.add(c7);
			fail("adding with complex did not throw an exception.");
		
		} catch (Exception e) {
		    //Everything is good
	    }
		
		//Test for different denoimator throwing error
		try {
			assertEquals("",rt2.add(rt4));
			fail("adding two numbers with different denominator did not throw an exception.");
		} catch (UnsupportedOperationException uoe) {
			//Everything is good
		} catch (Exception e) {
		      fail("adding two numbers with different denominator threw wrong type of exception.");
	    }
		
		
	}
	/**
	 * tests the equlas method of rational number class
	 */
	@Test
	public void testEqualsRationalNumber() {
		// copys
		RationalNumber rt22 = new RationalNumber(new WholeNumber(new int[] {8}, false), new WholeNumber(new int[] {2}, false));
		RationalNumber rt55 = new RationalNumber(new WholeNumber(new int[] {1,2,4}, false), new WholeNumber(new int[] {2,3,4}, false));
		
		
		//test 0
		try {
			assertEquals("",rt1.equals(rt2));
			fail("empty list did not throw an exception.");
		} catch (ArrayIndexOutOfBoundsException uoe) {
			//Everything is good
		} catch (Exception e) {
		      fail("empty list threw wrong type of exception.");
	    }
		
		//test 1
		assertEquals(true, rt2.equals(rt22));
		//test many
		assertEquals(true, rt55.equals(rt55));
		//Test false
		assertEquals(false, rt3.equals(rt55));
		
	}
	/**
	 * tests the toString method of the Rational Number class
	 */
	//already tested with the add test method with through the implementation.
	@Test
	public void testtoStringRationalNumber() {
		
	}
	
	
	
	
	
	
	
	
	// Initializing integer numbers to test different methods of Integer number class interchangabily.
	
	//For test 0
	IntegerNumber int1 = new IntegerNumber(new WholeNumber(new int[] {}, true));
	
	//For test 1
	IntegerNumber int2 = new IntegerNumber(new WholeNumber(new int[] {3}, true));
	IntegerNumber int3 = new IntegerNumber(new WholeNumber(new int[] {6}, true));
	
	//For test many 
	IntegerNumber int4 = new IntegerNumber(new WholeNumber(new int[] {0,4,5,6,0,0}, false));
	IntegerNumber int5 = new IntegerNumber(new WholeNumber(new int[] {6,7,4,0,0}, false));
	
	
	
	
	/**
	 * Tests the Add method of Integer number class
	 */
	@Test
	public void testAddIntegerNumber() {
		//test 0
		try {
			int1.add(int3);
			fail("empty list did not throw an exception.");
		} catch (ArrayIndexOutOfBoundsException uoe) {
			//Everything is good
		} catch (Exception e) {
		      fail("empty list threw wrong type of exception.");
	    }
		
		//it has /1 because it is using the add method of parent class which gives the result of parent type. the tostring method works for individual instances.
		assertEquals("-9/1", int2.add(int3).toString());  //Test 1
		assertEquals("7016/1", int4.add(int5).toString());  //Test many
		
		// test to add positive and negative
		try {
			int4.add(int3);
			fail("opposite sign addition not throw an exception.");
		} catch (UnsupportedOperationException uoe) {
			//Everything is good
		} catch (Exception e) {
		      fail("threw wrong type of exception.");
	    }
	
	}
	
	/**
	 * tests the equlas method of Integer number class
	 */
	@Test
	public void testEqualsIntegerNumber() {
		// copys
		IntegerNumber int22 = new IntegerNumber(new WholeNumber(new int[] {3}, true));
		IntegerNumber int55 = new IntegerNumber(new WholeNumber(new int[] {6,7,4,0,0}, false));
		
		//test 0
		try {
			int1.equals(int3);
			fail("empty list did not throw an exception.");
		} catch (ArrayIndexOutOfBoundsException uoe) {
			//Everything is good
		} catch (Exception e) {
		      fail("empty list threw wrong type of exception.");
	    }
		
		
		assertEquals(true, int2.equals(int22)); //Test 1
		assertEquals(true, int5.equals(int55)); //Test many
		
		
	}
	
	/**
	 * tests the toString method of the Integer Number class
	 */
	@Test
	public void testToStringIntegerNumber() {
		
		//test 0
		try {
			int1.toString();
			fail("empty list did not throw an exception.");
		} catch (ArrayIndexOutOfBoundsException uoe) {
			//Everything is good
		} catch (Exception e) {
		      fail("empty list threw wrong type of exception.");
	    }
		
		
		assertEquals("-3", int2.toString()); //test 1
		assertEquals("6540", int4.toString()); //test many (also test zeros in first middle, and last)
		
		
	}
	
	
	
	
	
	// Initializing natural numbers to test different methods of Rational number class interchangabily.
	// for Test 0
	NaturalNumber n1 = new NaturalNumber(new WholeNumber(new int[] {}, false));
	// for Test 1
	NaturalNumber n2 = new NaturalNumber(new WholeNumber(new int[] {9}, false));
	NaturalNumber n3 = new NaturalNumber(new WholeNumber(new int[] {7}, false));
	
	// for Test many
	NaturalNumber n4 = new NaturalNumber(new WholeNumber(new int[] {0,0,9,3,4,5,6,0,0}, false));
	NaturalNumber n5 = new NaturalNumber(new WholeNumber(new int[] {0,0,4,3,0,0,2,0,0}, false));
	
	//for test first middle last zeros
	
	
	// for Test many
	// for Test first
	// for Test middle
	// for Test last
	
	/**
	 * Tests the Add method of Natural number class
	 */
	@Test
	public void testAddNaturalNumber() {
		//test 0
		try {
			n1.add(n2);
			fail("empty list did not throw an exception.");
		} catch (ArrayIndexOutOfBoundsException uoe) {
			//Everything is good
		} catch (Exception e) {
		      fail("empty list threw wrong type of exception.");
	    }
		
		
		assertEquals("16/1", n2.add(n3).toString()); //test 1
		assertEquals("8547300/1", n4.add(n5).toString()); //test many (also test zeros in first middle, and last)
		
	}
	
	
	/**
	 * tests the equlas method of natural number class
	 */
	@Test
	public void testEqualsNaturalNumber() {
		// copys
		NaturalNumber n22 = new NaturalNumber(new WholeNumber(new int[] {9}, false));
		NaturalNumber n44 = new NaturalNumber(new WholeNumber(new int[] {0,0,9,3,4,5,6,0,0}, false));
		
		
		
		//test 0
		try {
			n1.equals(n2);
			fail("empty list did not throw an exception.");
		} catch (ArrayIndexOutOfBoundsException uoe) {
			//Everything is good
		} catch (Exception e) {
		      fail("empty list threw wrong type of exception.");
	    }
		
		assertEquals(true, n2.equals(n22));//test 1
		assertEquals(true, n4.equals(n44)); // test many (also test zeros in first middle, and last)
		
		
	}
	
	/**
	 * tests the toString method of the Natural Number class
	 */
	@Test
	public void testtoStringNaturalNumber() {
		
		//test 0
		try {
			n1.toString();
			fail("empty list did not throw an exception.");
		} catch (ArrayIndexOutOfBoundsException uoe) {
			//Everything is good
		} catch (Exception e) {
		      fail("empty list threw wrong type of exception.");
	    }
		
		
		assertEquals("9", n2.toString()); //test 1
		assertEquals("6543900", n4.toString()); //test many (also test zeros in first middle, and last)
		
	}
	
	public void testAddDifferentTypes() {
		
		// 76.57 + 23.16i
		ComplexNumber c6 = new ComplexNumber (new FloatingPointNumber(new int[] {7,5,6,7,0,0}, false, 2),new FloatingPointNumber(new int[] {6,1,3,2,0}, false, 2));
		//5.430
		RealNumber r4 = new RealNumber(new FloatingPointNumber(new int[] {0,3,4,5,0}, true, 3));
		//g4: 76540 + 942i
		GaussianInteger g4 = new GaussianInteger(new WholeNumber(new int[] {0,4,5,6,7}, true), new WholeNumber(new int[] {2,4,9}, true));
		//43820/432
		RationalNumber rt4 = new RationalNumber(new WholeNumber(new int[] {0,2,8,3,4,0,0}, false), new WholeNumber(new int[] {1}, false));
		//6540
		IntegerNumber int4 = new IntegerNumber(new WholeNumber(new int[] {0,4,5,6,0,0}, false));
		//6543900
		NaturalNumber n4 = new NaturalNumber(new WholeNumber(new int[] {0,0,9,3,4,5,6,0,0}, false));
		
		
		assertEquals("76616.57 + 965.16i", c6.add(g4).toString()); //Test A
		assertEquals("6550440/1", int4.add(n4));                   //Test B
		assertEquals("50360/1", int4.add(rt4).toString());         //Test C
		assertEquals("82.000 + 23.16i", r4.add(c6));                //Test D
		assertEquals("76545.430 + 942i", r4.add(g4));               //Test E


		//Test F
		try {
			c6.add(rt4);
			fail("addition of complex and rational number did not throw an exception.");
		} catch (UnsupportedOperationException uoe) {
			//Everything is good
		} catch (Exception e) {
		      fail("wrong type of exception.");
	    }
		
	}
	
	
}



