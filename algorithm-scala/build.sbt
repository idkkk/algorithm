name := "algorithm-scala"

version := "1.0"

scalaVersion := "2.11.2"

crossScalaVersions := Seq("2.11.2", "2.10.4")

resolvers ++= Seq("repo" at "http://repo.typesafe.com/typesafe/releases/")

libraryDependencies ++= {
  Seq(
    "org.scalatest" %% "scalatest" % "2.2.4",
    "com.google.guava" % "guava" % "18.0"
  )
}
