~/nwatechsummit-2015/spark-1.6.0-bin-hadoop2.6/bin/spark-submit \
--repositories https://repository.cloudera.com/artifactory/repo/ \
--packages "org.apache.kudu:kudu-client:1.3.0" \
--class com.svds.kudumeetup.CreateMeetupPredictionKuduTable \
../target/scala-2.10/kudu-meetup_2.10-1.0.jar \
localhost \
kudu_meetup_rsvps_predictions
