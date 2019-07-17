package sessionmanagement

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class GetBusDetailsSubsequenceRequest extends Simulation {

  val httpConfig = http
    .baseUrl("http://developer.goibibo.com/api")

  val appId = "796bdc4e"
  val appKey = "694b0a0f930576bf40d4aa4d14c69ed0"
  val depatDate = "20190730"

  val csvFeederBusDetails = csv("data/busSearch.csv").circular


  val scn = scenario("Bus Search").feed(csvFeederBusDetails)
    .exec(http("BusSearch")
    .get("http://developer.goibibo.com/api/bus/search/?app_id="+appId+"&app_key="+appKey+"&format=json&source=${source}&destination=${destination}&dateofdeparture="+depatDate+"")
    .check(jsonPath("$.data..skey").findAll.saveAs("searchKey")))
    .exec(http("Bus SeatMap Layout")
    .get("/api/bus/seatmap/?app_id="+appId+"&app_key="+appKey+"&format=json&skey=${searchKey}")
    .check(bodyString.saveAs("responseBody")))
    .exec(session => {
      val searchVal = session("responseBody")
      println(searchVal.as[String])
      println(searchVal.asOption[String])
      println(searchVal.validate[String])
      session
    })


  setUp(scn.inject(atOnceUsers(1)))protocols(httpConfig)

}
