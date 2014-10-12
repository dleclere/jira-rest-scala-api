package com.servicerocket.jira.rest.api.domain

/** Represents visibility (access level) of selected element (comment, worklog, etc.)
  *
  * @since 0.1
  */
case class Visibility(
                       `type`: Visibility.Type.Type,
                       value: String
                       )

object Visibility {

  object Type extends Enumeration {
    type Type = Value
    val Role, Group = Value
  }

  def role(value: String) = Visibility(Type.Role, value)

  def group(group: String) = Visibility(Type.Group, group)

}
