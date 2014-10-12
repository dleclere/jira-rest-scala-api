package com.servicerocket.jira.rest.api.domain

import java.net.URI

/**
 * @since v0.5
 */
case class IssuelinksType(
                           self: URI,
                           id: String,
                           name: String,
                           inward: String,
                           outward: String
                           )

  extends Resource
  with Named