package serverSideEvent

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class SSE_Example1 extends Simulation {

  val check_1 = sse.checkMessage("id_check").check(jsonPath("$.id").find.saveAs("id"))
  val check_2 = sse.checkMessage("data_check").check(jsonPath("$.data").find.saveAs("data"))

  val httpConfig = http.baseUrl("http://demo.howopensource.com")
    .acceptHeader("ext/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
    .inferHtmlResources()
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-GB,en-US;q=0.9,en;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Gatling")
    .upgradeInsecureRequestsHeader("1")

  val scn = scenario("SSE Scenario")
    .exec(sse("sse_req").connect("/sse/stocks.php")
      .await(50)(sse.checkMessage("check connections")
//        .check(regex(".*.*").saveAs("responseMessage"))))
        .check(regex(".*.*").exists)))
//    .exec(session => {
//      println(session("responseMessage").as[String])
//      session
//    })
    .pause(5 seconds)

    .repeat(2) {
      exec(sse("setCheckPoint").setCheck.await(50 seconds)(check_1, check_2))
        // print each extracted value
        .exec(session => {
        println("ID is:: " + session("id").as[String])
        println("DATA is:: " + session("data").as[String])
        session
      })
    }
    .exec(sse("sse_close").close())

  setUp(scn.inject(atOnceUsers(1))).protocols(httpConfig)

}
