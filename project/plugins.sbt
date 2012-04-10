resolvers ++= Seq (
    "sbt-idea-repo" at "http://mpeltonen.github.com/maven/",
    "zentrope" at "http://zentrope.com/maven"
)

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "0.11.0")

addSbtPlugin("com.zentrope" %% "xsbt-scalate-precompile-plugin" % "1.7")

//http://wiki.eclipse.org/Jetty/Tutorial/Embedding_Jetty
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.7.2")

libraryDependencies <+= sbtVersion(v => "com.github.siasia" %% "xsbt-web-plugin" % (v+"-0.2.8"))

resolvers +=
  Resolver.url("heikoseeberger", new URL("http://hseeberger.github.com/releases"))(Resolver.ivyStylePatterns)



