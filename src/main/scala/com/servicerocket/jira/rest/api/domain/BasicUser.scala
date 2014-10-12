package com.servicerocket.jira.rest.api.domain

import java.net.URI

/** Basic information about a JIRA user
  *
  * @since v0.1
  */
case class BasicUser(self: URI,
                     name: String,
                     displayName: String) extends Resource with Named {

  def isSelfUriIncomplete = BasicUser.IncompleteUri == self

}

object BasicUser {

  val IncompleteUri = URI.create("incomplete://user")

}
