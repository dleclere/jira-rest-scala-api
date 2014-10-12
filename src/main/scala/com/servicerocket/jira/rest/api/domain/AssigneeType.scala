package com.servicerocket.jira.rest.api.domain

/** Possible assignee type for project components.
  *
  * @since 0.1
  */
sealed trait AssigneeType

case object ProjectDefault extends AssigneeType

case object ComponentLead extends AssigneeType

case object ProjectLead extends AssigneeType

case object Unassigned extends AssigneeType
