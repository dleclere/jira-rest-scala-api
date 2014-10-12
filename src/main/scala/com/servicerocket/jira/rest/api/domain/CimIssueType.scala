package com.servicerocket.jira.rest.api.domain

import java.net.URI

import com.servicerocket.jira.rest.api.domain.IssueFieldId.IssueFieldId

/** Describes issue type with fields info map.<br/>
  * The CIM prefix stands for CreateIssueMetadata as this class is used in output of {@link IssueRestClient#getCreateIssueMetadata(GetCreateIssueMetadataOptions)}
  *
  * @since v1.0
  */
case class CimIssueType(
                         self: URI,
                         id: Option[Long],
                         name: String,
                         isSubtask: Boolean,
                         description: String,
                         iconUri: URI,
                         fields: Map[String, CimFieldInfo]
                         ) {

  def getField(fieldId: IssueFieldId): Option[CimFieldInfo] = fields.get(fieldId.id.toString)

}
