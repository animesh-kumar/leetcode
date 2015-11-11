public class IntegerToRoman {
    Map<Integer, Character> intToRomanBaseMap = new HashMap<Integer, Character>();
		intToRomanBaseMap.put(1, 'I');
		intToRomanBaseMap.put(5, 'V');
		intToRomanBaseMap.put(10, 'X');
		intToRomanBaseMap.put(50, 'L');
		intToRomanBaseMap.put(100, 'C');
		intToRomanBaseMap.put(500, 'D');
		intToRomanBaseMap.put(1000, 'M');
		// Corner Cases : I before V or X is one less
		// X before L or C is 10 less
		// C before D or M is 100 less
		// Start from the end

		// Make a map to have nearest neighbours
		Map<Integer, Integer> nearest = new HashMap<Integer, Integer>();
		nearest.put(1, 1);
		nearest.put(2, 1);
		nearest.put(3, 1);
		nearest.put(4, 5);
		nearest.put(5, 5);
		nearest.put(6, 5);
		nearest.put(7, 5);
		nearest.put(8, 5);
		nearest.put(9, 10);
		nearest.put(0, 1);

		int n = num;
		int decimalPlace = 1;
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			int val = (n % 10) * decimalPlace;
			int nearestVal = decimalPlace * nearest.get(n % 10);
			StringBuilder tempString = new StringBuilder();
			while (val != 0) {
				if (val > 0) {
					tempString.append(intToRomanBaseMap.get(nearestVal));
					val = val - nearestVal;
				} else {
					StringBuilder newString = new StringBuilder();
					newString
							.append(intToRomanBaseMap.get(Math.abs(nearestVal)));
					newString.append(tempString);
					// Put everythinng back in tempString
					tempString = newString;
					val = val + nearestVal;
				}
				// Keep the sign
				nearestVal = decimalPlace * nearest.get(Math.abs(val % 10));
			}
			decimalPlace = decimalPlace * 10;
			tempString.append(sb);
			// Put everything in sb
			sb = tempString;
			n = n / 10;
		}
		return sb.toString();

	}
}