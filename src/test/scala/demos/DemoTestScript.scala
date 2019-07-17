package demos

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class DemoTestScript extends Simulation {

  // HTTP Protocol configuration
  val httpProtocol = http.baseUrl("http://newtours.demoaut.com/")
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .contentTypeHeader("")
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.9")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  //  // Header definition
  //  val header_1 = Map
  //  (
  //    "accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8",
  //    "accept-encoding" -> "gzip, deflate, br",
  //    "accept-language" -> "en-US,en;q=0.5"
  //  )

  // Scenario Definition
  val scn = scenario(scenarioName = "viewCruises")
    .exec(http(requestName = "request_1").get("/mercurycruise.php")).pause(duration = 10)

  // Sceenario Definition
  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)

}
