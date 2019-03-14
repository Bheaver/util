package com.bheaver.ngl4.util.config

import java.util

import org.springframework.boot.context.properties.{ConfigurationProperties, EnableConfigurationProperties}
import org.springframework.context.annotation.Configuration

import scala.beans.BeanProperty

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
class ApplicationConf{
  @BeanProperty
  var general: General = null
}

class General{
  @BeanProperty
  var mongodb: MongoDB = null
}

class MongoDB{
  @BeanProperty
  var servers: util.List[Server] = null
  @BeanProperty
  var masterdb: String = null
}

class Server{
  @BeanProperty
  var ip: String = null
  @BeanProperty
  var port: Int = 0
}