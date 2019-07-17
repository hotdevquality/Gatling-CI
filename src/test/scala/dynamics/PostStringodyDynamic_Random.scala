package dynamics

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.util.Random

class PostStringodyDynamic_Random extends Simulation {


  val apiKey = "610caaaa57d440dcaf3ba1a3e61658c0"
  val linkshorten = csv("data/linkshorten.csv").circular
  var title = ""
  var slashtag = ""
  var destination = ""
  def RandomString = Random.alphanumeric.take(4).mkString

  //Create http configuration
  val httpProtocol = http.baseUrl("https://api.rebrandly.com").header("apiKey", apiKey)


  val scn = scenario("CreateLink").repeat(2) {
    feed(linkshorten)
      .exec(session => {
        destination = session("destination").as[String]
        slashtag = s"slashtag_$RandomString"
        title = s"title_$RandomString"
        println(s"""{"destination":"$destination","slashtag":"$slashtag","title":"$title"}""")
        session
      })
      .exec(http("createnewlink")
        .post("/v1/links")
        .body(StringBody(session => s"""{"destination":"$destination","slashtag":"$slashtag","title":"$title"}"""))) //send post request
  }
  //inject user to send http request
  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol) //inject one user
}
//      slashtag = s"slashtag + ${Random.alphanumeric.take(4).mkString}"
//      title = s"title ${Random.alphanumeric.take(4).mkString}"