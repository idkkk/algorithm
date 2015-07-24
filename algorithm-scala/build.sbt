name := "algorithm-scala"

version := "1.0"

scalaVersion := "2.11.2"

resolvers ++= Seq("repo" at "http://repo.typesafe.com/typesafe/releases/")

libraryDependencies ++= {
  Seq(
    "org.scalatest" %% "scalatest" % "2.2.4"
  )
}