public class RangeSumQueryImmutable {

	class NumArray {
		int[] sum = new int[100];

		public NumArray(int[] nums) {
			if (nums == null || nums.length == 0) {
				sum = new int[1];
				sum[0] = 0;
			} else {
				sum = new int[nums.length];
				sum[0] = nums[0];
				for (int i = 1; i < nums.length; i++) {
					sum[i] = sum[i - 1] + nums[i];
				}
			}
		}

		public int sumRange(int i, int j) {
			if (i > 0) {
				// For summary say 2 to 5, sum[5] will have summation from 0 to
				// 5
				// hence to get desired result
				return sum[j] - sum[i - 1];
			} else {
				return sum[j];
			}
		}
	}

	public static void main(String[] args) {
		RangeSumQueryImmutable r = new RangeSumQueryImmutable();
		int[] nums = {-2, 0, 3, -5, 2, -1};
		NumArray numArray = r.new NumArray(nums);
		System.out.println(numArray.sumRange(0, 2));
		System.out.println(numArray.sumRange(2, 5));
		System.out.println(numArray.sumRange(0, 5));
		System.out.println(numArray.sumRange(0, 1));
		System.out.println(numArray.sumRange(1, 2));
	}

}
