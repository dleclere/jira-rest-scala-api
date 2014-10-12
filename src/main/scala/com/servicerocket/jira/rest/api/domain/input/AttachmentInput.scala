package com.servicerocket.jira.rest.api.domain.input

import java.io.InputStream

/** Data required to add an attachment
  *
  * @since 0.1
  */
case class AttachmentInput(filename: String, in: InputStream)
