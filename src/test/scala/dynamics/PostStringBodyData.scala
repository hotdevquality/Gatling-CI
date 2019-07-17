package dynamics

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class PostStringBodyData extends Simulation {

  //Create http configuration
  val httpProtocol = http
    .baseUrl("https://api.rebrandly.com/v1")
    .header("apiKey", "610caaaa57d440dcaf3ba1a3e61658c0")


  val scn = scenario("CreateLink")
    .exec(http("createnewlink")
      .post("/links")
      .body(StringBody("""{"destination":"http://www.hotdevquality.com/test-automation/","slashtag":"samplePostTag","title":"$sptag"}""")).asJson) //send post request

  //inject user to send http request
  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol) //inject one user
}
