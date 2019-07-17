package sessionmanagement

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class GetHotelDetails extends Simulation {

  val httpConf = http.baseUrl("http://developer.goibibo.com")

  val appId = "796bdc4e" //"701491b9"
  val appKey = "694b0a0f930576bf40d4aa4d14c69ed0" //"a33c1f63da644e3ce7ba565599809d0f"
  val hotelcsvFeeder = csv("data/HotelRequestDataFile.csv").circular

  val scn = scenario("HotelDetails").feed(hotelcsvFeeder)
    .exec(http("getHotelList")
      .get("/api/voyager/get_hotels_by_cityid/?app_id=" + appId + "&app_key=" + appKey + "&city_id=${CityId}")
      .check(jsonPath("$.data..hotel_geo_node._id").find.saveAs("hotelId")))
    .exec(session => {
      val hotelId = session("hotelId").as[String]
      println(hotelId)
      session
    })
      .exec(http("Details of Given Hotels")
      .get("/api/voyager/?app_id="+ appId +"&app_key="+ appKey +"&method=hotels.get_hotels_data&id_list=[${hotelId}]&id_type=_id")
      .check(bodyString.saveAs("responseBody")))
      .exec(session => {
        println(session("responseBody").as[String])
        session
      })


  setUp(scn.inject(atOnceUsers(1))).protocols(httpConf)
    .uniformPauses(30)
}


