package com.servicerocket.jira.rest.api.domain

import java.net.URI

/** Complete information about a single issue type defined in JIRA
  *
  * @since 0.1
  */
case class IssueType(
                      self: URI,
                      id: Long,
                      name: String,
                      isSubtask: Boolean,
                      description: String,
                      iconUri: URI
                      )

  extends Resource
  with Named
  with Identified[Long]
