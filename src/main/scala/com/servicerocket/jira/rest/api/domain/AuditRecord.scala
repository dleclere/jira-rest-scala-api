package com.servicerocket.jira.rest.api.domain

import java.time.Instant

/** Represents record from JIRA Audit Log.
  *
  * @since 0.1
  */
case class AuditRecord(id: Long,
                       summary: String,
                       remoteAddress: Option[String],
                       created: Instant,
                       category: String,
                       eventSource: String,
                       authorKey: String,
                       objectItem: Option[AuditAssociatedItem],
                       associatedItem: Option[Iterable[AuditAssociatedItem]],
                       changedValues: Option[Iterable[AuditChangedValue]]) extends Identified[Long]