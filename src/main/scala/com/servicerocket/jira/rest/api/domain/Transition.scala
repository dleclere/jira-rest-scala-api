package com.servicerocket.jira.rest.api.domain

/** Information about selected transition including fields which can or must be set while performing the transition.
  *
  * @since 0.1
  */
case class Transition(
                       name: String,
                       id: Option[Long],
                       fields: Seq[Transition.Field])

  extends Named
  with Identified[Option[Long]]

object Transition {

  case class Field(
                    id: String,
                    isRequired: Boolean,
                    `type`: String
                    )

}
