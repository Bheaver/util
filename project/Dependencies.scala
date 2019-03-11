import sbt._

object Versions {
  val springWebFluxVersion = "5.1.4.RELEASE"
  val mongoReactiveStreams = "1.10.0"
  val reactiveStreams = "1.0.2"
  val mongoDriverVersion = "3.9.1"
  val snakeYamlVersion = "1.24"
}

object Dependencies {

  val springWebFlux = "org.springframework" % "spring-webflux" % Versions.springWebFluxVersion
  val springContext = "org.springframework" % "spring-context" % Versions.springWebFluxVersion

  val reactiveMongoStreams = "org.mongodb" % "mongodb-driver-reactivestreams" % Versions.mongoReactiveStreams
  val mongoAsyncCore = "org.mongodb" % "mongodb-driver-async" % Versions.mongoDriverVersion
  val reactiveStreams = "org.reactivestreams" % "reactive-streams" % Versions.reactiveStreams
  val mongoJavaDriver = "org.mongodb" % "mongo-java-driver" % Versions.mongoDriverVersion

  val snakeYaml= "org.yaml" % "snakeyaml" % Versions.snakeYamlVersion

  val coreDependencies = Seq(springWebFlux, reactiveMongoStreams,mongoAsyncCore,reactiveStreams,mongoJavaDriver, springContext, snakeYaml)

}