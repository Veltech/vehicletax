package controllers

import org.scalatestplus.play.{OneAppPerSuite, PlaySpec}
import play.api.libs.json.Json
import play.api.mvc.{Controller, Results}
import play.api.test.FakeRequest
import play.api.test.Helpers._

/**
  * Created by PJAYARAT on 28/01/2016.
  */
class VehicleTaxControllerSpec  extends PlaySpec with Results with OneAppPerSuite  {
  class TestController() extends Controller with VehicleTaxController

  "Check if a vehicle is taxed page#index" should {
    "should be valid" in {

      val Some(result) = route(FakeRequest(GET, "/"))
      status(result) mustEqual OK
    }
  }

  "Details of the vehicle being checked page#getEnquiry" should {
    "should be valid" in {
      val Some(result) = route(FakeRequest(GET, "/enquiry"))

      status(result) mustEqual OK

    }
  }

  "Vehicle details page#displayResults" should {
    "should be valid" in {
      val controller = new TestController()
      val request = FakeRequest(POST, "/result").withJsonBody(Json.parse(s"""{"number":"number2","make":"testmake"}"""))
      val apiResult = call(controller.displayResults, request)

      status(apiResult) mustEqual OK
    }
  }


  "Vehicle details page#displayResults" should {
    "should not be valid when request body is empty" in {
      val controller = new TestController()
      val request = FakeRequest(POST, "/result")
      val apiResult = call(controller.displayResults, request)

      status(apiResult) mustEqual BAD_REQUEST
    }
  }


  "Vehicle details page#displayResults" should {
    "should not be valid when request body is incomplete" in {
      val controller = new TestController()
      val request = FakeRequest(POST, "/result").withJsonBody(Json.parse(s"""{"make":"testmake"}"""))
      val apiResult = call(controller.displayResults, request)

      status(apiResult) mustEqual BAD_REQUEST
    }
  }

}

