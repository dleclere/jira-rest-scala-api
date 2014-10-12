package com.servicerocket.jira.rest.api.domain

import java.net.URI

/** Represents project allowed to choose to create new issue. Also contains issue types allowed for that project described by
  * [[com.servicerocket.jira.rest.api.domain.CimIssueType]] class.
  * The CIM prefix stands for CreateIssueMetadata as this class is used in output of
  * [[com.servicerocket.jira.rest.client.IssueRestClient.getCreateIssueMetadata]]
  *
  * @since 0.1
  */
case class CimProject(
                       self: URI,
                       key: String,
                       id: Option[Long],
                       name: String,
                       avatarUris: Map[String, URI],
                       issueTypes: Iterable[CimIssueType]
                       )

  extends Resource
  with Named
