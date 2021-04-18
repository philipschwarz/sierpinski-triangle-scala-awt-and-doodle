val scala3Version = "3.0.0-RC2"
//scalaVersion := "2.13.4" // Doodle is currently published for Scala 2.13

// Determine OS version of JavaFX binaries
lazy val osName = System.getProperty("os.name") match {
  case n if n.startsWith("Linux")   => "linux"
  case n if n.startsWith("Mac")     => "mac"
  case n if n.startsWith("Windows") => "win"
  case _ => throw new Exception("Unknown platform!")
}

// Add dependency on JavaFX libraries, OS dependent
lazy val javaFXModules = Seq("base", "controls", "fxml", "graphics", "media", "swing", "web")
libraryDependencies ++= javaFXModules.map( m =>
  "org.openjfx" % s"javafx-$m" % "15.0.1" classifier osName
)

lazy val root = project
  .in(file("."))
  .settings(
    name := "scala3-simple",
    version := "0.1.0",

    scalaVersion := scala3Version,

    libraryDependencies += ("org.creativescala" %% "doodle" % "0.9.23").cross(CrossVersion.for3Use2_13),
    libraryDependencies += ("org.scalafx" %% "scalafx" % "15.0.1-R21").cross(CrossVersion.for3Use2_13),
    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"
  )
