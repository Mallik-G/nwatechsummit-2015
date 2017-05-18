~/nwatechsummit-2015/spark-1.6.0-bin-hadoop2.6/bin/spark-submit \
--repositories https://repository.cloudera.com/artifactory/repo/ \
--packages "org.apache.kudu:kudu-spark_2.10:1.3.0,org.apache.spark:spark-streaming_2.10:1.6.0,"\
"org.apache.spark:spark-streaming-kafka_2.10:1.6.0,org.apache.spark:spark-sql_2.10:1.6.0" \
--class com.svds.kudumeetup.KuduMeetupParquetLoad \
../target/scala-2.10/kudu-meetup_2.10-1.0.jar \
/user/ubuntu/meetup_parquet \
file:///disk1/meetupstream
