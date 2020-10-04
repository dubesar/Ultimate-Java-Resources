import java.util.ArrayList;

public class LinearRegression {

    private ArrayList<Float> Xdata;
    private ArrayList<Float> Ydata;
    private Float result1;
    private Float result2;

    private Float getXMean(ArrayList<Float> Xdata) {
        result1 = 0.0f ;
        for (Integer i = 0; i < Xdata.size(); i++) {
            result1 = result1 + Xdata.get(i);
        }
        return result1/Xdata.size();
    }

    private Float getYMean(ArrayList<Float> Ydata) {
        result2 = 0.0f ;
        for (Integer i = 0; i < Ydata.size(); i++) {
            result2 = result2 + Ydata.get(i);
        }
        return result2/Ydata.size();
    }

    /**
     * The equation of straight line is "y = m * x + c"
     * where m is the line slope and (x, y) are the data point
     * coordinates and c is the Yintercept.
     * 
     *        Y1  = m *   X1  + c
     *      Ymean = m * Xmean + c
     *    ------------------------------
     *     (Ymean - Y1) = m * (Xmean - X1)
     *    ------------------------------
     * 
     * Multiply both sides by (Xmean - X1) and calculate m to 
     * get line slope.
     */
    private Float getLineSlope (Float Xmean, Float Ymean, Float X1, Float Y1) {
        float num1 = X1 - Xmean;
        float num2 = Y1 - Ymean;
        float denom = (X1 - Xmean) * (X1 - Xmean);
        return (num1 * num2) / denom;
    }

    /**
     * The equation of straight line is "y = m * x + c"
     * where m is the line slope and (x, y) are the data point
     * coordinates and c is the Yintercept.
     * 
     *      y - (m * x) = Yintercept
     */
    private float getYIntercept (Float Xmean, Float Ymean, Float lineSlope) {
        return Ymean - (lineSlope * Xmean);
    }

    /**
     * To predict the Y value for a given data point, 
     * just substitute the values m, x and c in 
     * y = m * x + c
     */
    private Float predictValue (Float inputValue) {
        Float X1 = Xdata.get(0) ;
        Float Y1 = Ydata.get(0) ;
        Float Xmean = getXMean(Xdata) ;
        Float Ymean = getYMean(Ydata) ;
        Float lineSlope = getLineSlope(Xmean, Ymean, X1, Y1) ;
        Float YIntercept = getYIntercept(Xmean, Ymean, lineSlope) ;
        Float prediction = (lineSlope * inputValue) + YIntercept ;
        return prediction ;
    }

    public static void main(String[] args) {
        LinearRegression lRegression = new LinearRegression();
        lRegression.Xdata = new ArrayList<>() ;
        lRegression.Ydata = new ArrayList<>() ;

        lRegression.Xdata.add(1.5f) ;
        lRegression.Xdata.add(1.4f) ;
        lRegression.Xdata.add(1.3f) ;
        lRegression.Xdata.add(1.25f) ;
        lRegression.Xdata.add(1.19f) ;

        lRegression.Ydata.add(7.61f) ;
        lRegression.Ydata.add(7.10f) ;
        lRegression.Ydata.add(6.59f) ;
        lRegression.Ydata.add(6.34f) ;
        lRegression.Ydata.add(6.03f) ;

        System.out.println(lRegression.predictValue(1.5f));
    }
}
