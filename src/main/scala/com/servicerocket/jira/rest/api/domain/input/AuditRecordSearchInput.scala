package com.servicerocket.jira.rest.api.domain.input

import java.time.Instant

/** Input data for searching audit records
 *
 * @since 0.1
 */
case class AuditRecordSearchInput(
                                   offset: Option[Int] = None,
                                   limit: Option[Int] = None,
                                   textFilter: Option[String] = None,
                                   from: Option[Instant] = None,
                                   to: Option[Instant] = None)
