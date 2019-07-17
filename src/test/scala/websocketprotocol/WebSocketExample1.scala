package websocketprotocol

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder
import scala.concurrent.duration._

class WebSocketExample1 extends Simulation {

  val httpProtocol: HttpProtocolBuilder = http.baseUrl("http://demos.kaazing.com")
    .wsBaseUrl("ws://demos.kaazing.com")

  val scn: ScenarioBuilder = scenario("WebSocketTest")
    .exec(http("InitialRequest").get("/")).pause(2 seconds)
    .exec(ws("OpenConnection").connect("/echo")
      .onConnected(
        exec(ws("SendFirstMessage").sendText("Hello there!")).pause(2 seconds)
          .exec(ws("SendSecondMessage").sendText("Greetings from HOT Quality")
            .await(20)(ws.checkTextMessage("CheckMessageReturned")
              .check(regex(".*HOT.*").saveAs("messageReturned")))
          )
          .exec(session => {
            println(session("messageReturned").as[String])
            session
          })

      )).exec(ws("CloseConnection").close)

  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)

}
