/* Naive Bayes Classifier using Java */
/**
 * Naive Bayes classifier. A naive Bayes classifier is a simple probabilistic
 * classifier based on applying Bayes' theorem with strong (naive) independence
 * assumptions. Depending on the precise nature of the probability model, naive
 * Bayes classifiers can be trained very efficiently in a supervised learning
 * setting. **/

package smile.classification;

import smile.math.MathEx;
import smile.stat.distribution.Distribution;
import smile.util.IntSet;

public class NaiveBayes implements SoftClassifier<double[]> {
    private static final long serialVersionUID = 2L;

    /**
     * The number of classes.
     */
    private int k;
    /**
     * The number of independent variables.
     */
    private int p;
    /**
     * The priori probability of each class.
     */
    private double[] priori;
    /**
     * The conditional distribution for general purpose naive Bayes classifier.
     */
    private Distribution[][] prob;
    /**
     * The class label encoder.
     */
    private IntSet labels;

    /**
     * Constructor of general naive Bayes classifier.
     *
     * @param priori the priori probability of each class.
     * @param condprob the conditional distribution of each variable in
     * each class. In particular, condprob[i][j] is the conditional
     * distribution P(x<sub>j</sub> | class i).
     */
    public NaiveBayes(double[] priori, Distribution[][] condprob) {
        this(priori, condprob, IntSet.of(priori.length));
    }

    /**
     * Constructor of general naive Bayes classifier.
     * 
     * @param priori the priori probability of each class.
     * @param condprob the conditional distribution of each variable in
     * each class. In particular, condprob[i][j] is the conditional
     * distribution P(x<sub>j</sub> | class i).
     * @param labels class labels
     */
    public NaiveBayes(double[] priori, Distribution[][] condprob, IntSet labels) {
        if (priori.length != condprob.length) {
            throw new IllegalArgumentException("The number of priori probabilities and that of the classes are not same.");
        }

        double sum = 0.0;
        for (double pr : priori) {
            if (pr <= 0.0 || pr >= 1.0) {
                throw new IllegalArgumentException("Invalid priori probability: " + pr);
            }
            sum += pr;
        }

        if (Math.abs(sum - 1.0) > 1E-5) {
            throw new IllegalArgumentException("The sum of priori probabilities is not one: " + sum);
        }

        this.k = priori.length;
        this.p = condprob[0].length;
        this.priori = priori;
        this.prob = condprob;
        this.labels = labels;
    }

    /**
     * Returns a priori probabilities.
     */
    public double[] priori() {
        return priori;
    }

    /**
     * Predict the class of an instance.
     * 
     * @param x the instance to be classified.
     * @return the predicted class label.
     */
    @Override
    public int predict(double[] x) {
        return predict(x, new double[k]);
    }

    /**
     * Predict the class of an instance.
     * 
     * @param x the instance to be classified.
     * @param posteriori the array to store a posteriori probabilities on output.
     * @return the predicted class label.
     */
    @Override
    public int predict(double[] x, double[] posteriori) {
        if (x.length != p) {
            throw new IllegalArgumentException(String.format("Invalid input vector size: %d", x.length));
        }

        for (int i = 0; i < k; i++) {
            double logprob = Math.log(priori[i]);

            for (int j = 0; j < p; j++) {
                logprob += prob[i][j].logp(x[j]);
            }

            posteriori[i] = logprob;
        }

        double Z = 0.0;
        double max = MathEx.max(posteriori);
        for (int i = 0; i < k; i++) {
            posteriori[i] = Math.exp(posteriori[i] - max);
            Z += posteriori[i];
        }

        for (int i = 0; i < k; i++) {
            posteriori[i] /= Z;
        }

        return labels.valueOf(MathEx.whichMax(posteriori));
    }
}
