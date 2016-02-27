name              := "ShapeInterpolator"
organization      := "de.sciss"
version           := "0.1.0-SNAPSHOT"
scalaVersion      := "2.11.7"  // not used
licenses          := Seq("GPL v2 with class path exception" -> url("http://openjdk.java.net/legal/gplv2+ce.html"))
crossPaths        := false
autoScalaLibrary  := false
homepage          := Some(url(s"https://github.com/Sciss/${name.value}"))
description       := "Java2D Shape Interpolator"

lazy val commonJavaOptions = Seq("-source", "1.6")

javacOptions        := commonJavaOptions ++ Seq("-target", "1.6", "-g", "-Xlint:deprecation")

javacOptions in doc := commonJavaOptions  // cf. sbt issue #355

// ---- publishing to Maven Central ----
publishMavenStyle := true

publishTo := Some(
  if (isSnapshot.value)
    "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
  else
    "Sonatype Releases"  at "https://oss.sonatype.org/service/local/staging/deploy/maven2"
)

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := { val n = name.value
  <scm>
    <url>git@github.com:Sciss/{n}.git</url>
    <connection>scm:git:git@github.com:Sciss/{n}.git</connection>
  </scm>
  <developers>
    <developer>
      <id>sciss</id>
      <name>Hanns Holger Rutz</name>
      <url>http://www.sciss.de</url>
    </developer>
  </developers>
}
