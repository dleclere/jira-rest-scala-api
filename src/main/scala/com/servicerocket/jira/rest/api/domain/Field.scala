package com.servicerocket.jira.rest.api.domain

/** Representation of JIRA field, either system or custom.
  *
  * @since 0.1
  */
case class Field(
                  id: String,
                  name: String,
                  fieldType: FieldType,
                  orderable: Boolean,
                  navigable: Boolean,
                  searchable: Boolean,
                  schema: Option[FieldSchema]
                  )

  extends Named
  with Identified[String]
