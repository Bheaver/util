package com.bheaver.ngl4.util

import java.util

import com.bheaver.ngl4.util.config.ApplicationConf
import com.bheaver.ngl4.util.mongoUtils.{DBConnection, DBConnectionImpl, Database, DatabaseImpl}
import org.springframework.context.annotation.{Bean, Configuration, DependsOn}
import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor

import scala.io.Source

@Configuration
class BasicBeanFactory {
  @Bean(Array("MongoClient"))
  @DependsOn(Array("GeneralConfig"))
  def mongoConnection(applicationConf: ApplicationConf): DBConnection = {
    new DBConnectionImpl(applicationConf)
  }

  @Bean(Array("GeneralConfig"))
  def getApplicationConfig: ApplicationConf = {
    val yaml = new Yaml(new Constructor(classOf[ApplicationConf]))
    val source = Source.fromURL(getClass.getResource("/application.yaml"))
    val applicationConf:ApplicationConf = yaml.load(source.bufferedReader()).asInstanceOf[ApplicationConf]
    applicationConf
  }

  @Bean(Array("Database"))
  @DependsOn(Array("GeneralConfig","MongoClient"))
  def getDatabase(dbConnection: DBConnection,
                  applicationConf: ApplicationConf): Database = {
    new DatabaseImpl(dbConnection.getDBConnection,applicationConf)
  }
}
