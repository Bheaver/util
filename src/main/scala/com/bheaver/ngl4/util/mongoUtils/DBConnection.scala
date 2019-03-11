package com.bheaver.ngl4.util.mongoUtils

import java.util

import com.bheaver.ngl4.util.config.ApplicationConf
import com.mongodb.connection.ClusterSettings
import com.mongodb.reactivestreams.client.{MongoClient, MongoClients}
import com.mongodb.{MongoClientSettings, ServerAddress}

import scala.collection.JavaConversions._
import scala.collection.mutable.ListBuffer

trait DBConnection {
  def getDBConnection: MongoClient
}

class DBConnectionImpl(applicationConf: ApplicationConf) extends DBConnection {
  private val addresses: util.List[ServerAddress] = applicationConf.general.mongodb.servers.map(server => new ServerAddress(server.ip, server.port))
  private val addresses1: ListBuffer[ServerAddress] = ListBuffer(addresses: _*)
  private val clusterSettings = ClusterSettings.builder().hosts(addresses1).build()
  val mongoClientSettings = MongoClientSettings.builder().applyToClusterSettings(clusterSettings => {}).build()
  val mongoClient = MongoClients.create(mongoClientSettings)
  override def getDBConnection: MongoClient = {
    mongoClient
  }
}