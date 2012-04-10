package com.jm2dev.web

import org.scalatra.ScalatraServlet
import org.scalatra.scalate.ScalateSupport

class MyScalatraServlet extends ScalatraServlet
  with ScalateSupport
{

  get("/") {
    contentType = "text/html"
    templateEngine.layout("/WEB-INF/scalate/views/home.jade")
  }

  notFound {
    response.sendError(404)
  }
}
