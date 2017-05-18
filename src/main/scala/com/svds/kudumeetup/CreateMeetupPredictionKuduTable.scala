package com.svds.kudumeetup

import java.util
import org.apache.kudu.ColumnSchema.ColumnSchemaBuilder
import org.apache.kudu.client.KuduClient.KuduClientBuilder
import org.apache.kudu.client.{CreateTableOptions, KuduClient, KuduTable}
import org.apache.kudu.{Schema, Type}
import org.apache.kudu.ColumnSchema
import com.google.common.collect.ImmutableList
import scala.collection.JavaConverters._
import scala.collection.immutable.IndexedSeq

object CreateMeetupPredictionKuduTable {
  def main(args:Array[String]): Unit = {
    if (args.length == 0) {
      println("{kuduMaster} {tableName}")
      return
    }

    val kuduMaster = args(0)
    val tableName = args(1)

    val kuduClient = new KuduClient.KuduClientBuilder(kuduMaster).build()
    val tableOptions = new CreateTableOptions().setRangePartitionColumns(List("time").asJava)
      .setNumReplicas(3)
    val columnList = new util.ArrayList[ColumnSchema]()

    columnList.add(new ColumnSchemaBuilder("time", Type.INT64).key(true).build())
    columnList.add(new ColumnSchemaBuilder("rsvp_cnt", Type.DOUBLE).key(false).build())
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


