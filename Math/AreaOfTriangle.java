import java.util.Random;
 
public class Area_Triangle_Determinants
{
    public static double determinant(double A[][], int N)
    {
        double det = 0;
        if (N == 1)
        {
            det = A[0][0];
        } else if (N == 2)
        {
            det = A[0][0] * A[1][1] - A[1][0] * A[0][1];
        } else
        {
            det = 0;
            for (int j1 = 0; j1 < N; j1++)
            {
                double[][] m = new double[N - 1][];
                for (int k = 0; k < (N - 1); k++)
                {
                    m[k] = new double[N - 1];
                }
                for (int i = 1; i < N; i++)
                {
                    int j2 = 0;
                    for (int j = 0; j < N; j++)
                    {
                        if (j == j1)
                            continue;
                        m[i - 1][j2] = A[i][j];
                        j2++;
                    }
                }
                det += Math.pow(-1.0, 1.0 + j1 + 1.0) * A[0][j1]
                        * determinant(m, N - 1);
            }
        }
        return det;
    }
 
    public static void main(String args[])
    {
        Random random = new Random();
        int x1, x2, x3, y1, y2, y3;
        x1 = random.nextInt(10);
        x2 = random.nextInt(10);
        x3 = random.nextInt(10);
        y1 = random.nextInt(10);
        y2 = random.nextInt(10);
        y3 = random.nextInt(10);
 
        double[][] mat = new double[3][3];
        mat[0][0] = x1;
        mat[0][1] = y1;
        mat[0][2] = 1;
        mat[1][0] = x2;
        mat[1][1] = y2;
        mat[1][2] = 1;
        mat[2][0] = x3;
        mat[2][1] = y3;
        mat[2][2] = 1;
 
        System.out
                .println("The matrix formed by the coordinates of the triangle is: ");
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
 
        double det = determinant(mat, 3) * 0.5;
        if (det < 0)
            System.out.println("The Area of the triangle formed by (" + x1
                    + "," + y1 + "), (" + x2 + "," + y2 + "), (" + x3 + ","
                    + y3 + ") = " + (det * -1));
        else
            System.out.println("The Area of the triangle formed by (" + x1
                    + "," + y1 + "), (" + x2 + "," + y2 + "), (" + x3 + ","
                    + y3 + ") = " + det);
    }
}