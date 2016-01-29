import _root_.testdata.TestDataManager
import logging.Logging
import play.api.{Application, GlobalSettings}

/**
  * Created by PJAYARAT on 29/01/2016.
  */
object Global extends App with Logging  with GlobalSettings {



  override def onStart(app: Application) {
    log.info("Application starting")
    TestDataManager.loadTestData
    log.info("Application has started")

  }

  override def onStop(app: Application) {
    log.info("Application shutdown...")
  }
}
