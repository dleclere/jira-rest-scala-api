package com.servicerocket.jira.rest.client

import com.servicerocket.jira.rest.api._

/** Main access point to REST com.atlassian.jira.rest.client.api.
  * As there are many types resources exposed by JIRA REST API, various resources are grouped into clusters
  * and then handled by different specialized *RestClient classes.
  *
  * @since 0.1
  */
trait JiraRestClient {

  /**
   * @return com.atlassian.jira.rest.client.api for performing operations on selected issue
   */
  def issueClient: IssueRestClient

  /**
   * @return the com.atlassian.jira.rest.client.api handling session information
   */
  def sessionClient: SessionRestClient

  /**
   * @return the com.atlassian.jira.rest.client.api handling full user information
   */
  def userClient: UserRestClient

  /**
   * @return the com.atlassian.jira.rest.client.api handling project metadata
   */
  def projectClient: ProjectRestClient

  /**
   * @return the com.atlassian.jira.rest.client.api handling components
   */
  def componentClient: ComponentRestClient

  /**
   * @return the com.atlassian.jira.rest.client.api handling basic meta-data (data dictionaries defined in JIRA - like resolutions, statuses,
   *         priorities)
   */
  def metadataClient: MetadataRestClient

  /**
   * @return the com.atlassian.jira.rest.client.api handling search (e.g. JQL)
   */
  def searchClient: SearchRestClient

  /**
   * @return the com.atlassian.jira.rest.client.api handling project versions.
   */
  def versionRestClient: VersionRestClient

  /**
   * @return the com.atlassian.jira.rest.client.api for project roles.
   */
  def projectRolesRestClient: ProjectRolesRestClient

  /**
   * @return the com.atlassian.jira.rest.client.api for auditing records
   */
  def auditRestClient: AuditRestClient

  /**
   * @return the com.atlassian.jira.rest.client.api for my permissions.
   */
  def myPermissionsRestClient: MyPermissionsRestClient

}
