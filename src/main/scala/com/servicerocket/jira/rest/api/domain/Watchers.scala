package com.servicerocket.jira.rest.api.domain

import java.net.URI

/** Complete information about the watchers of given issue
  *
  * @since 0.1
  */
case class Watchers(
                     self: URI,
                     basicWatchers: BasicWatchers,
                     users: Seq[BasicUser]
                     )

  extends Resource
