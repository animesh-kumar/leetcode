public class BullsAndCows {
	public static void main(String[] args) {
		BullsAndCows cb = new BullsAndCows();
		System.out.println(cb.getHint("18075", "7810"));
	}

	public String getHint(String secret, String guess) {
		int bulls = 0;
		int cows = 0;
		int count = 0;
		while (count < secret.length() || count < guess.length()) {
			// Check if it's not out of bounds
			// If any string is out of bounds and still entered the loop that
			// means the other is over
			// Increase cow count
			if (count >= secret.length()) {
				cows++;
			}
			if (count >= guess.length()) {
				cows++;
			}
			// If both are in bounds then do the matching
			if (count < secret.length() && count < guess.length()) {
				char s = secret.charAt(count);
				char g = guess.charAt(count);
				// Characters match increase bull count
				if (s == g) {
					bulls++;
				} else {
					// Don't match
					cows++;
				}
			}
			// Increment the index
			count++;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(bulls);
		sb.append("A");
		sb.append(cows);
		sb.append("B");
		return sb.toString();

	}
}
