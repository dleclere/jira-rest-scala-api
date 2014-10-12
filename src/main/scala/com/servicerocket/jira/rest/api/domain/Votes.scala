package com.servicerocket.jira.rest.api.domain

import java.net.URI

/** Complete information about the voters for given issue
  *
  * @since 0.1
  */
case class Votes(
                  self: URI,
                  votes: Int,
                  hasVoted: Boolean,
                  users: Seq[BasicUser] = Seq()
                  )

  extends Resource
