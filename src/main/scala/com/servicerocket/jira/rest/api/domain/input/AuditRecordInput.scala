package com.servicerocket.jira.rest.api.domain.input

import com.servicerocket.jira.rest.api.domain.AuditAssociatedItem
import com.servicerocket.jira.rest.api.domain.AuditChangedValue

/** Represents record from JIRA Audit Log.
  *
  * @since 0.1
  */
case class AuditRecordInput(
                             category: String,
                             summary: String,
                             objectItem: Option[AuditAssociatedItem] = None,
                             associatedItems: Option[Seq[AuditAssociatedItem]] = None,
                             changedValues: Option[Seq[AuditChangedValue]] = None
                             ) {

  def withObjectItem(objectItem: AuditAssociatedItem) = copy(objectItem = Some(objectItem))

  def withObject(id: Option[String], name: String, typeName: String) = withObjectItem(AuditAssociatedItem(id, name, typeName))

  def withAssociatedItems(associatedItems: Seq[AuditAssociatedItem]) = copy(associatedItems = Some(associatedItems))

  def withChangedValues(values: Seq[AuditChangedValue]) = copy(changedValues = Some(values))

}
