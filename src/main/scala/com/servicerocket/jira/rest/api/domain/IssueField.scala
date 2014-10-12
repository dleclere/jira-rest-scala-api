package com.servicerocket.jira.rest.api.domain

/** JIRA issue field with its current value.
  *
  * @since 0.1
  */
case class IssueField(
                       id: String,
                       name: String,
                       `type`: String,
                       value: AnyRef
                       )

  extends Named
  with Identified[String]
