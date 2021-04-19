import sbt.Keys.libraryDependencies

lazy val rootProject = (project in file(".")).settings(
  organization := "ShutTheBox",
  name := "de.htwg.se.shutthebox",
  version := "1.0",
  scalaVersion := "2.12.12",
  libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5",
  libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test",
  libraryDependencies += "org.scala-lang.modules" % "scala-swing_2.12" % "2.0.3",
  libraryDependencies += "com.google.inject" % "guice" % "4.1.0",
  libraryDependencies += "net.codingwell" %% "scala-guice" % "4.2.6",
  libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "1.3.0",
  libraryDependencies += "com.typesafe.play" %% "play-json" % "2.7.1",
  libraryDependencies += "com.typesafe.akka" %% "akka-actor-typed" % "2.6.8",
  libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.6.8",
  libraryDependencies += "com.typesafe.akka" %% "akka-http" % "10.2.4"
).dependsOn(FileIO, Field)

lazy val FileIO = project in file("FileIO")
lazy val Field = project in file("Field")