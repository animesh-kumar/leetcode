public class TwoSum_NSquareTimeComplexity {
    public int[] twoSum(int[] nums, int target) {
        // n-square solution
        int[] indexes = new int[]{0,0};
        // Start with searching from first value
        // Since it needs index 1 less than index 2, always search ahead
        for (int i = 0; i < nums.length-1; i++){
            for (int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    indexes[0] = i + 1;
                    indexes[1] = j + 1;
                }
            }
        }
        return indexes;
    }
}