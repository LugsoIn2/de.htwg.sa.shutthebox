package spikeTest

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseUrl("http://localhost:9004")
		.inferHtmlResources()
		.acceptHeader("*/*")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("de-DE,de;q=0.9,en-US;q=0.8,en;q=0.7")
		.userAgentHeader("Mozilla/20.0 (Macintosh; Intel Mac OS X 10_120_7) AppleWebKit/2037.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/2037.36")

	val headers_0 = Map(
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "none",
		"sec-ch-ua" -> """ Not A;Brand";v="99", "Chromium";v="90", "Google Chrome";v="90""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_1 = Map(
		"Content-Type" -> "multipart/form-data; boundary=----WebKitFormBoundary4rTWuVC0S1AuaH1l",
		"Origin" -> "chrome-extension://ihgpcfpkpmdcghlnaofdmjkoemnlijdi",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "none",
		"sec-ch-ua" -> """ Not A;Brand";v="99", "Chromium";v="90", "Google Chrome";v="90""",
		"sec-ch-ua-mobile" -> "?0")

	val scn = scenario("RecordedSimulation")
		.exec(http("request_0")
			.get("/save")
			.headers(headers_0))
        .pause(20)
        .exec(http("request_1")
			.post("/load")
			.headers(headers_1)
			.body(RawFileBody("loadJson/recordedsimulation/0001_request.dat")))
		.pause(20)
		.exec(http("request_0")
			.get("/save")
			.headers(headers_0))
        .pause(20.milliseconds)
        .exec(http("request_1")
			.post("/load")
			.headers(headers_1)
			.body(RawFileBody("loadJson/recordedsimulation/0001_request.dat")))
		.pause(20.milliseconds)
		.exec(http("request_0")
			.get("/save")
			.headers(headers_0))
        .pause(20.milliseconds)
        .exec(http("request_1")
			.post("/load")
			.headers(headers_1)
			.body(RawFileBody("loadJson/recordedsimulation/0001_request.dat")))
		.pause(20.milliseconds)
		.exec(http("request_0")
			.get("/save")
			.headers(headers_0))
        .pause(20.milliseconds)
        .exec(http("request_1")
			.post("/load")
			.headers(headers_1)
			.body(RawFileBody("loadJson/recordedsimulation/0001_request.dat")))
		.pause(20.milliseconds)
		.exec(http("request_0")
			.get("/save")
			.headers(headers_0))
        .pause(20.milliseconds)
        .exec(http("request_1")
			.post("/load")
			.headers(headers_1)
			.body(RawFileBody("loadJson/recordedsimulation/0001_request.dat")))
		.pause(20.milliseconds)
		.exec(http("request_0")
			.get("/save")
			.headers(headers_0))
        .pause(20.milliseconds)
        .exec(http("request_1")
			.post("/load")
			.headers(headers_1)
			.body(RawFileBody("loadJson/recordedsimulation/0001_request.dat")))
		.pause(20.milliseconds)
		.exec(http("request_0")
			.get("/save")
			.headers(headers_0))
        .pause(20.milliseconds)
        .exec(http("request_1")
			.post("/load")
			.headers(headers_1)
			.body(RawFileBody("loadJson/recordedsimulation/0001_request.dat")))
		.pause(20.milliseconds)
		.exec(http("request_0")
			.get("/save")
			.headers(headers_0))
        .pause(20.milliseconds)
        .exec(http("request_1")
			.post("/load")
			.headers(headers_1)
			.body(RawFileBody("loadJson/recordedsimulation/0001_request.dat")))
		.pause(20.milliseconds)
		.exec(http("request_0")
			.get("/save")
			.headers(headers_0))
        .pause(20.milliseconds)
        .exec(http("request_1")
			.post("/load")
			.headers(headers_1)
			.body(RawFileBody("loadJson/recordedsimulation/0001_request.dat")))
		.pause(20.milliseconds)
		.exec(http("request_0")
			.get("/save")
			.headers(headers_0))
        .pause(20.milliseconds)
        .exec(http("request_1")
			.post("/load")
			.headers(headers_1)
			.body(RawFileBody("loadJson/recordedsimulation/0001_request.dat")))
		.pause(20.milliseconds)
		.exec(http("request_0")
			.get("/save")
			.headers(headers_0))
        .pause(20.milliseconds)
        .exec(http("request_1")
			.post("/load")
			.headers(headers_1)
			.body(RawFileBody("loadJson/recordedsimulation/0001_request.dat")))
		.pause(20)
		.exec(http("request_0")
			.get("/save")
			.headers(headers_0))
        .pause(20)
        .exec(http("request_1")
			.post("/load")
			.headers(headers_1)
			.body(RawFileBody("loadJson/recordedsimulation/0001_request.dat")))


	setUp(scn.inject(atOnceUsers(20))).protocols(httpProtocol)
}