package com.svds.kudumeetup

import java.util
import org.apache.kudu.ColumnSchema.ColumnSchemaBuilder
import org.apache.kudu.client.{CreateTableOptions, KuduClient, KuduTable}
import org.apache.kudu.{Schema, Type}
import org.apache.kudu.ColumnSchema
import scala.collection.JavaConverters._

object CreateMeetupKuduTable {
  def main(args:Array[String]): Unit = {
    if (args.length == 0) {
      println("{kuduMaster} {tableName}")
      return
    }
    val kuduMaster = args(0)
    val tableName = args(1)
    val kuduClient = new KuduClient.KuduClientBuilder(kuduMaster).build()
    val tableOptions = new CreateTableOptions().setRangePartitionColumns(List("event_id").asJava).setNumReplicas(3)
    val columnList = new util.ArrayList[ColumnSchema]()

    columnList.add(new ColumnSchemaBuilder("event_id", Type.STRING).key(true).build())
    columnList.add(new ColumnSchemaBuilder("member_id", Type.INT32).key(true).build())
    columnList.add(new ColumnSchemaBuilder("rsvp_id", Type.INT32).key(true).build())
    columnList.add(new ColumnSchemaBuilder("event_name", Type.STRING).key(false).build())
    columnList.add(new ColumnSchemaBuilder("event_url", Type.STRING).key(false).build())
    columnList.add(new ColumnSchemaBuilder("TIME", Type.INT64).key(false).build())
    columnList.add(new ColumnSchemaBuilder("guests", Type.INT32).key(false).build())
    columnList.add(new ColumnSchemaBuilder("member_name", Type.STRING).key(false).build())
    columnList.add(new ColumnSchemaBuilder("facebook_identifier", Type.STRING).key(false).build())
    columnList.add(new ColumnSchemaBuilder("linkedin_identifier", Type.STRING).key(false).build())
    columnList.add(new ColumnSchemaBuilder("twitter_identifier", Type.STRING).key(false).build())
    columnList.add(new ColumnSchemaBuilder("photo", Type.STRING).key(false).build())
    columnList.add(new ColumnSchemaBuilder("mtime", Type.INT64).key(false).build())
    columnList.add(new ColumnSchemaBuilder("response", Type.STRING).key(false).build())
    columnList.add(new ColumnSchemaBuilder("lat", Type.DOUBLE).key(false).build())
    columnList.add(new ColumnSchemaBuilder("lon", Type.DOUBLE).key(false).build())
    columnList.add(new ColumnSchemaBuilder("venue_id", Type.INT32).key(false).build())
    columnList.add(new ColumnSchemaBuilder("venue_name", Type.STRING).key(false).build())
    columnList.add(new ColumnSchemaBuilder("visibility", Type.STRING).key(false).build())
    val schema = new Schema(columnList)

    if (kuduClient.tableExists(tableName)) {
      println("Deleting Table")
      kuduClient.deleteTable(tableName)
    }

    println("Creating Table")
    kuduClient.createTable(tableName, schema, tableOptions)
    println("Created Table")
    kuduClient.shutdown()
  }
}