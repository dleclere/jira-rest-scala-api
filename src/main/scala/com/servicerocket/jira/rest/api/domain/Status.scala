package com.servicerocket.jira.rest.api.domain

import java.net.URI

/** Basic information about a JIRA issue status
  *
  * @since v0.1
  */
case class Status(
                   self: URI,
                   id: Option[Long],
                   name: String,
                   description: String,
                   iconUrl: URI
                   )

  extends Resource
  with Identified[Option[Long]]
