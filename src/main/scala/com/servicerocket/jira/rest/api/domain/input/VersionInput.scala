package com.servicerocket.jira.rest.api.domain.input

import java.time.Instant

/** Input data describing details of a project version to create.
  *
  * @since 0.1
  */
class VersionInput(
                    projectKey: String,
                    name: String,
                    isArchived: Boolean,
                    isReleased: Boolean,
                    description: Option[String] = None,
                    releaseDate: Option[Instant] = None
                    )
