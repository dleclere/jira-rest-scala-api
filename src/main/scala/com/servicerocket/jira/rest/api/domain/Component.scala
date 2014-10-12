package com.servicerocket.jira.rest.api.domain

import java.net.URI

/** Project component
  *
  * @since 0.1
  */
case class Component(
                      self: URI,
                      id: Option[Long],
                      name: String,
                      description: Option[String],
                      lead: BasicUser,
                      assigneeInfo: Option[AssigneeInfo] = None
                      )
  extends Resource
  with Identified[Option[Long]]

/** Assignee info.
  *
  * @since 0.1
  */
case class AssigneeInfo(
                         assignee: BasicUser,
                         assigneeType: AssigneeType,
                         realAssignee: Option[BasicUser],
                         realAssigneeType: AssigneeType,
                         assigneeTypeValid: Boolean
                         )
