package com.servicerocket.jira.rest.api.domain

/** JIRA field type.
  *
  * @since 0.1
  */

sealed trait FieldType

case object Jira extends FieldType

case object Custom extends FieldType
