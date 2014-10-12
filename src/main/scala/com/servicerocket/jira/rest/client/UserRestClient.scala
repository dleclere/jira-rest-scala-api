package com.servicerocket.jira.rest.client

import java.net.URI
import com.servicerocket.jira.rest.api.domain.User
import com.servicerocket.jira.rest.api.domain.exception.RestClientException

import scala.concurrent.Future

/** The com.atlassian.jira.rest.client.api handling user resources.
  *
  * @since 0.1
  */
trait UserRestClient {

  /** Retrieves detailed information about selected user.
    * Try to use {@link #getUser(java.net.URI)} instead as that method is more RESTful (well connected)
    *
    * @param username JIRA username/login
    * @return complete information about given user
    * @throws RestClientException in case of problems (connectivity, malformed messages, etc.)
    */
  def getUser(username: String): Future[User]

  /** Retrieves detailed information about selected user.
    * This method is preferred over {@link #getUser(String)} as com.atlassian.jira.rest.it's more RESTful (well connected)
    *
    * @param userUri URI of user resource
    * @return complete information about given user
    * @throws RestClientException in case of problems (connectivity, malformed messages, etc.)
    */
  def getUser(userUri: URI): Future[User]

}
