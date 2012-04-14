package com.jm2dev.web

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.{ServletHolder, DefaultServlet, ServletContextHandler}

object MyScalatraApp {
  def main(args: Array[String]) {
    val server = new Server(9091)
    val context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.setContextPath("/")
    context.addServlet(classOf[MyScalatraServlet], "/*")
    context.addServlet(new ServletHolder(new MyDefaultServlet), "/css/*")
    context.addServlet(new ServletHolder(new MyDefaultServlet), "/images/*")
    context.addServlet(new ServletHolder(new MyDefaultServlet), "/js/*")

    server.setHandler(context)

    server.start
    server.join
  }
}
