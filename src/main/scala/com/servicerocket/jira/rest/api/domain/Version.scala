package com.servicerocket.jira.rest.api.domain

import java.net.URI
import java.time.Instant

/** Complete information about a version defined for a JIRA project
  *
  * @since 0.1
  */
case class Version(
                    self: URI,
                    id: Option[Long],
                    name: String,
                    description: String,
                    archived: Boolean,
                    released: Boolean,
                    releaseDate: Option[Instant]
                    )

  extends Resource
  with Named
  with Identified[Option[Long]]
