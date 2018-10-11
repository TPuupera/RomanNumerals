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

public class RomanNumerals {
 
	public int convertToInteger(String romanNum) throws RomanNumeralsException {
        // Initialize result 
        int result = 0; 
        if (romanNum.contains("IIII")||romanNum.contains("XXXX")||
        	romanNum.contains("CCCC")||romanNum.contains("MMMM")) {
        	throw new RomanNumeralsException();
        }
        if (romanNum.contains("VV")|| romanNum.contains("LL")||
        		romanNum.contains("DD")) {
        	//throw new RomanNumeralsException();
        	return -1;
        }
        if (romanNum.contains("IIV")||romanNum.contains("IIX")
        		||romanNum.contains("IIV")||romanNum.contains("IXL")
        		||romanNum.contains("IXC")||romanNum.contains("ICD")
        		||romanNum.contains("ICM")) {
        	//throw new RomanNumeralsException();
        	return -1;
        }
        if (romanNum.contains("XXL")||romanNum.contains("XXC")
        		||romanNum.contains("XCD") ||romanNum.contains("XCM")) {
        	//throw new RomanNumeralsException();
        	return -1;
        }
        if (romanNum.contains("CCD")||romanNum.contains("CCM")) {
        	//throw new RomanNumeralsException();
        	return -1;
        }
        else {
            for (int i=0; i<romanNum.length(); i++) 
            { 
                int s1 = value(romanNum.charAt(i)); 
      
                if (i+1 <romanNum.length()) 
                { 
                    int s2 = value(romanNum.charAt(i+1)); 
       
                    if (s1 >= s2) 
                    { 
                        result = result + s1; 
                    } 
                    else
                    {   
                    	if (s1==5 || s1==50|| s1==500)
                    	{
                    	return -1;
                    	}
                    	else {
                        result = result + s2 - s1; 
                        i++;
                    	}
                    } 
                } 
                else
                { 
                    result = result + s1; 
                    i++; 
                } 
            } 
            return result; 
        }
	}
	
    int value(char roman) 
    { 
        if (roman == 'I') 
            return 1; 
        if (roman == 'V') 
            return 5; 
        if (roman == 'X') 
            return 10; 
        if (roman == 'L') 
            return 50; 
        if (roman == 'C') 
            return 100; 
        if (roman == 'D') 
            return 500; 
        if (roman == 'M') 
            return 1000; 
        return -1; 
    } 
}
