
 /* For the beginners to get understand what is linear regression is do visit :https://towardsdatascience.com/linear-regression-with-example-8daf6205bd49
 *
 *
 * x =input
 * y = output
 * c = constant/intercept --| initially 1
 * a = slope              --|
 *
 * */


public class LinearRegression
{
    private final double alpha = 0.01 ; //how much big or small of step we want to take in each iteration
    private double[] x;
    private double[] y ;

    private double[] hOfy;
    private double c = 1;
    private double a = 1;

    private int m;

    LinearRegression(double[] x, double[] y)
    {
        m = x.length;
        this.x = new double[m];
        this.y = new double[m];
        this.hOfy = new double[m];
        this.x = x;
        this.y = y;
        computeHofY();
        computeC();
        computeA();

    }

    public void computeHofY() {
        for (int iterator = 0; iterator < m; iterator++)
        {
            hOfy[iterator] = c + a * x[iterator];
        }
    }

    public void computeC()
    {
        double diff =0.0;
        for (int iterator = 0; iterator < m; iterator++)
        {
            diff += (hOfy[iterator] - y[iterator]);
        }

        c = c  - (alpha / m) * diff;
    }

    public void computeA()
    {
        double diff =0.0;
        for (int iterator = 0; iterator < m; iterator++)
        {
            diff += (hOfy[iterator] - y[iterator]) * x[iterator];
        }

        a = a - (alpha / m) * diff;
    }
    public String getFormula()
    {
        return "y = "+c +" + "+ a +" * x";
    }

    public static void main(String[] args) {

        double[] input = new double[]{6.2,6.5,5.48,6.54,7.18,7.93};
        double[] output = new double[]{26.3,26,65,25.03,26.01,27.9,30.47};

        LinearRegression linearRegression = new LinearRegression(input , output);
        System.out.println(linearRegression.getFormula());
    }
}