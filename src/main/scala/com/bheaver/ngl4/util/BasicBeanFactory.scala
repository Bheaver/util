package com.bheaver.ngl4.util

import java.io.{FileReader}


import com.bheaver.ngl4.util.config.ApplicationConf
import com.bheaver.ngl4.util.mongoUtils.{DBConnection, DBConnectionImpl, Database, DatabaseImpl}
import org.springframework.context.annotation.{Bean, Configuration, DependsOn}
import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor

import scala.io.Source

@Configuration
class BasicBeanFactory {
  @Bean(Array("MongoClient"))
  def mongoConnection(applicationConf: ApplicationConf): DBConnection = {
    new DBConnectionImpl(applicationConf)
  }

  @Bean(Array("Database"))
  @DependsOn(Array("MongoClient"))
  def getDatabase(dbConnection: DBConnection,
                  applicationConf: ApplicationConf): Database = {
    new DatabaseImpl(dbConnection.getDBConnection,applicationConf)
  }
}
