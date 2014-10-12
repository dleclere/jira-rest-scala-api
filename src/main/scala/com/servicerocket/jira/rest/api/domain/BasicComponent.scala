package com.servicerocket.jira.rest.api.domain

import java.net.URI

/** Basic information about a project component
  *
  * @since v0.1
  */
case class BasicComponent(
                           self: URI,
                           id: Option[Long],
                           name: String,
                           description: Option[String]
                           )

  extends Resource
  with Identified[Option[Long]]
