package com.servicerocket.jira.rest.api.domain

import java.net.URI
import java.time.Instant

/** A file attachment attached to an issue.
  *
  * @since 0.1
  */
case class Attachment(self: URI,
                      filename: String,
                      author: BasicUser,
                      creationDate: Instant,
                      size: Int,
                      mimeType: String,
                      contentUri: URI,
                      thumbnailUri: URI) extends Resource
