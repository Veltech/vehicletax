package controllers

import play.api.data.Form
import play.api.data.Forms._


/**
  * Created by PJAYARAT on 29/01/2016.
  */
trait VehicleTaxRequest {

  implicit val vehicleRequestForm: Form[VehicleInformationRequest] = Form(
    mapping(
      "number" -> nonEmptyText,
      "make" -> nonEmptyText,
      "v5c" -> optional(text)
    )(VehicleInformationRequest.apply)(VehicleInformationRequest.unapply)
  )

}
