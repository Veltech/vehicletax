package dbaccess.services

import dbaccess.implementation.VoaDaoImpl

/**
  * Created by PJAYARAT on 29/01/2016.
  */
object DBConfig {

  implicit val voaDao: VoaDao = new VoaDaoImpl

}
