#!/bin/bash
#/home/u/nwatechsummit-2015/spark-2.1.1-bin-hadoop2.7/bin/spark-submit \
spark2-submit \
--repositories https://repository.cloudera.com/artifactory/cloudera-repos/ \
--class com.svds.kudumeetup.KuduMeetup \
/home/u/nwatechsummit-2015/target/scala-2.11/kudu-meetup-assembly-1.0.jar \
up1,up2 \
up1:9092,up2:9092

