#!/bin/bash
#/home/u/nwatechsummit-2015/spark-1.6.0-bin-hadoop2.6/bin/spark-submit \
/home/u/nwatechsummit-2015/spark-2.1.1-bin-hadoop2.7/bin/spark-submit \
--repositories https://repository.cloudera.com/artifactory/cloudera-repos/ \
--packages "org.apache.kudu:kudu-spark_2.10:1.3.0,org.apache.spark:spark-streaming_2.1.0:2.1.0,"\
"org.apache.spark:spark-streaming-kafka_2.10:2.0.0-cloudera1-SNAPSHOT,org.apache.spark:spark-sql_2.1.0:2.1.0" \
--class com.svds.kudumeetup.KuduMeetup \
/home/u/nwatechsummit-2015/target/scala-2.10/kudu-meetup-assembly-1.0.jar \
up1,up2 \
up1:9092,up2:9092

