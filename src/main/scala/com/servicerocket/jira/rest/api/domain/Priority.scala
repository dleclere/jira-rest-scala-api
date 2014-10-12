package com.servicerocket.jira.rest.api.domain

import java.net.URI

/** Complete information about a JIRA issue priority
  *
  * @since 0.1
  */
case class Priority(
                     self: URI,
                     id: Option[Long],
                     name: String,
                     statusColor: String,
                     description: String,
                     iconUri: URI
                     )

  extends Resource
  with Named
  with Identified[Option[Long]]
