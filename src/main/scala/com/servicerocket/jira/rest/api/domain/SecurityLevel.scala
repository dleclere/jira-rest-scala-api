package com.servicerocket.jira.rest.api.domain

import java.net.URI

/** Represents JIRA Security Level
  *
  * @since 0.1
  */
case class SecurityLevel(
                          self: URI,
                          id: Option[Long],
                          name: String,
                          description: String
                          )

  extends Resource
  with Named
  with Identified[Option[Long]]