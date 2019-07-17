package openModels

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class SimpleGetScript3 extends Simulation {

  val httpConfig = http.baseUrl("http://newtours.demoaut.com")

  val scn = scenario("Basic Open Model")
    .repeat(4) {
      pace(2)
        .exec(http("Basic Open Model").get("/mercurycruise.php"))

    }
  setUp(scn.inject(rampUsers(5) during (5 seconds))).protocols(httpConfig)
  // 5 users arrive during 5 minutes
  // All the users run for 40 seconds
  // Each user runs with a time interval of 2 seconds in each iteration


}
