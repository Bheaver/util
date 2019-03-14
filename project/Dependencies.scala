import sbt._

object Versions {
  val springWebFluxVersion = "5.1.4.RELEASE"
  val mongoReactiveStreams = "1.10.0"
  val reactiveStreams = "1.0.2"
  val mongoDriverVersion = "3.9.1"
  val snakeYamlVersion = "1.24"
  val log4j2Version = "2.11.2"
  val log4j2ScalaAPIVersion = "11.0"
}

object Dependencies {

  val springWebFlux = "org.springframework" % "spring-webflux" % Versions.springWebFluxVersion
  val springContext = "org.springframework" % "spring-context" % Versions.springWebFluxVersion

  val reactiveMongoStreams = "org.mongodb" % "mongodb-driver-reactivestreams" % Versions.mongoReactiveStreams
  val mongoAsyncCore = "org.mongodb" % "mongodb-driver-async" % Versions.mongoDriverVersion
  val reactiveStreams = "org.reactivestreams" % "reactive-streams" % Versions.reactiveStreams
  val mongoJavaDriver = "org.mongodb" % "mongo-java-driver" % Versions.mongoDriverVersion

  val snakeYaml= "org.yaml" % "snakeyaml" % Versions.snakeYamlVersion

  val log4j2ScalaAPI = "org.apache.logging.log4j" %% "log4j-api-scala" % Versions.log4j2ScalaAPIVersion
  val log4j2Core = "org.apache.logging.log4j" % "log4j-core" % Versions.log4j2Version
  val log4j2API = "org.apache.logging.log4j" % "log4j-api" % Versions.log4j2Version

  val coreDependencies = Seq(springWebFlux, reactiveMongoStreams,mongoAsyncCore,reactiveStreams,mongoJavaDriver, springContext, snakeYaml, log4j2API,log4j2Core,log4j2ScalaAPI)

}