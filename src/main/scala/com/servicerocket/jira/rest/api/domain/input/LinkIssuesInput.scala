package com.servicerocket.jira.rest.api.domain.input

import com.servicerocket.jira.rest.api.domain.Comment

/** Input parameters used for issue link creation.
  *
  * @since 0.1
  */
case class LinkIssuesInput(
                            fromIssueKey: String,
                            toIssueKey: String,
                            linkType: String,
                            comment: Option[Comment] = None)
