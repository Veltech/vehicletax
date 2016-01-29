package dbaccess.services

import logging.Logging
import models.VehicleTaxInformation

/**
  * Created by PJAYARAT on 29/01/2016.
  */
trait VoaDao extends Logging{

  def saveVehicleData
  def fetchVehicleData(number:String, make:String): VehicleTaxInformation

}
