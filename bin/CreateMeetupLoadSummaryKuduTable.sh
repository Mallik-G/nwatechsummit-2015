~/nwatechsummit-2015/spark-2.1.1-bin-hadoop2.7/bin/spark-submit  \
--repositories https://repository.cloudera.com/artifactory/repo/ \
--packages "org.apache.kudu:kudu-spark_2.10:1.3.0-SNAPSHOT" \
--class com.svds.kudumeetup.CreateMeetupLoadSummaryKuduTable \
../target/scala-2.10/kudu-meetup_2.10-1.0.jar \
up1,up2 \
kudu_meetup_rsvps_load_summary

