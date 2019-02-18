package com.bheaver.ngl4.util.mongoUtils

import com.mongodb.reactivestreams.client.{MongoClient, MongoClients}


trait DBConnection {
  def getDBConnection: MongoClient
}

class DBConnectionImpl extends DBConnection {
 private val mongoClient: MongoClient = MongoClients.create("mongodb://localhost")
  override def getDBConnection: MongoClient = {
    mongoClient
  }
}

object DBConnectionImpl {
  val dbConnectionImpl = new DBConnectionImpl

  def apply: MongoClient = dbConnectionImpl.getDBConnection
}