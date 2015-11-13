public class AddBinary {
    public String addBinary(String a, String b) {
    	// Keep two pointers starting from the back of both the strings
    	// Addition will be done from backwards to forward to handle carries
        int i = a.length() - 1;
        int j = b.length() - 1;
        // Handles carry in cases where 1 + 1 will be 10
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0){
            int val;
            if(i >= 0 && j >= 0){
            	// Convert the character to integer and add
            	//  Add the carry from previous additions
                val = Integer.parseInt(a.charAt(i--)+"")+Integer.parseInt(b.charAt(j--)+"")+carry;
            }else if(i >= 0){
                val = Integer.parseInt(a.charAt(i--)+"")+carry;
            }else{
                val = Integer.parseInt(b.charAt(j--)+"")+carry;
            }
            // 2 % 2 = 0 hence 1 + 1 will become 0 and carry 1 which is done in next step
            sb.append(val%2);
            carry = val / 2;
        }
        // The carry might overflow outside the size of both strings.
        // Handling for that
        if(carry > 0)
            sb.append(carry);
        // Since the addition was done from back to front, the desired value 
        // will be obtained on reversing the string.
        return sb.reverse().toString();
    }
}
