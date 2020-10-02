import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
 
import weka.classifiers.Classifier;
import weka.classifiers.lazy.IBk;
import weka.core.Instance;
import weka.core.Instances;
 
/*
kNN is also provided by Weka as a class "IBk". IBk implements kNN. It uses normalized distances for all attributes so that attributes on different scales have the same impact on the distance function. It may return more than k neighbors if there are ties in the distance. Neighbors are voted to form the final classification.

First prepare your data by creating a txt file "ads.txt":
*/

public class KNN {
	public static BufferedReader readDataFile(String filename) {
		BufferedReader inputReader = null;
 
		try {
			inputReader = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException ex) {
			System.err.println("File not found: " + filename);
		}
 
		return inputReader;
	}
 
	public static void main(String[] args) throws Exception {
		BufferedReader datafile = readDataFile("ads.txt");
 
		Instances data = new Instances(datafile);
		data.setClassIndex(data.numAttributes() - 1);
 
		//do not use first and second
		Instance first = data.instance(0);
		Instance second = data.instance(1);
		data.delete(0);
		data.delete(1);
 
		Classifier ibk = new IBk();		
		ibk.buildClassifier(data);
 
		double class1 = ibk.classifyInstance(first);
		double class2 = ibk.classifyInstance(second);
 
		System.out.println("first: " + class1 + "\nsecond: " + class2);
	}
}
