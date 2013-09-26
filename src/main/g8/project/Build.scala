import sbt._
import Keys._

object BuildSettings {
  val buildSettings = Defaults.defaultSettings ++ Seq(
    organization := "$organization$",
    version := "$version$",
    scalaVersion := "2.10.2",
    scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature", "-encoding", "utf8")
  )
}

object Dependencies {
  val akkaActor = "com.typesafe.akka"   %%  "akka-actor"        % "2.2.0-RC1"
  val akkaSlf4j = "com.typesafe.akka"   %%  "akka-slf4j"        % "2.2.0-RC1"
  val akkaTestkit = "com.typesafe.akka"   %%  "akka-testkit"      % "2.2.0-RC1" % "test"
  val scalaLogging = "com.typesafe"        %% "scalalogging-slf4j" % "1.0.1"
  val logback = "ch.qos.logback" % "logback-classic" % "1.0.13"
  val scalatest = "org.scalatest"       %% "scalatest"          % "2.0.M8" % "test"
  val pegdown = "org.pegdown" % "pegdown" % "1.0.1" % "test"
  val mockito = "org.mockito"         % "mockito-core"        % "1.9.5" % "test"

  val commonDeps = Seq(
    akkaActor,
    akkaSlf4j,
    akkaTestkit,
    scalaLogging,
    logback,
    scalatest,
    pegdown,
    mockito
  )
}

object $name;format="Camel"$Build extends Build {

  import BuildSettings.buildSettings
  import Dependencies.commonDeps
  import org.scalastyle.sbt.ScalastylePlugin.{Settings => ScalastyleSettings}
  import ScctPlugin.instrumentSettings

  lazy val root = Project("$name;format="normalize"$",
			  file("."),
                          settings = buildSettings ++ instrumentSettings ++ ScalastyleSettings) settings (
                    libraryDependencies ++= commonDeps,
                    testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/report", "-o"))
}
