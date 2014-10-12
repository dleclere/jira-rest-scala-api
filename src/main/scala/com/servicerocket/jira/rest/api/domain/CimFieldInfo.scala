package com.servicerocket.jira.rest.api.domain

import java.net.URI

import com.servicerocket.jira.rest.api.domain.StandardOperation.StandardOperation

/** Contains information about field in IssueType.<br/>
  * The CIM prefix stands for CreateIssueMetadata as this class is used in output of
  *
  * @since 0.1
  */
case class CimFieldInfo(
                         id: String,
                         required: Boolean,
                         name: String,
                         schema: FieldSchema,
                         operations: Set[StandardOperation],
                         allowedValues: Option[Iterable[AnyRef]],
                         autoCompleteUri: Option[URI]
                         )

  extends Named
  with Identified[String]
