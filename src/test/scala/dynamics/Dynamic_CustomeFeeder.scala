package dynamics

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.util.Random

class Dynamic_CustomeFeeder extends Simulation {


  val apiKey = "610caaaa57d440dcaf3ba1a3e61658c0"
  val linkshorten = csv("data/linkshorten2Updated.csv").circular

  def RandomString = Random.alphanumeric.take(4).mkString

  var randomString = Iterator.continually(Map(
    "slashtag" -> s"mys$RandomString",
    "title" -> s"myt$RandomString")
  )

  //Create http configuration
  val httpProtocol = http.baseUrl("https://api.rebrandly.com/v1").header("apiKey", apiKey)


  val scn = scenario("CreateLink").repeat(2) {
    feed(linkshorten).feed(randomString)
      .exec(session => {
        println(session("destination").as[String])
        println(session("slashtag").as[String])
        println(session("title").as[String])
        session
      })
      .exec(http("createnewlink")
        .post("/links")
        .body(StringBody("""{"destination":"${destination}","slashtag":"${slashtag}","title":"${title}"}"""))) //send post request
  }
  //inject user to send http request
  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol) //inject one user
}
