package com.servicerocket.jira.rest.api.domain

import java.net.URI
import java.time.Instant

/** Basic information about JIRA server
  *
  * @since 0.1
  */
case class ServerInfo(
                       baseUri: URI,
                       version: String,
                       buildNumber: Int,
                       buildDate: Instant,
                       serverTime: Option[Instant],
                       scmInfo: String,
                       serverTitle: String
                       )
