public class ReverseInteger {
    public int reverse(int x) {
	// Make a note of sign before any processing so that it can be prepended 
	// later 
        int sign = 1;
        if(x < 0){
	    // Negative number
            sign = -1;
        }
	// Now reverse the number by extracting digit by digit from the end
        long reverse = 0;
	// Work on the absolute value since sign has already been accounted for
        x = Math.abs(x);
	// The last digit in the number will come on first place in reverse and so on
	// Hence extract digits from the end and put it in the reverse string
        while (x > 0){
	    // Multiplication by 10 is done to account for digit place in the reverse number
            reverse = (reverse * 10) + (x % 10);
	    // In case of overflow just return 0
            if(reverse > Integer.MAX_VALUE){
                return 0;
            }
            x = x / 10;
        }
	// Add the sign previously stored to the number
        return (int)reverse * sign;
    }
}
