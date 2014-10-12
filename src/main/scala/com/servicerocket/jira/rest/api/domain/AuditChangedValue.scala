package com.servicerocket.jira.rest.api.domain

/** A value that has changed in object related to Audit Record.
  *
  * @since 0.1
  */
case class AuditChangedValue(fieldName: String,
                             changedTo: Option[String],
                             changedFrom: Option[String])
