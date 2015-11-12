/**
 * This code won't work because it doesn't trim any white spaces which is
 * required as per the clarifications of the question.
 * If the answer was to be reverse with whitespaces as it is, this will be a valid solution
 * @author Animesh
 *
 */
public class ReverseWordsInAString_NotAccepted {

	public static void main(String[] args) {
		String s = "H     S";
		String[] sarr = s.split(" ");
		System.out.println(sarr.length);
		System.exit(0);
	}

	public String reverseWords(String s) {
		char[] sArr = s.toCharArray();
		int len = s.length();
		// First reverse the entire string in place by
		// swapping i with length - i
		// Do it only till half since other half is covered by length - i
		reverse(sArr, 0, len);

		// Now run through the entire string again
		// And for every word i.e., till you get
		// a space. formulate a word and swap again
		int i = 0;
		while (i < len) {
			int start = i;
			while (i < len && sArr[i] != ' ') {
				i++;
			}
			reverse(sArr, start, i);
			// Now get next non space character
			while (i < len && sArr[i] == ' ') {
				i++;
			}
		}
		return new String(sArr);
	}

	private void reverse(char[] sArr, int low, int high) {
		for (int i = low; i < ((low + high) / 2); i++) {
			char temp = sArr[i];
			sArr[i] = sArr[high - 1 - (i - low)];
			sArr[high - 1 - (i - low)] = temp;
		}
	}
}