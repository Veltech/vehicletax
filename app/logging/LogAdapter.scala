package logging

/**
  * Created by PJAYARAT on 29/01/2016.
  */
object LogAdapter {
  type LogAdaptation = {
    def info(msg: String)
    def error(msg: String, err: Throwable)
  }
}
