name := "kudu-meetup"

version := "1.0"

scalaVersion := "2.10.6"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "1.6.0-cdh5.11.0" exclude("org.slf4j", "*")
libraryDependencies += "org.apache.spark" %% "spark-mllib" % "1.6.0-cdh5.11.0" exclude("org.slf4j", "*")
libraryDependencies += "org.apache.spark" %% "spark-streaming" % "1.6.0-cdh5.11.0" exclude("org.slf4j", "*")
libraryDependencies += "org.apache.spark" %% "spark-streaming-kafka" % "1.6.0-cdh5.11.0" exclude("org.slf4j", "*")
libraryDependencies += "org.apache.kudu" % "kudu-spark_2.10" % "1.3.0-SNAPSHOT" exclude("org.slf4j", "*")
libraryDependencies += "org.apache.kudu" % "kudu-mapreduce" % "1.3.0-cdh5.11.0" exclude("javax.servlet", "servlet-api")
libraryDependencies += "org.apache.kudu" % "kudu-client" % "1.3.0" exclude("org.slf4j", "*")

libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-api" % "1.7.5"  % "provided",
  "org.slf4j" % "slf4j-nop" % "1.7.5"  % "test"
)

resolvers += "Cloudera" at "https://repository.cloudera.com/artifactory/repo/"

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", "MANIFEST.MF") => MergeStrategy.discard
  case x => MergeStrategy.first

}
