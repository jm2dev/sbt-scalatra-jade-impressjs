import AssemblyKeys._ // put this at the top of the file

organization := "com.jm2dev"

name := "sbt-xslt-scalatra"

version := "0.1.2"

scalaVersion := "2.9.1"

//seq(webSettings :_*)

seq(com.zentrope.ScalatePlugin.scalateTemplateSettings : _*)

assemblySettings

scalateTemplateDirectories in Compile <<= (scalateTemplateDirectories in Compile, baseDirectory) {
  (dirs, basedir) =>
    dirs ++ Seq(new File(basedir, "/src/main/webapp/WEB-INF/scalate"))
}

resourceGenerators in Compile <+= (resourceManaged, baseDirectory) map { (managedBase, base) =>
  val webappBase = base / "src" / "main" / "webapp"
  for {
    (from, to) <- webappBase ** "*" x rebase(webappBase, managedBase / "main/" )
  } yield {
    Sync.copy(from, to)
    to
  }
}

libraryDependencies ++= Seq(
                    "org.scalatra" %% "scalatra" % "2.1.0-SNAPSHOT",
                    "org.scalatra" %% "scalatra-scalate" % "2.1.0-SNAPSHOT",
                    "org.scalatra" %% "scalatra-scalatest" % "2.1.0-SNAPSHOT" % "test",
                    "org.scalatest" %% "scalatest" % "1.7.1" % "test",
                    "org.eclipse.jetty" % "jetty-webapp" % "8.1.0.RC5",
                    "org.slf4j" % "slf4j-simple" % "1.6.1" % "runtime",
                    "javax.servlet" % "servlet-api" % "2.5" % "provided"
)

resolvers += "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"
