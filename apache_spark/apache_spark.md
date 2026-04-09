## 1. Apache Spark Module POM (`apache_spark/pom.xml`)
This POM file includes:
- The same basic project configuration
- A property for Spark version: `<spark.version>3.5.0</spark.version>`
- A dependency on **Spark Core**:
  ```xml
  <dependency>
      <groupId>org.apache.spark</groupId>
      <artifactId>spark-core_2.13</artifactId>
      <version>${spark.version}</version>
  </dependency>
  ```

## 2. Understanding the Spark Core Dependency

The `spark-core_2.13` dependency provides:

1. **Core Spark Functionality**: The fundamental components needed for distributed data processing with Spark
2. **RDD API**: Resilient Distributed Datasets, Spark's primary data abstraction
3. **Task Scheduling**: Components for distributing work across a cluster
4. **Fault Tolerance**: Mechanisms for recovering from node failures
5. **Basic I/O**: File system access and data input/output operations

## 3. Explanation of the Implementation

The Spark word count implementation follows these steps:

1. **Configuration**: Sets up a Spark configuration with the application name and execution mode.
2. **Context Creation**: Creates a JavaSparkContext to interact with Spark.
3. **Data Loading**: Reads the input text file into an RDD of lines.
4. **Transformation**:
  - Splits each line into words
  - Maps each word to a (word, 1) pair
  - Reduces by key to sum the counts for each word
5. **Output**: Collects and displays the results, and optionally saves them to a file.

## 4. Running the Application

To run the application:

1. Make sure you have Maven installed
2. Navigate to the apache_spark directory
3. Build the project: `mvn clean package`
4. Run the application:
   ```
   spark-submit --class SparkWordCount --master local[*] target/*.jar path/to/input/file (optional)
   ```

If you don't specify an input file, it will use the default "data.txt" in the current directory.

## 5. Sample Output

For the input file containing "Hello World", the output would be:

```
Word Count Results:
hello: 1
world: 1
```

## 6. Key Differences from In-Memory Implementation

Compared to the `WordCountInMemory.java` implementation:

1. **Distributed Processing**: Spark distributes the processing across multiple nodes/cores.
2. **Fault Tolerance**: Spark RDDs provide fault tolerance through lineage.
3. **Scalability**: The Spark implementation can handle much larger datasets that don't fit in memory.
4. **Lazy Evaluation**: Transformations in Spark are lazy and only executed when an action is called.

This implementation leverages Spark's distributed computing capabilities while maintaining the same functional approach to word counting as the in-memory version.