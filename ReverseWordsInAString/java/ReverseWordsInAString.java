public class ReverseWordsInAString {

	public static void main(String[] args) {
		ReverseWordsInAString r = new ReverseWordsInAString();
		// String s = "the sky is blue";
		String s = " 1";
		System.out.println(s);
		System.out.println(r.reverseWords(s));
	}

	public String reverseWords(String s) {
		// Remove any leading and trailing spaces
		s = s.trim();
		// Split the string based on spaces
		String[] arr = s.split("\\s+");
		// Now rearrange the words in the array.
		// Last will go to first and first will come to last and so on
		reverse(arr, 0, arr.length);
		// Concat all the strings and provide spaces between two words
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			// Append to StringBuilder with an extra space in the beginning
			if (i == 0) {
				// No extra space needed for first hence this different
				// implementation
				sb.append(arr[i]);
			} else {
				sb.append(" ");
				sb.append(arr[i]);
			}
		}
		return sb.toString();
	}

	private void reverse(String[] sArr, int low, int high) {
		for (int i = low; i < ((low + high) / 2); i++) {
			String temp = sArr[i];
			sArr[i] = sArr[high - 1 - (i - low)];
			sArr[high - 1 - (i - low)] = temp;
		}
	}
}