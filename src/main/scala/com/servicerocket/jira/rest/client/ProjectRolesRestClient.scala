package com.servicerocket.jira.rest.client

import java.net.URI
import com.servicerocket.jira.rest.api.domain.ProjectRole
import com.servicerocket.jira.rest.api.domain.exception.RestClientException

import scala.concurrent.Future

/** The com.atlassian.jira.rest.client.api handling roles resources.
  *
  * @since 0.1
  */
trait ProjectRolesRestClient {

  /** Retrieves a full information about the selected role.
    *
    * @param uri URI of the role to retrieve.
    * @return full information about selected role.
    * @throws RestClientException in case of problems (connectivity, malformed messages, etc.)
    */
  def getRole(uri: URI): Future[ProjectRole]

  /** Retrieves a full information about the selected role.
    *
    * @param projectUri uri of the project of the role to retrieve.
    * @param roleId     unique role id.
    * @return full information about selected role.
    * @throws RestClientException in case of problems (connectivity, malformed messages, etc.)
    */
  def getRole(projectUri: URI, roleId: Long): Future[ProjectRole]

  /** Retrieves a collection of roles in the selected project.
    *
    * @param projectUri uri of the project of the roles to retrieve.
    * @return a collection of roles in the selected project.
    * @throws RestClientException in case of problems (connectivity, malformed messages, etc.)
    */
  def getRoles(projectUri: URI): Future[Seq[ProjectRole]]

}
