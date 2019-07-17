package dynamics

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class PostStringodyDynamicExpression extends Simulation {


  val apiKey = "610caaaa57d440dcaf3ba1a3e61658c0"
  val linkshorten = csv("data/linkshorten.csv").circular
  val title = "mytitle3TTT"
  val slashtag = "somet687ibkj"
  var destination = ""

  //Create http configuration
  val httpProtocol = http.baseUrl("https://api.rebrandly.com").header("apiKey", apiKey)


  val scn = scenario("CreateLink")
  .feed(linkshorten)
    .exec(session => {
      destination = session("destination").as[String]
      println(s"""{"destination":"$destination","slashtag":"$slashtag","title":"$title"}""")
      session
    })
    .exec(http("createnewlink")
      .post("/v1/links")
      .body(StringBody( session=> s"""{"destination":"$destination","slashtag":"$slashtag","title":"$title"}"""))) //send post request

  //inject user to send http request
  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol) //inject one user
}
