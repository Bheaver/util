package com.bheaver.ngl4.util.mongoUtils

import com.mongodb.reactivestreams.client.{MongoClient, MongoDatabase}

trait Database {
  def getDatabase: MongoDatabase
}

class DatabaseImpl(mongoClient: MongoClient, libraryCode: String) extends Database {
  override def getDatabase: MongoDatabase = mongoClient.getDatabase(libraryCode)
}

object DatabaseImpl {
  def apply(mongoClient: MongoClient, libraryCode: String): MongoDatabase = {
    val databaseImpl = new DatabaseImpl(mongoClient, libraryCode)
    databaseImpl.getDatabase
  }

}