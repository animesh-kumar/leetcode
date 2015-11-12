public class TwoSum_NTimeAndNSpaceComplexity {
    public int[] twoSum(int[] numbers, int target) {
        // n time and n space complexity solution
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	int[] result = new int[2];
     
    	for (int i = 0; i < numbers.length; i++) {
    	    // Check if the map contains the number
    	    // THis number will basically checking for the second number - difference from first number
    	    // the first number should already be present in the map
    		if (map.containsKey(numbers[i])) {
    			int index = map.get(numbers[i]);
    			result[0] = index+1 ;
    			result[1] = i+1;
    			break;
    		} else {
    		    // Put the required difference and the position in the map
    		    // So that it can be checked later
    			map.put(target - numbers[i], i);
    		}
    	}
     
    	return result;
    }
}