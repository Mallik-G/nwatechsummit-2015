~/nwatechsummit-2015/spark-2.1.1-bin-hadoop2.7/bin/spark-submit  \
--repositories https://repository.cloudera.com/artifactory/cloudera-repos/ \
--packages "org.apache.kudu:kudu-client:1.3.0" \
--class com.svds.kudumeetup.CreateMeetupKuduTable \
../target/scala-2.10/kudu-meetup_2.10-1.0.jar \
localhost \
kudu_meetup_rsvps

