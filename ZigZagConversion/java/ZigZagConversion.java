import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
	public static void main(String[] args) {
		ZigZagConversion z = new ZigZagConversion();
		String s = "PAYPALISHIRING";
		int numRows = 4;
		z.convert(s, numRows);
	}

	public String convert(String s, int numRows) {
		// Here zigzag pattern has to make a z shape
		// So first bring the rows down till the number of rows is there
		// then try to make the slant shape
		// slant can be made (-1 row and + 1 column) or (+1 row and -1 col)
		// once slant is done come back to putting the characters top to bottom
		if (numRows == 1)
			return s;
		List<List<Character>> zig = new ArrayList<List<Character>>();
		boolean zigzag = false;
		List list = null;
		// If you see it mathematically by drawing a diagram
		// The resultant output which is needed can be easily created by
		// modulo arithmetic
		// Top to down in incremental modulo
		// Zig zag in decremental
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int modVal = i % (2 * numRows - 2);
			if (modVal < numRows)
				zigzag = false;
			else
				zigzag = true;
			// Get the list in which the value will be put
			// Each list will keep characters of each row
			if (zigzag) {
				// Behavior tweaks a little in zig zag mode
				// List number will be returned by (2 * numrows - 2) - modval
				modVal = (2 * numRows - 2) - modVal;
			}
			if (modVal < zig.size()) {
				list = zig.get(modVal);
			} else {
				list = new ArrayList<Character>();
				zig.add(list);
			}
			list.add(c);
		}
		// Now print the values
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < zig.size(); i++) {
			list = zig.get(i);
			for (int j = 0; j < list.size(); j++) {
				sb.append(list.get(j) + "");
			}
		}
		return sb.toString();

	}
}
