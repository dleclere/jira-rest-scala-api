package com.servicerocket.jira.rest.api.domain

/** Represents audit search metadata and audit result records.
  *
  * @since 0.1
  */
case class AuditRecordsData(offset: Int,
                            limit: Int,
                            total: Int,
                            records: Iterable[AuditRecord])
