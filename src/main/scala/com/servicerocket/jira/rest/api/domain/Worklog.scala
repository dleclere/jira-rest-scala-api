package com.servicerocket.jira.rest.api.domain

import java.net.URI
import java.time.Instant

/** Issue worklog - single worklog entry describing the work logged for selected issue
  *
  * @since 0.1
  */
case class Worklog(
                    self: URI,
                    issueUri: URI,
                    author: BasicUser,
                    updateAuthor: BasicUser,
                    comment: Option[String],
                    creationDate: Instant,
                    updateDate: Instant,
                    startDate: Instant,
                    minutesSpent: Int,
                    visibility: Option[Visibility]
                    )

  extends Resource
