import play.Project._

name := """meetingDataExchangeServer"""

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
	"org.webjars" %% "webjars-play" % "2.2.0", 
	"org.webjars" % "bootstrap" % "2.3.1",
	"com.typesafe" %% "play-plugins-mailer" % "2.1.0",
	jdbc
	)

playJavaSettings
