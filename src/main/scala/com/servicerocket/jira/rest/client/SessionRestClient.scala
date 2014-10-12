package com.servicerocket.jira.rest.client

import com.servicerocket.jira.rest.api.domain.Session
import com.servicerocket.jira.rest.api.domain.exception.RestClientException

import scala.concurrent.Future

/** Client handling the current user session
  *
  * @since 0.1
  */
trait SessionRestClient {

  /** @return information about current session
    * @throws RestClientException in case of problems (connectivity, malformed messages, etc.)
    */
  def getCurrentSession: Future[Session]

}
