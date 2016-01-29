package testdata

import dbaccess.services.DBConfig._
import logging.Logging

/**
  * Created by PJAYARAT on 29/01/2016.
  */
object Add extends  Logging{


  def saveVehicleData = {

    voaDao.saveVehicleData

  }
}
