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

  @BeanProperty
  var jwt: JWT = null
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

class JWT{
  @BeanProperty
  var keyId: String = null
  @BeanProperty
  var issuer: String = null
  @BeanProperty
  var audience: String = null
  @BeanProperty
  var expirationTimeInMins: Int = 0
  @BeanProperty
  var subject: String = null
  @BeanProperty
  var email: String = null
}