import scala.concurrent.duration._

import scala.util.Random

import io.gatling.core.Predef._
import io.gatling.http.Predef._


class ShopNowBackendSimulation
  extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:8081")
    .userAgentHeader("Apocalipse")

  val criacaoEConsultaPessoas = scenario("Creating users")
    .feed(tsv("1_million_records.tsv").circular())
    .exec(
      http("criação")
      .post("/user/save").body(StringBody("#{payload}"))
      .header("content-type", "application/json")
      // 201 pros casos de sucesso :)
      // 422 pra requests inválidos :|
      // 400 pra requests bosta tipo data errada, tipos errados, etc. :(
      .check(status.in(201, 422, 400))
      // Se a criacao foi na api1 e esse location request atingir api2, a api2 tem que encontrar o registro.
      // Pode ser que o request atinga a mesma instancia, mas estatisticamente, pelo menos um request vai atingir a outra.
      // Isso garante o teste de consistencia de dados
      .check(status.saveAs("httpStatus"))
      .checkIf(session => session("httpStatus").as[String] == "201") {
        header("Location").saveAs("location")
      }
    )
    .pause(1.milliseconds, 30.milliseconds)
    .doIf(session => session.contains("location")) {
      exec(
        http("consulta")
        .get("#{location}")
      )
    }
 

  setUp(
    criacaoEConsultaPessoas.inject(
      constantUsersPerSec(2).during(10.seconds), // warm up
      constantUsersPerSec(5).during(15.seconds).randomized, // are you ready?
      
      rampUsersPerSec(6).to(600).during(3.minutes) // lezzz go!!!
    )
  ).protocols(httpProtocol)
}
