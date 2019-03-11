package com.bheaver.ngl4.util.mongoUtils

import com.bheaver.ngl4.util.config.ApplicationConf
import com.mongodb.reactivestreams.client.{MongoClient, MongoDatabase}

trait Database {
  def getDatabase(libraryCode: String): MongoDatabase
  def getMasterDatabase: MongoDatabase
}

class DatabaseImpl(mongoClient: MongoClient, applicationConf: ApplicationConf) extends Database {
  override def getDatabase(libraryCode: String): MongoDatabase = mongoClient.getDatabase(libraryCode)
  override def getMasterDatabase: MongoDatabase = mongoClient.getDatabase(applicationConf.general.mongodb.masterdb)
}
