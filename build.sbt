name := "vehicletax"

version := "1.0.0"

scalaVersion := "2.11.7"

lazy val vehicletax = (project in file(".")).enablePlugins(PlayScala)


libraryDependencies ++= {
  Seq(
    ws,
    jdbc,
    evolutions,
    "com.typesafe.play" %% "anorm" % "2.4.0",
    "org.scala-lang" % "scala-library" % scalaVersion.value,
    "org.slf4j" % "slf4j-api" % "1.7.2",
    "ch.qos.logback" % "logback-classic" % "1.1.3",
    "org.scalatest" %% "scalatest" % "2.2.1",
    "org.scalatestplus" %% "play" % "1.4.0-M3" % Test
  )
}