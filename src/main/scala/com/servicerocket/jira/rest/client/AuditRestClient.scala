package com.servicerocket.jira.rest.client

import com.servicerocket.jira.rest.api.domain.AuditRecordsData
import com.servicerocket.jira.rest.api.domain.input.{AuditRecordInput, AuditRecordSearchInput}

import scala.concurrent.Future

/** The com.atlassian.jira.rest.client.api handling audit record resources.
  *
  * @since 0.1
  */
trait AuditRestClient {

  def getAuditRecords(input: AuditRecordSearchInput): Future[AuditRecordsData]

  def addAuditRecord(record: AuditRecordInput): Future[Boolean]

}
