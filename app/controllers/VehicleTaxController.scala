package controllers

import dbaccess.services.DBConfig._
import logging.Logging
import play.api.mvc.{Action, Controller}


/**
  * Created by PJAYARAT on 29/01/2016.
  */


case class VehicleInformationRequest(number:String, make: String, v5c: Option[String])

case class VehicleInformationResponse(number:String, make: String)


trait VehicleTaxController  extends Logging with VehicleTaxRequest{

  this: Controller =>


  def index = Action {
    Ok(views.html.index())
  }


  def getEnquiry = Action {
    Ok(views.html.enquiry(vehicleRequestForm))
  }


  def displayResults = Action { implicit request =>
    vehicleRequestForm.bindFromRequest.fold(
      formWithErrors => {
        BadRequest(views.html.enquiry(formWithErrors))
      },
      vehicleInformationRequest => {
        val vehicleDetails = VehicleTaxDetails.find(vehicleInformationRequest)
        log.debug("vehicle details are number"+  vehicleDetails.number +"  , make "+ vehicleDetails.make)
        Option(vehicleDetails.number) match {
          case Some(_) => Ok(views.html.result.render(vehicleDetails))
          case _ => Ok(views.html.noresult())
        }

      }
    )
  }

}


object VehicleTaxDetails{
  def find(vehicleInformationRequest: VehicleInformationRequest): VehicleInformationResponse = {

    val displayDetails = voaDao.fetchVehicleData(vehicleInformationRequest.number, vehicleInformationRequest.make)
    VehicleInformationResponse(displayDetails.number, displayDetails.make)
  }
}

object VehicleTaxController extends Controller with VehicleTaxController
