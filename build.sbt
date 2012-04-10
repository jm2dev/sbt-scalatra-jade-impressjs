organization := "com.jm2dev"

name := "sbt-xslt-scalatra"

version := "0.0.1"
                           
scalaVersion := "2.9.1"

seq(webSettings :_*)

seq(com.zentrope.ScalatePlugin.scalateTemplateSettings : _*)

scalateTemplateDirectories in Compile <<= (scalateTemplateDirectories in Compile, baseDirectory) {
  (dirs, basedir) =>
    dirs ++ Seq(new File(basedir, "/src/main/webapp/WEB-INF/scalate"))
}

libraryDependencies ++= Seq(
                    "org.scalatra" %% "scalatra" % "2.0.4",
                    "org.scalatra" %% "scalatra-scalate" % "2.0.4",
                    "org.scalatra" %% "scalatra-scalatest" % "2.0.4" % "test",
                    "org.scalatest" %% "scalatest" % "1.7.1" % "test",
                    "org.eclipse.jetty" % "jetty-webapp" % "8.1.0.RC5" % "container",
                    "org.slf4j" % "slf4j-simple" % "1.6.1" % "runtime",
                    "javax.servlet" % "servlet-api" % "2.5" % "provided"
)

resolvers += "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"
