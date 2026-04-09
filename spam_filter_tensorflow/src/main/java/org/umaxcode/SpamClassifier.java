package org.eddydashcode;

import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.evaluation.Evaluation;
import weka.core.Debug;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;

public class SpamClassifier {
    public static void main(String[] args) throws Exception {
        // Load original ARFF dataset
        DataSource source = new DataSource("data/spam.arff");
        Instances rawData = source.getDataSet();
        rawData.setClassIndex(0); // label is the first column

        // Create and train filter
        StringToWordVector filter = new StringToWordVector();
        filter.setInputFormat(rawData);

        // Apply filter to training data
        Instances filteredData = Filter.useFilter(rawData, filter);

        // Train the classifier
        NaiveBayes model = new NaiveBayes();
        model.buildClassifier(filteredData);

//        RandomForest model = new RandomForest();
//        model.buildClassifier(filteredData);

//        SMO model = new SMO();
//        model.buildClassifier(filteredData);

        Evaluation eval = new Evaluation(filteredData);
        eval.crossValidateModel(model, filteredData, 10, new Debug.Random(1));
        System.out.println(eval.toSummaryString());
        System.out.println(eval.toClassDetailsString());
        System.out.println(eval.toMatrixString());

        // Create a single test instance with the same structure as rawData
        Instances testSet = new Instances(rawData, 0);
        DenseInstance testInstance = new DenseInstance(rawData.numAttributes());
        testInstance.setDataset(testSet);
        testInstance.setValue(rawData.attribute("message"), "Congratulations! You've been selected for a chance to win a brand new iPhone 14. Click the link to claim your prize: http://win-now.co.uk");
        testInstance.setMissing(rawData.classIndex());
        testSet.add(testInstance);

        // Filter the test instance using the same StringToWordVector filter
        Instances filteredTestSet = Filter.useFilter(testSet, filter);
        Instance filteredTestInstance = filteredTestSet.firstInstance();

        // Classify the new instance
        double prediction = model.classifyInstance(filteredTestInstance);
        String predictedLabel = filteredData.classAttribute().value((int) prediction);

        System.out.println("Prediction: " + predictedLabel);
    }
}
