package com.servicerocket.jira.rest.api.domain

/** Item that can be associated with Audit Record.
  *
  * Represents additional information about item related to record like user, group or schema.
  *
  * @since 0.1
  */
case class AuditAssociatedItem(
                                id: Option[String],
                                name: String,
                                typeName: String,
                                parentId: Option[String] = None,
                                parentName: Option[String] = None
                                )

  extends Identified[Option[String]]
  with Named
