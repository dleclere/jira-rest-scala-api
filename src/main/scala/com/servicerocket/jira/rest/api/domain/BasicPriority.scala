package com.servicerocket.jira.rest.api.domain

import java.net.URI

/** Basic information about selected priority
  *
  * @since 0.1
  */
case class BasicPriority(
                          self: URI,
                          id: Long,
                          name: String
                          )

  extends Resource
  with Identified[Long]
