package dynamics

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class PostELFileBodyDynamicData extends Simulation {


  val apiKey = "610caaaa57d440dcaf3ba1a3e61658c0" //"9d02943b6f854cd893ea667e6a5a40ac"
  val linkshorten = csv("data/linkshorten.csv").circular //this csv is stored at data folder
  val title = "mytitle2" //keep it as it is and add to session as attribute using set method

  //Create http configuration
  val httpProtocol = http.baseUrl("https://api.rebrandly.com").header("apiKey", apiKey)


  val scn = scenario("CreateLink").exec(session => {
    //set title as session attribute
    session.set("title", title)
  }).feed(linkshorten)
    .exec(http("createnewlink")
      .post("/v1/links")
      .body(StringBody("""{"destination":"${destination}","slashtag":"${slashtag}","title":"${title}"}""")).asJson) //send post request

  //inject user to send http request
  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol) //inject one user
}
