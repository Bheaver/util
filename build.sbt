import Dependencies._

lazy val root = (project in file("."))
  .settings(
    name := "util",
    scalaVersion := "2.12.8",
    organization := "com.bheaver.ngl4",
    version := "0.0.1-SNAPSHOT",
    libraryDependencies ++= coreDependencies
  )