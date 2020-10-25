import java.util.Scanner;

public class mainclass {
    //got this convert to fraction from stack overflow
    static private String convertDecimalToFraction(double x){
        if (x < 0){
            return "-" + convertDecimalToFraction(-x);
        }
        double tolerance = 1.0E-6;
        double h1=1; double h2=0;
        double k1=0; double k2=1;
        double b = x;
        do {
            double a = Math.floor(b);
            double aux = h1; h1 = a*h1+h2; h2 = aux;
            aux = k1; k1 = a*k1+k2; k2 = aux;
            b = 1/(b-a);
        } while (Math.abs(x-h1/k1) > x*tolerance);
        if (k1==1)
            return ""+h1;
        else
            return h1+"/"+k1;
    }
    private static void  displayMat(float[][] matrixdisp)
    {
        for (int i=0;i<3;i++)
        {
            for (int j=0;j<4;j++)
            {
                System.out.print(convertDecimalToFraction(matrixdisp[i][j])+ "   ");

            }
            System.out.println();
        }
        System.out.println("***********************************************************");
    }
    private static void pivot(float[][] piviotmat, int x, int y)
    {
        float value= piviotmat[x][y];
        float z=1/value;// value to piviot
        System.out.println("piviting  row "+ x+ "by multiplying "+convertDecimalToFraction(z));
        for (int k=0;k<4;k++) {

            piviotmat[x][k] = piviotmat[x][k]  * z;//here we multiply the pivit
        }
        displayMat(piviotmat);
        float multiplier;
        for (int l=0;l<3;l++)
        {
            if (l!=y) {
                multiplier = piviotmat[l][y];//value to multiply to piviot
                System.out.println("multiplying  row "+ x+ "by  "+convertDecimalToFraction(multiplier));
                for (int k = 0; k < 4; k++) {
                    piviotmat[x][k] = piviotmat[x][k] * multiplier;//multiply pivit with row multiplier
                }
                displayMat(piviotmat);
                System.out.println("substracting   row "+ l+ "from  row "+x);
                for (int k = 0; k < 4; k++) {
                    piviotmat[l][k] = piviotmat[l][k] - piviotmat[x][k];

                }
                displayMat(piviotmat);
                System.out.println("restoring pivit  row "+ x+ "by dividing  "+convertDecimalToFraction(multiplier));
                for (int k = 0; k < 4; k++) {
                    piviotmat[x][k] = piviotmat[x][k] /multiplier;//restore the multipied pivit matrix
                }
                displayMat(piviotmat);
            }

        }

    }
    public static void main(String[] args) {
        float[][] matrix;
        matrix = new float[3][4];
        for (int i=0;i<3;i++)
        {
            for (int j=0;j<4;j++)
            {
                System.out.println("enter the values : ");
                Scanner sc= new Scanner(System.in);
                float value=   sc.nextFloat();
                matrix[i][j]=value;// checking matrix

            }
        }
        displayMat(matrix);
        for (int i=0;i<3;i++)
        {
            for (int j=0;j<4;j++)
            {
                if (i==j&&matrix[i][j]!=1)
                {
                    pivot(matrix, i, j);

                }
            }
        }
        for (int m=0;m<3;m++)
        {
            switch (m)
            {
                case 0:  System.out.println("value of x is "+ convertDecimalToFraction(matrix[0][3]));
                         break;
                case 1:  System.out.println("value of y is "+ convertDecimalToFraction(matrix[1][3]));
                    break;
                case 2:  System.out.println("value of z is "+ convertDecimalToFraction(matrix[2][3]));
                    break;
            }
        }
    }
}


