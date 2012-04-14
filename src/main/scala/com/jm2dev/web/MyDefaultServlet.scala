package com.jm2dev.web

import org.eclipse.jetty.servlet.DefaultServlet
import org.eclipse.jetty.util.resource.Resource
import java.net.URL

// http://blog.valotas.com/2009/10/jetty-defaultservlet-on-osgi.html
class MyDefaultServlet extends DefaultServlet
{
  override def getResource(resourceString: String): Resource =
  {
    val url = this.getClass().getResource(resourceString)
    Resource.newResource(url)
  }
}
