package com.servicerocket.jira.rest.api.domain

import java.net.URI

/** Very basic (key and link only) representation of a JIRA issue.
  *
  * @since 0.1
  */
case class BasicIssue(self: URI,
                      key: String,
                      id: Long) extends Resource with Identified[Long]
