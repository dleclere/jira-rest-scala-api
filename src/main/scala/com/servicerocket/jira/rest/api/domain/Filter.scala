package com.servicerocket.jira.rest.api.domain

import java.net.URI

/** Represents Filter.
  *
  * @since 0.1
  */
case class Filter(
                   self: URI,
                   id: Long,
                   name: String,
                   description: String,
                   jql: String,
                   viewUrl: URI,
                   searchUrl: URI,
                   owner: BasicUser,
                   favourite: Boolean)

  extends Resource
  with Named
  with Identified[Long]
