import static org.junit.Assert.*;

import org.junit.Test;
/*
Rules:
There were certain rules that the numerals followed which should be observed:
• The symbols 'I', 'X', 'C', and 'M' can be repeated at most 3 times in a row.
• The symbols 'V', 'L', and 'D' can never be repeated.
• The '1' symbols ('I', 'X', and 'C') can only be subtracted from the 2 next highest values ('IV' and 
'IX', 'XL' and 'XC', 'CD' and 'CM').
• Only one subtraction can be made per numeral ('XC' is allowed, 'XXC' is not).
• The '5' symbols ('V', 'L', and 'D') can never be subtracted.
 */
public class TestRomanNumerals {

	@Test
	public void testAllRomanNumbers() throws RomanNumeralsException{
		RomanNumerals numbers = new RomanNumerals();
		// Assert
		assertEquals(1,numbers.convertToInteger("I"));
		assertEquals(5,numbers.convertToInteger("V"));
		assertEquals(10,numbers.convertToInteger("X"));
		assertEquals(50,numbers.convertToInteger("L"));
		assertEquals(100,numbers.convertToInteger("C"));
		assertEquals(500,numbers.convertToInteger("D"));
		assertEquals(1000,numbers.convertToInteger("M"));

	}
	@Test (expected = RomanNumeralsException.class)
	public void testMoreThreeTimesRowI() throws RomanNumeralsException {
		RomanNumerals numbers = new RomanNumerals();
		
		numbers.convertToInteger("IIII");
	}
	@Test (expected = RomanNumeralsException.class)
	public void testMoreThreeTimesRowC() throws RomanNumeralsException {
		RomanNumerals numbers = new RomanNumerals();
		
		numbers.convertToInteger("CCCC");
	}
	
	@Test
	public void testNumbersOneToNine() throws RomanNumeralsException{
		RomanNumerals numbers = new RomanNumerals();
		// Assert
		assertEquals(1,numbers.convertToInteger("I"));
		assertEquals(2,numbers.convertToInteger("II"));
		assertEquals(3,numbers.convertToInteger("III"));
		assertEquals(4,numbers.convertToInteger("IV"));
		assertEquals(5,numbers.convertToInteger("V"));
		assertEquals(6,numbers.convertToInteger("VI"));
		assertEquals(7,numbers.convertToInteger("VII"));
		assertEquals(8,numbers.convertToInteger("VIII"));
		assertEquals(9,numbers.convertToInteger("IX"));

	}
	@Test
	public void testWrongRomanLetters() throws RomanNumeralsException{
		RomanNumerals numbers = new RomanNumerals();
		// Assert
		assertEquals(-1,numbers.convertToInteger("A"));
		assertEquals(-1,numbers.convertToInteger("B"));
		assertEquals(-1,numbers.convertToInteger("VV"));
		assertEquals(-1,numbers.convertToInteger("LL"));
		assertEquals(-1,numbers.convertToInteger("DD"));
	}
	
	@Test
	public void testWrongRomanLettersI() throws RomanNumeralsException{
		RomanNumerals numbers = new RomanNumerals();
		// Assert
		assertEquals(-1,numbers.convertToInteger("IIV"));
		assertEquals(-1,numbers.convertToInteger("IIX"));
		assertEquals(-1,numbers.convertToInteger("IIV"));
		assertEquals(-1,numbers.convertToInteger("IXC"));
		assertEquals(-1,numbers.convertToInteger("IXL"));
		assertEquals(-1,numbers.convertToInteger("ICD"));
		assertEquals(-1,numbers.convertToInteger("ICM"));
	}

	@Test
	public void testWrongRomanLettersX() throws RomanNumeralsException{
		RomanNumerals numbers = new RomanNumerals();
		// Assert
		assertEquals(-1,numbers.convertToInteger("XXC"));
		assertEquals(-1,numbers.convertToInteger("XXL"));
		assertEquals(-1,numbers.convertToInteger("XCD"));
		assertEquals(-1,numbers.convertToInteger("XCM"));
	}

	@Test
	public void testWrongRomanLettersC() throws RomanNumeralsException{
		RomanNumerals numbers = new RomanNumerals();
		// Assert
		assertEquals(-1,numbers.convertToInteger("CCD"));
		assertEquals(-1,numbers.convertToInteger("CCM"));

	}

	@Test
	public void testMinus5() throws RomanNumeralsException{
		RomanNumerals numbers = new RomanNumerals();
		// Assert
		assertEquals(-1,numbers.convertToInteger("VM"));
		assertEquals(-1,numbers.convertToInteger("LM"));
		assertEquals(-1,numbers.convertToInteger("DM"));
	}
		
	@Test
	public void testExamplesYears() throws RomanNumeralsException{
		RomanNumerals numbers = new RomanNumerals();
		// Assert
		assertEquals(1984,numbers.convertToInteger("MCMLXXXIV"));
		assertEquals(2014,numbers.convertToInteger("MMXIV"));
		assertEquals(3999,numbers.convertToInteger("MMMCMXCIX"));
		assertEquals(2666,numbers.convertToInteger("MMDCLXVI"));
		
	}
}
