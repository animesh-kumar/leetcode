public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        // Run extended binary search for the number
        return binarySearch(nums, 0, nums.length - 1, target);
    }
    
    private int binarySearch(int[] nums, int low, int high, int target){
        if(low > high) return -1;
        int mid = (low + high) / 2;
        if (nums[mid] == target) return mid;
        // Check if the number doesn't exist then the mid position is where the number should come
        // Corner cases when value is outside the list i.e., less than first element
        // greater than last element
        else if (nums[mid] > target && mid == 0) return mid;
        else if (nums[mid] < target && mid == nums.length - 1) return (mid + 1);
        else if (nums[mid] > target && nums[mid-1] < target) return mid;
        else if (nums[mid] > target) return binarySearch(nums, low, mid - 1, target);
        else return binarySearch(nums, mid + 1, high, target);
    }
}