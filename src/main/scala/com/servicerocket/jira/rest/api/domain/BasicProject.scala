
package com.servicerocket.jira.rest.api.domain

import java.net.URI

/** Basic information about a JIRA project
  *
  * @since 0.1
  */
case class BasicProject(
                         self: URI,
                         key: String,
                         id: Option[Long],
                         name: String
                         )

  extends Resource
  with Named
  with Identified[Option[Long]]
