import org.apache.spark.ml.recommendation.ALS;
import org.apache.spark.ml.recommendation.ALSModel;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class RecommendationEngine {

    public static void main(String[] args) {

        SparkSession spark = SparkSession.builder()
                .appName("RecommendationEngine")
                .master("local[*]")
                .getOrCreate();

        // Read CSV directly as a DataFrame with header
        Dataset<Row> ratings = spark.read()
                .option("header", "true")
                .option("inferSchema", "true")
                .csv("data/purchases.csv");

        // Check the schema to verify columns are correct
        ratings.printSchema();
        ratings.show();

        // Train ALS model
        ALS als = new ALS()
                .setMaxIter(10)
                .setRegParam(0.1)
                .setUserCol("userId")      // Must match the CSV column name
                .setItemCol("productId")   // Must match the CSV column name
                .setRatingCol("rating");

        ALSModel model = als.fit(ratings);

        // Recommend top 5 products for each user
        Dataset<Row> recommendations = model.recommendForAllUsers(5);
        recommendations.show(false);

        // Save results
        recommendations.write()
                .format("json")
                .save("output/recommendations.json");
    }
}
