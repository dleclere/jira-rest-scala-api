package com.servicerocket.jira.rest.api.domain

/** Represents schema of field in JIRA
  *
  * @since 0.1
  */
case class FieldSchema(
                        `type`: String,
                        items: String,
                        system: String,
                        custom: String,
                        customId: Long)
