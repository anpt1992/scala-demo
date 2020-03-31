import Dependencies._

ThisBuild / scalaVersion     := "2.13.1"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

val sparkVersion        = "2.3.0"
val scalaTestVersion    = "3.0.5"
val scalaCheckVersion   = "1.13.4"

lazy val root = (project in file("."))
  .settings(
    name := "demo",
    libraryDependencies ++= Seq(
  "org.apache.spark"  %% "spark-core"      % sparkVersion,
  "org.apache.spark"  %% "spark-streaming" % sparkVersion,
  "org.apache.spark"  %% "spark-sql"       % sparkVersion,
  "org.apache.spark"  %% "spark-hive"      % sparkVersion,
  "org.apache.spark"  %% "spark-repl"      % sparkVersion,

  "org.scalatest"     %% "scalatest"       % scalaTestVersion  % "test",
  "org.scalacheck"    %% "scalacheck"      % scalaCheckVersion % "test")
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
