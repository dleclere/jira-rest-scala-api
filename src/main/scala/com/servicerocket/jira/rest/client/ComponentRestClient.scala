package com.servicerocket.jira.rest.client

import java.net.URI
import com.servicerocket.jira.rest.api.domain.Component
import com.servicerocket.jira.rest.api.domain.exception.RestClientException

import scala.concurrent.Future

/** The com.atlassian.jira.rest.client.api handling component resources
  *
  * @since 0.1
  */
trait ComponentRestClient {

  /** Returns component with provided Uri.
    *
    * @param componentUri URI to selected component resource.
    * @return complete information about selected component.
    * @throws RestClientException in case of problems (connectivity, malformed messages, etc.).
    */
  def getComponent(componentUri: URI): Future[Component]

  def createComponent(projectKey: String, componentInput: Nothing): Future[Component]

  def updateComponent(componentUri: URI, componentInput: Nothing): Future[Component]

  def removeComponent(componentUri: URI, moveIssueToComponentUri: Option[URI] = None): Future[Boolean]

  def getComponentRelatedIssuesCount(componentUri: URI): Future[Int]

}
