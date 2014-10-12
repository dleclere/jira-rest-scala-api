package com.servicerocket.jira.rest.client

import java.net.URI
import com.servicerocket.jira.rest.api.domain._
import com.servicerocket.jira.rest.api.domain.exception.RestClientException

import scala.concurrent.Future

/** Serves information about JIRA metadata like server information, issue types defined, stati, priorities and resolutions.
  * This data constitutes a data dictionary which then JIRA issues base on.
  *
  * @since v2.0
  */
trait MetadataRestClient {

  /** Retrieves from the server complete information about selected issue type
    *
    * @param uri URI to issue type resource (one can get it e.g. from <code>self</code> attribute
    *            of issueType field of an issue).
    * @return complete information about issue type resource
    * @throws RestClientException in case of problems (connectivity, malformed messages, etc.)
    */
  def getIssueType(uri: URI): Future[IssueType]

  /** Retrieves from the server complete list of available issue type
    *
    * @return complete information about issue type resource
    * @throws RestClientException in case of problems (connectivity, malformed messages, etc.)
    * @since com.atlassian.jira.rest.client.api 1.0, server 5.0
    */
  def getIssueTypes: Future[Seq[IssueType]]

  /** Retrieves from the server complete list of available issue types
    *
    * @return list of available issue types for this JIRA instance
    * @throws RestClientException in case of problems (if linking is disabled on the server, connectivity, malformed messages, etc.)
    * @since server 4.3, com.atlassian.jira.rest.client.api 0.5
    */
  def getIssueLinkTypes: Future[Seq[IssuelinksType]]

  /** Retrieves complete information about selected status
    *
    * @param uri URI to this status resource (one can get it e.g. from <code>self</code> attribute
    *            of <code>status</code> field of an issue)
    * @return complete information about the selected status
    * @throws RestClientException in case of problems (connectivity, malformed messages, etc.)
    */
  def getStatus(uri: URI): Future[Status]

  /** Retrieves lists of available statuses with complete information about them
    *
    * @return Lists of complete information about available statuses
    * @throws RestClientException in case of problems (connectivity, malformed messages, etc.)
    */
  def getStatuses: Future[Seq[Status]]

  /** Retrieves from the server complete information about selected priority
    *
    * @param uri URI for the priority resource
    * @return complete information about the selected priority
    * @throws RestClientException in case of problems (connectivity, malformed messages, etc.)
    */
  def getPriority(uri: URI): Future[Priority]

  /** Retrieves from the server complete list of available priorities
    *
    * @return complete information about the selected priority
    * @throws RestClientException in case of problems (connectivity, malformed messages, etc.)
    * @since com.atlassian.jira.rest.client.api 1.0, server 5.0
    */
  def getPriorities: Future[Seq[Priority]]

  /** Retrieves from the server complete information about selected resolution
    *
    * @param uri URI for the resolution resource
    * @return complete information about the selected resolution
    * @throws RestClientException in case of problems (connectivity, malformed messages, etc.)
    */
  def getResolution(uri: URI): Future[Resolution]

  /** Retrieves from the server complete information about selected resolution
    *
    * @return complete information about the selected resolution
    * @throws RestClientException in case of problems (connectivity, malformed messages, etc.)
    * @since com.atlassian.jira.rest.client.api 1.0, server 5.0
    */
  def getResolutions: Future[Seq[Resolution]]

  /** Retrieves information about this JIRA instance
    *
    * @return information about this JIRA instance
    * @throws RestClientException in case of problems (connectivity, malformed messages, etc.)
    */
  def getServerInfo: Future[ServerInfo]

  /** Retrieves information about JIRA custom and system fields.
    *
    * @return information about JIRA custom and system fields.
    * @throws RestClientException in case of problems (connectivity, malformed messages, etc.)
    */
  def getFields: Future[Seq[Field]]

}
