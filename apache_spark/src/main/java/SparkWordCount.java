import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SparkWordCount {

    public static void main(String[] args) throws IOException {
        // Define input file path
        String inputFile = "data.txt";
        if (args.length > 0) {
            inputFile = args[0];
        }

        // Configure Spark
        SparkConf conf = new SparkConf()
                .setAppName("Word Count")
                .setMaster("local[*]"); // Use all available cores for local execution

        // Create a Spark context
        try (JavaSparkContext sc = new JavaSparkContext(conf)) {
            // Load input file
            JavaRDD<String> lines = sc.textFile(inputFile);

            // Split each line into words
            JavaRDD<String> words = lines.flatMap(line ->
                    Arrays.asList(line.toLowerCase().split("\\W+")).iterator());

            // Count occurrences of each word
            JavaPairRDD<String, Integer> wordCounts = words
                    .mapToPair(word -> new Tuple2<>(word, 1))
                    .reduceByKey(Integer::sum);

            // Sort by word (optional)
            JavaPairRDD<String, Integer> sortedCounts = wordCounts.sortByKey();

            // Collect and print results
            List<Tuple2<String, Integer>> output = sortedCounts.collect();

            try (FileWriter fileWriter = new FileWriter("spark_word_count_output.txt")) {
                for (Tuple2<String, Integer> tuple : output) {
                    fileWriter.write(tuple._1 + " : " + tuple._2 + "\n");
                }
            }

        }
    }
}
