public class RangeSumQuery2DImmutable {

	class NumMatrix {
		int[][] sum;

		public NumMatrix(int[][] matrix) {
			if (matrix == null || matrix.length == 0) {
				sum = new int[1][1];
				sum[0][0] = 0;
			} else {
				int rows = matrix.length;
				int cols = matrix[0].length;
				sum = new int[rows][cols];
				// Each row will calculate the sum in that row
				// I am going to work only on the partial sums
				for (int i = 0; i < rows; i++) {
					sum[i][0] = matrix[i][0];
					for (int j = 1; j < cols; j++) {
						sum[i][j] = sum[i][j - 1] + matrix[i][j];
					}
				}
			}
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			int sumVal = 0;
			// Calculate the sum of each row part and add the sum up
			for (int i = row1; i <= row2; i++) {
				if (col1 == 0) {
					sumVal += sum[i][col2];
				} else {
					// Remove the extra partial sum of undesired part
					sumVal += sum[i][col2] - sum[i][col1 - 1];
				}
			}
			return sumVal;
		}
	}

	public static void main(String[] args) {
		// Your NumMatrix object will be instantiated and called as such:
		int[][] matrix = { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 },
				{ 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 }, { 1, 0, 3, 0, 5 } };

		RangeSumQuery2DImmutable r = new RangeSumQuery2DImmutable();
		NumMatrix numMatrix = r.new NumMatrix(matrix);
		System.out.println(numMatrix.sumRegion(0, 1, 2, 3));
		System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
		System.out.println(numMatrix.sumRegion(1, 2, 3, 4));
		System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
	}

}