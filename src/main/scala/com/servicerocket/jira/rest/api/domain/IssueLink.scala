package com.servicerocket.jira.rest.api.domain

import java.net.URI

/** Link between two JIRA issues.
  *
  * @since v0.1
  */
case class IssueLink(
                      targetIssueKey: String,
                      targetIssueUri: URI,
                      issueLinkType: IssueLinkType
                      )