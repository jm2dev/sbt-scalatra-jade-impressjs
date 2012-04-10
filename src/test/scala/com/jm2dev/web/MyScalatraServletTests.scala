package com.jm2dev.web

import org.scalatra.test.scalatest.ScalatraSuite
import org.scalatest.FunSuite

class MyScalatraServletTests extends ScalatraSuite
  with FunSuite
{
  addServlet(classOf[MyScalatraServlet], "/*")

  test("home page") {
    get("/") {
      status should be(200)
    }
  }
}
