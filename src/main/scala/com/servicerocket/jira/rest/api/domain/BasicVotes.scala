package com.servicerocket.jira.rest.api.domain

import java.net.URI

/** Basic information about voters of a JIRA issue
  *
  * @since v0.1
  */
case class BasicVotes(self: URI,
                      votes: Int,
                      hasVoted: Boolean) extends Resource
