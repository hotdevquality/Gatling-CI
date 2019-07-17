package sessionmanagement

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class GetMultipleHotelDetails extends Simulation {

  val httpConf = http.baseUrl("http://developer.goibibo.com")

  val appId = "796bdc4e"
  val appKey = "694b0a0f930576bf40d4aa4d14c69ed0"
  val hotelcsvFeeder = csv("data/HotelRequestDataFile.csv").circular

  val scn = scenario("HotelDetails").feed(hotelcsvFeeder)
    .exec(http("Get Hotel List")
      .get("/api/voyager/get_hotels_by_cityid/?app_id=" + appId + "&app_key=" + appKey + "&city_id=${CityId}")
      .check(jsonPath("$.data..hotel_geo_node._id").findAll.saveAs("hotelIds")))

    .exec(session => {
      println(session("hotelIds").as[String])
      val hotelIds = session("hotelIds").as[Vector[String ]]
      var hotelId1 = hotelIds(0)
      var hotelId2 = hotelIds(1)

      println(hotelId1)
      println(hotelId2)

      session
        .set("hotelId1",hotelId1)
        .set("hotelId2", hotelId2)
    })

    .exec(http("Get Multiple Hotel Details")
      .get("/api/voyager/?app_id=" + appId + "&app_key=" + appKey + "&method=hotels.get_hotels_data&id_list=%5B${hotelId1}%2C${hotelId2}%5B&id_type=_id")
      .check(bodyString.saveAs("responseBody")))
    .exec(session => {
      println(session("responseBody").as[String])
      session
    })

  setUp(scn.inject(atOnceUsers(1))).protocols(httpConf)
    .uniformPauses(40)
}
