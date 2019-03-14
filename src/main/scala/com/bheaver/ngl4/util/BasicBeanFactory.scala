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
  @DependsOn(Array("GeneralConfig"))
  def mongoConnection(applicationConf: ApplicationConf): DBConnection = {
    new DBConnectionImpl(applicationConf)
  }

  @Bean(Array("GeneralConfig"))
  @DependsOn(Array("ApplicationYAMLString"))
  def getApplicationConfig(lines: String): ApplicationConf = {
    val yaml = new Yaml(new Constructor(classOf[ApplicationConf]))
    //val applicationConf:ApplicationConf = yaml.load(new FileReader("/home/siddartha/scalaworkspace/authenticationAuthorization/src/main/resources/application.yaml")).asInstanceOf[ApplicationConf]
    //lines.toArray.mkString("\n")
    //applicationConf
    yaml.load(lines).asInstanceOf[ApplicationConf]
  }

  @Bean(Array("Database"))
  @DependsOn(Array("GeneralConfig","MongoClient"))
  def getDatabase(dbConnection: DBConnection,
                  applicationConf: ApplicationConf): Database = {
    new DatabaseImpl(dbConnection.getDBConnection,applicationConf)
  }
}
