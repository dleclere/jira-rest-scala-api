package com.servicerocket.jira.rest.api.domain

import java.net.URI

/** Complete information about single JIRA project.
  * Many REST resources instead include just BasicProject.
  *
  * @since 0.1
  */
case class Project(
                    self: URI,
                    key: String,
                    id: Option[Long],
                    name: String,
                    description: Option[String],
                    lead: BasicUser,
                    uri: URI,
                    versions: Seq[Version],
                    components: Seq[BasicComponent],
                    issueTypes: Option[Seq[IssueType]],
                    projectRoles: Seq[BasicProjectRole],
                    expandos: Seq[String] = Seq()
                    )

  extends Resource
  with Named
  with Identified[Option[Long]]
  with Expandable
