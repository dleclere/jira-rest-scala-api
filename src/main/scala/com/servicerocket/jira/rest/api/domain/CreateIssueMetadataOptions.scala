package com.servicerocket.jira.rest.api.domain

import com.servicerocket.jira.rest.client.IssueRestClient

/** Set of optional parameters for [[IssueRestClient.getCreateIssueMetadata]]
  *
  * @since 0.1
  */
case class CreateIssueMetadataOptions(
                                          expandos: Option[Seq[String]],
                                          issueTypeNames: Option[Seq[String]],
                                          issueTypeIds: Option[Seq[Long]],
                                          projectKeys: Option[Seq[String]],
                                          projectIds: Option[Seq[Long]]
                                          ) {

  def withExpandos(expandos: String*) = copy(expandos = Some(expandos))

  def withExpandedIssueTypesFields = withExpandos(CreateIssueMetadataOptions.ExpandoProjectsIssueTypesFields)

  def withIssueTypeNames(issueTypeNames: String*) = copy(issueTypeNames = Some(issueTypeNames))

  def withIssueTypeIds(issueTypeIds: Long*) = copy(issueTypeIds = Some(issueTypeIds))

  def withProjectKeys(projectKeys: String*) = copy(projectKeys = Some(projectKeys))

  def withProjectIds(projectIds: Long*) = copy(projectIds = Some(projectIds))

}

object CreateIssueMetadataOptions {

  val ExpandoProjectsIssueTypesFields = "projects.issuetypes.fields"

}
