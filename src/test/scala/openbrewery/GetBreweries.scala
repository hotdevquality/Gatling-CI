package openbrewery

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class GetBreweries extends Simulation {

  val httpConfig = http
    .baseUrl("https://api.openbrewerydb.org")

  val scn = scenario("GetBreweries")
    .exec(http("GetBreweries")
      .get("/breweries"))

  setUp(scn.inject(atOnceUsers(1))).protocols(httpConfig)


}
