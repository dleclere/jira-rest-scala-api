package com.servicerocket.jira.rest.client

import java.net.URI
import com.servicerocket.jira.rest.api.domain.Project
import com.servicerocket.jira.rest.api.domain.exception.RestClientException

import scala.concurrent.Future

/** The com.atlassian.jira.rest.client.api handling project resources.
  *
  * @since v0.1
  */
trait ProjectRestClient {

  /** Retrieves complete information about given project.
    *
    * @param key unique key of the project (usually 2+ characters)
    * @return complete information about given project
    * @throws RestClientException in case of problems (connectivity, malformed messages, etc.)
    */
  def getProject(key: String): Future[Project]

  /** Retrieves complete information about given project.
    * Use this method rather than using overloaded method which accepts key whenever you can, as this method is
    * proof for potential changes of URI scheme used for exposing various resources by JIRA REST API.
    *
    * @param projectUri URI to project resource (usually get from <code>self</code> attribute describing component elsewhere
    * @return complete information about given project
    * @throws RestClientException in case of problems (connectivity, malformed messages, etc.)
    */
  def getProject(projectUri: URI): Future[Project]

  /** Returns all projects, which are visible for the currently logged in user. If no user is logged in, it returns the
    * list of projects that are visible when using anonymous access.
    *
    * @return projects which the currently logged user can see
    * @since com.atlassian.jira.rest.client.api: 0.2, server 4.3
    */
  def getAllProjects: Future[Seq[Project]]

}
