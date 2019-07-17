package openModels

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class SimpleGetScript1 extends Simulation {

  val httpConfig = http.baseUrl("http://newtours.demoaut.com")

  val scn = scenario("Basic Open Model")
    .exec(http("Basic Open Model").get("/mercurycruise.php"))

  //1.  5 users arrive during 5 minutes
  setUp(scn.inject(rampUsers(5) during (5 seconds))).protocols(httpConfig)

}
