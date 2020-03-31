package example

// import scala.concurrent._, duration._
// import core.Weather

// object Hello extends App {
//   val w = Await.result(Weather.weather, 10.seconds)
//   println(s"Hello! The weather in New York is $w.")
//   Weather.http.close()
// }

import org.apache.spark._
import org.apache.spark.SparkContext._

object WordCount {
    def main(args: Array[String]) {
      val inputFile = "in.txt"
      val outputFile = "out.txt"
      val conf = new SparkConf().setAppName("wordCount")
      // Create a Scala Spark Context.
      val sc = new SparkContext(conf)
      // Load our input data.
      val input =  sc.textFile(inputFile)
      // Split up into words.
      val words = input.flatMap(line => line.split(" "))
      // Transform into word and count.
      val counts = words.map(word => (word, 1)).reduceByKey{case (x, y) => x + y}
      // Save the word count back out to a text file, causing evaluation.
      counts.saveAsTextFile(outputFile)
    }
}