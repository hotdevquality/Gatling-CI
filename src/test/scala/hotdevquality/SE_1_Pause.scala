package hotdevquality

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class SE_1_Pause extends Simulation {

	val httpProtocol = http
		.baseUrl("https://cheeze-flight-booker.herokuapp.com")
		.inferHtmlResources()
		.userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36")

	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "en-US,en;q=0.9",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_1 = Map(
		"Accept" -> "*/*",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "en-US,en;q=0.9")

	val headers_2 = Map(
		"Accept" -> "image/webp,image/apng,image/*,*/*;q=0.8",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "en-US,en;q=0.9",
		"Pragma" -> "no-cache")

	val headers_11 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "en-US,en;q=0.9",
		"Origin" -> "https://cheeze-flight-booker.herokuapp.com",
		"Upgrade-Insecure-Requests" -> "1")



	val scn = scenario("SE")

		.exec(http("Homepage")
			.get("/")
			.headers(headers_0)
			.resources(http("request_1")
			.get("/assets/application-2534172286055efef05dbb34d2da8fc2.js")
			.headers(headers_1)))
		.pause(1)
		.exec(http("request_2")
			.get("/favicon.ico")
			.headers(headers_2))
		.pause(44)

		.exec(http("SearchFlight")
			.get("/flights?utf8=%E2%9C%93&from=1&to=2&date=2015-01-03&num_passengers=2&commit=search")
			.headers(headers_0)
			.resources(http("request_4")
			.get("/assets/application-2534172286055efef05dbb34d2da8fc2.js")
			.headers(headers_1),
            http("request_5")
			.get("/assets/application-c99cbb3caf78d16bb1482ca2e41d7a9c.css")))
		.pause(1)
		.exec(http("request_6")
			.get("/favicon.ico"))
		.pause(29)

		.exec(http("SelectFlight")
			.get("/bookings/new?utf8=%E2%9C%93&flight_id=10&commit=Select+Flight&num_passengers=2")
			.headers(headers_0)
			.resources(http("request_8")
			.get("/assets/application-2534172286055efef05dbb34d2da8fc2.js")
			.headers(headers_1),
            http("request_9")
			.get("/assets/application-c99cbb3caf78d16bb1482ca2e41d7a9c.css")))
		.pause(1)
		.exec(http("request_10")
			.get("/favicon.ico"))
		.pause(85)

		.exec(http("BookFlight")
			.post("/bookings")
			.headers(headers_11)
			.formParam("utf8", "✓")
			.formParam("authenticity_token", "y5BbEyinmIG2AmdPPL+tQzyFu4MpAi9oJZSA8pCGNoLGhrnXj5tRicBpFCGFOonY30qYw0egHCFoV9aAfOeaSw==")
			.formParam("booking[flight_id]", "10")
			.formParam("booking[passengers_attributes][0][name]", "Andrew")
			.formParam("booking[passengers_attributes][0][email]", "andrew654@ggmail.com")
			.formParam("booking[passengers_attributes][1][name]", "Scott")
			.formParam("booking[passengers_attributes][1][email]", "scott654@ggmail.com")
			.formParam("commit", "Book Flight"))
		.pause(1)
		.exec(http("request_12")
			.get("/favicon.ico"))

  // FIXED PAUSE
      .pause(10)										// pauses for exactly 10 seconds
      .pause(5000 milliseconds)		// pauses for exactly 5000 milliseconds

  // RANDOM UNIFORM PAUSE
      .pause(10, 20)												// pauses for a duration between 10 and 20 seconds
      .pause(5000, 9000 milliseconds)				// pauses for a duration between 5000 and 9000 milliseconds

  // FORCE PARAMETER - overrides the global pause configuration
      .pause(10, constantPauses)                                     // pauses for exactly 10 seconds irrespective of the global pause configuration
      .pause(10, uniformPausesPlusOrMinusDuration(5))   // on average pauses for 10 seconds and is uniformly distributed over the range 5 and 15 seconds

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)

  // GLOBAL PAUSE CONFIGURATIONS
    .disablePauses													// all the pauses in the scenario would be disabled
    .uniformPauses(10)					// the duration of each pause is on average that specified in the pause(duration) element and follow a uniform distribution.
    .uniformPauses(10.00)				// same as above but the the parameter isn't a constant but instead is a percentage
    .exponentialPauses											// the duration of each pause is on average that specified in the pause(duration) element and follow an exponential distribution
    .constantPauses													// the duration of each pause is precisely that specified in the pause(duration) element


}