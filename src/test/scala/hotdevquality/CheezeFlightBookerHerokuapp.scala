package hotdevquality

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class CheezeFlightBookerHerokuapp extends Simulation {

	val httpProtocol = http

		.baseUrl("https://cheeze-flight-booker.herokuapp.com")
		.inferHtmlResources()
		.acceptHeader("image/webp,image/apng,image/*,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-GB,en-US;q=0.9,en;q=0.8")
		.userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Safari/537.36")
  	//.silentResources
  	//.connectionHeader("keep-alive")
//  	.silentUri(".*bookings") // to silent the particular failing url
//		.proxy(Proxy("something.net", 8080))

	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3",
		"Pragma" -> "no-cache",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_1 = Map(
		"Accept" -> "text/css,*/*;q=0.1",
		"Pragma" -> "no-cache")

	val headers_2 = Map(
		"Accept" -> "*/*",
		"Pragma" -> "no-cache")

	val headers_3 = Map("Pragma" -> "no-cache")

	val headers_12 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3",
		"Origin" -> "https://cheeze-flight-booker.herokuapp.com",
		"Pragma" -> "no-cache",
		"Upgrade-Insecure-Requests" -> "1")

	var Responde_name = "something"


	val scn = scenario("CheezeFlightBookerHerokuapp")
  	.exec(flushHttpCache)
  	.exec(flushSessionCookies)
  	.exec(flushCookieJar)

		.exec(
			http("homepage")
			.get("/")
			.headers(headers_0).notSilent // NOT SILENT
//  	.body(RawFileBody("filePath"))

			.resources(http("request_1")
			.get("/assets/application-c99cbb3caf78d16bb1482ca2e41d7a9c.css")
			.headers(headers_1)
			.check(status.in(200, 201, 202, 304))
			.check(status.not(404)),

			http("request_2")
			.get("/assets/application-2534172286055efef05dbb34d2da8fc2.js")
			.headers(headers_2),

			http("request_3")
			.get("/favicon.ico")
			.headers(headers_3)))
			.pause(30)

		.exec(http("search_flight")
			.get("/flights?utf8=%E2%9C%93&from=2&to=4&date=2015-01-05&num_passengers=2&commit=search")
			.headers(headers_0)
			.resources(http("request_5")
			.get("/assets/application-c99cbb3caf78d16bb1482ca2e41d7a9c.css")
  				.check(currentLocationRegex(".*num_passengers=2.*"))
			.headers(headers_1),

				http("request_6")
			.get("/assets/application-2534172286055efef05dbb34d2da8fc2.js")
			.headers(headers_2),

			http("request_7")
			.get("/favicon.ico")
			.headers(headers_3)))
			.pause(15)

		.exec(
			http("select_flight")
			.get("/bookings/new?utf8=%E2%9C%93&flight_id=85&commit=Select+Flight&num_passengers=2")
			.headers(headers_0)
			.resources(http("request_9")
			.get("/assets/application-c99cbb3caf78d16bb1482ca2e41d7a9c.css")
  				.check(css("h1:contains('Book Flight')").exists)
  				.check(substring("Email").find.exists)
  				.check(substring("Email").count.is(2))
					.check(css("input[name='authenticity_token']", "value").saveAs("authToken"))
				  .check(bodyString.saveAs("BODY"))
			.headers(headers_1),

				http("request_10")
			.get("/assets/application-2534172286055efef05dbb34d2da8fc2.js")
			.headers(headers_2),

				http("request_11")
			.get("/favicon.ico")
			.headers(headers_3)))
		.exec { session =>
			println("Response Body: ")
			println(session("BODY").as[String])
			session
		}
		.pause(79)

		.exec(
			http("book_flight")
			.post("/bookings")
			.headers(headers_12)
//				.body(StringBody("""{ "name": "MyName","pass":$headers_1 }""")).asJson
			.formParam("utf8", "✓")
			.formParam("authenticity_token", "${authToken}")
			.formParam("booking[flight_id]", "85")
			.formParam("booking[passengers_attributes][0][name]", "Kingsley Marcus")
			.formParam("booking[passengers_attributes][0][email]", "kinsleymarcus@gmail.com")
			.formParam("booking[passengers_attributes][1][name]", "John Lowe")
			.formParam("booking[passengers_attributes][1][email]", "johnlowe@yahoo.com")
			.formParam("commit", "Book Flight")
  			.check(bodyString.saveAs({Responde_name}))
			.resources(http("request_13")
			.get("/favicon.ico")
			.headers(headers_3)))

//	// FIXED PAUSE
//  		.pause(10) // 10 seconds
//  		.pause(5000 milliseconds)
//
//	// RANDOM UNIFORM PAUSE
//  		.pause(10, 20) // between the specified range
//  		.pause(5000, 9000 milliseconds)
//
//	// FORCE PARAMETER
//  		.pause(10, constantPauses) // not to be override
//  		.pause(10, uniformPausesPlusOrMinusDuration(5)) // uniformly distributed over the range of 10 - 5 and 10 + 5

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
	println({Responde_name})


//	// GLOBAL PAUSE CONFIGURATIONS
//  	.disablePauses
//  	.uniformPauses(10)
//  	.uniformPauses(10.0) // %
//  	.exponentialPauses
//  	.constantPauses

	// SILENT RULES FOLLOWS PRECEDENCE BELOW
	// silent or notSilent (1)
	// silentUri (2)
	// silentResources (3)

}