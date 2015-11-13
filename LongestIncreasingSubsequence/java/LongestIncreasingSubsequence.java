public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		int[] nums = new int[] { 10, 9, 2, 5, 3, 4 };
		LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
		System.out.println(l.lengthOfLIS(nums));
	}

	public int lengthOfLIS(int[] nums) {
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			int count = 1;
			int num = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] > num) {
					num = nums[j];
					count++;
				}
			}
			if (count > max) {
				max = count;
			}
		}
		return max;

	}
}
