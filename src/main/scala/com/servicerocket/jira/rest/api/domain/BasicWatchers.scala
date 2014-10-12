package com.servicerocket.jira.rest.api.domain

import java.net.URI

/** Basic information about watchers of a JIRA issue
  *
  * @since 0.1
  */
case class BasicWatchers(
                          self: URI,
                          watching: Boolean,
                          numWatchers: Int
                          )

  extends Resource
