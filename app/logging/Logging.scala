package logging

import org.slf4j.LoggerFactory

/**
  * Created by PJAYARAT on 29/01/2016.
  */
object Logging {
  def apply(name: String) = new Logging {
    @transient override lazy val log = LoggerFactory.getLogger(name)
  }
}

trait Logging {
  @transient lazy val log = LoggerFactory.getLogger(this.getClass.getName)
}
