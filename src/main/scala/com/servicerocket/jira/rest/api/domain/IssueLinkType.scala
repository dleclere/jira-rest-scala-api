package com.servicerocket.jira.rest.api.domain

import com.servicerocket.jira.rest.api.domain.IssueLinkType.Direction

/** Type of a link between two JIRA issues
  *
  * @since 0.1
  */
case class IssueLinkType(
                          name: String,
                          description: String,
                          direction: Direction
                          )
  extends Named

object IssueLinkType {

  sealed trait Direction

  case object OutBound extends Direction

  case object InBound extends Direction

}
