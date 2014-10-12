package com.servicerocket.jira.rest.api.domain

import java.net.URI
import java.time.Instant

/** A JIRA comment
  *
  * @since 0.1
  */
case class Comment(
                    self: URI,
                    body: String, author: Option[BasicUser],
                    updateAuthor: Option[BasicUser],
                    creationDate: Instant,
                    updateDate: Instant,
                    visibility: Visibility,
                    id: Option[Long]
                    )

  extends Resource {

  val wasUpdated = updateDate.isAfter(creationDate)

}

object Comment {

  def valueOf(body: String) = Comment(null, body, None, None, null, null, null, None)

  def createWithRoleLevel(body: String, roleLevel: String) = Comment(null, body, None, None, null, null, Visibility.role(roleLevel), None)

  def createWithGroupLevel(body: String, groupLevel: String) = Comment(null, body, None, None, null, null, Visibility.group(groupLevel), None)

}
