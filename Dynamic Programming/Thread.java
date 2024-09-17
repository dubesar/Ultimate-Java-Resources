package multitrycatch;

class Point {
	int first, second;

	public Point(int first, int second) {
		this.first = first;
		this.second = second;
	}
}

class MaxSumSubMatrix
{
	// function to find maximum sum k x k sub-matrix
	public static Point findMaxSumSubMatrix(int mat[][], int k)
	{
		// M x N matrix
		int M = mat.length;
		int N = mat[0].length;

		// pre-process the input matrix such that sum[i][j] stores
		// sum of elements in matrix from (0, 0) to (i, j)
		int[][] sum = new int[M][N];
		sum[0][0] = mat[0][0];

		// pre-process first row
		for (int j = 1; j < N; j++) {
			sum[0][j] = mat[0][j] + sum[0][j - 1];
		}

		// pre-process first column
		for (int i = 1; i < M; i++) {
			sum[i][0] = mat[i][0] + sum[i - 1][0];
		}

		// pre-process rest of the matrix
		for (int i = 1; i < M; i++) {
			for (int j = 1; j < N; j++) {
				sum[i][j] = mat[i][j] + sum[i - 1][j] + sum[i][j - 1]
							- sum[i - 1][j - 1];
			}
		}

		int total, max = Integer.MIN_VALUE;
		Point p = null;

		// find maximum sum sub-matrix

		// start from cell (k - 1, k - 1) and consider each
		// submatrix of size k x k
		for (int i = k - 1; i < M; i++)
		{
			for (int j = k - 1; j < N; j++)
			{
				// Note (i, j) is bottom right corner coordinates of
				// square sub-matrix of size k

				total = sum[i][j];
				if (i - k >= 0) {
					total = total - sum[i - k][j];
				}

				if (j - k >= 0) {
					total = total - sum[i][j - k];
				}

				if (i - k >= 0 && j - k >= 0) {
					total = total + sum[i - k][j - k];
				}

				if (total > max) {
					max = total;
					p = new Point(i, j);
				}
			}
		}

		// returns coordinates of bottom right corner of sub-matrix
		return p;
	}

	public static void main(String[] args)
	{
		// 5 x 5 matrix
		int[][] mat =
		{
			{ 3, -4, 6, -5, 1 },
			{ 1, -2, 8, -4, -2 },
			{ 3, -8, 9, 3, 1 },
			{ -7, 3, 4, 2, 7 },
			{ -3, 7, -5, 7, -6 }
		};

		// sub-matrix size
		int k = 3;

		// p contains bottom right corner coordinates of sub-matrix
		Point p = findMaxSumSubMatrix(mat, k);

		// print maximum sum sub-matrix
		for (int i = 0; i < k; i++)
		{
			for (int j = 0; j < k; j++)
			{
				int r = i + p.first - k + 1;
				int c = j + p.second - k + 1;
				System.out.printf("%3d", mat[r][c]);
			}

			System.out.println();
		}
	}
}

