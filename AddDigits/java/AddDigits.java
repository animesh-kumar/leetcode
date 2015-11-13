public class AddDigits {
	public int addDigits(int num) {
		// Keep a flag to check if the addition is complete or not
		// In our case it will be set to true only when there is just one digit
		// left
		boolean done = false;
		int n = num;
		int sum = 0;
		while (!done) {
			sum = 0;
			// Extract each digit
			// Add it to sum
			while (n > 0) {
				// Doing a modulo by 10 gives the digit
				// From back to front
				sum += n % 10;
				// Change the number to extract digit at next place
				// Hence divide by 10
				n = n / 10;
			}
			// If sum is more than 9 that means it contains more than one digit
			// Hence flag will be kept unset and calculations will be done again
			if (sum > 9) {
				done = false;
				n = sum;
			} else {
				done = true;
			}
		}
		return sum;
	}
}
