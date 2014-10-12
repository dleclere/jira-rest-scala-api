package com.servicerocket.jira.rest.api.domain

/** Represents single item in Issue change history.
  *
  * @since 0.1
  */
case class ChangelogItem(fieldType: FieldType,
                         field: String,
                         from: String,
                         fromStr: String,
                         to: String,
                         toStr: String)