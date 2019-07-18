package sessionmanagement

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class GetBusDetails extends Simulation {

  val httpConfig = http
    .baseUrl("http://developer.goibibo.com/api")

  val appId = "796bdc4e"
  val appKey = "694b0a0f930576bf40d4aa4d14c69ed0"
  //  val appKey = "694b0a0f930576bf40d4aa4d14c69e"
  //  val source = "London"
  //  val dest = "Manchester"
  val depatDate = "20190730"

  val csvFeederBusDetails = csv("data/busSearch.csv").circular


  val scn = scenario("Bus Search").feed(csvFeederBusDetails)
    .exec(http("BusSearch")
      .get("http://developer.goibibo.com/api/bus/search/?app_id=" + appId + "&app_key=" + appKey + "&format=json&source=${source}&destination=${destination}&dateofdeparture=" + depatDate + "")
      //        .check(jsonPath("$.data..skey").findAll.saveAs("searchKey")))
      .check(jsonPath("$.data..skey").find.saveAs("searchKey")))
  //    .check(jsonPath("$.data..skey").find(2).saveAs("searchKey")))
  // $.data.[0].skey // $.data.onwardflights[0].skey //return first index
  // $.data..skey // returns all occurrence
  //      .exec(session => {
  //          println(session)
  //          session
  //      })

  //    .exec(session => {
  //    val searchVal = session("searchKey")
  //    println(searchVal.as[String])
  //    println(searchVal.asOption[String])
  //    println(searchVal.validate[String])
  //    session
  //  })

  //  setUp(scn.inject(atOnceUsers(2))) protocols (httpConfig)
  setUp(scn.inject(atOnceUsers(2)).protocols(httpConfig))
    .assertions(
      global.responseTime.max.lt(50),
      //      global.successfulRequests.percent.gt(95)
      global.successfulRequests.percent.is(100)
    )
}
