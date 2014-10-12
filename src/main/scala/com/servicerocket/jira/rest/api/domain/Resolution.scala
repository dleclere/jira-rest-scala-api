package com.servicerocket.jira.rest.api.domain

import java.net.URI

/** Basic information (served together with the issue) about current resolution.
  *
  * @since 0.1
  */
case class Resolution(
                       self: URI,
                       id: Option[Long],
                       name: String,
                       description: String
                       )

  extends Resource
  with Named
  with Identified[Option[Long]]
