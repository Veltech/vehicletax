package dbaccess.implementation

import anorm.SqlParser.{scalar, _}
import anorm._
import dbaccess.services.VoaDao
import models.VehicleTaxInformation
import play.api.Play.current
import play.api.db.DB

/**
  * Created by PJAYARAT on 29/01/2016.
  */
class VoaDaoImpl  extends  VoaDao {

  /***
    * Load test data
    */
  override def saveVehicleData: Unit = {


    DB.withConnection { implicit c =>
      val result: Boolean = SQL("Select 1").execute()

      val id: Option[Long] =
        SQL("insert into Vehicles(number, make) values ({number}, {make})")
          .on('number -> "LS07EAE", 'make -> "TOYOTA").executeInsert()

      log.debug("----------------------------------------result---------------"+result+"-------id:"+id)
    }

  }


  override def fetchVehicleData(number:String, make:String) : VehicleTaxInformation = {

    DB.withConnection { implicit c =>

      val sqlQueryResult: SqlQueryResult =
        SQL("select number,make from Vehicles where number = {number} and make = {make}")
          .on('number -> number.toUpperCase, 'make -> make.toUpperCase).executeQuery()


      val str1 = sqlQueryResult.as(scalar[String].*)
      val vehicleNumber =sqlQueryResult.as(str(1).singleOpt)
      val vehicleMake =sqlQueryResult.as(str(2).singleOpt)

      log.debug("----------------------------------------fetch----result---------------str1-----:"+str1)
      log.debug("----------------------------------------fetch----result---------------vehicleNumber-----:"+vehicleNumber)
      log.debug("----------------------------------------fetch----result---------------vehicleMake-----:"+vehicleMake)

      vehicleNumber match {
        case Some(a) => VehicleTaxInformation(a, vehicleMake.get)
        case _ => VehicleTaxInformation(null,null)
      }

    }


  }

}
