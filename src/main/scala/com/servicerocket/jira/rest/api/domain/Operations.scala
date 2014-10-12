package com.servicerocket.jira.rest.api.domain

import com.servicerocket.jira.rest.client.IssueRestClient

/** Represents operations returned for expand [[IssueRestClient.Expandos.Operations]]
  *
  * @since 0.1
  */
case class Operations(linkGroups: Iterable[OperationGroup]) {

  def accept[T](visitor: OperationVisitor[T]): Option[T] = {
    OperationGroup.accept(linkGroups, visitor)
  }

  def getOperationById(operationId: String): Option[Operation] = {
    accept(new OperationVisitor[Operation] {
      def visit(operation: Operation): Option[Operation] = {
        operation.id.filter(_ == operationId).fold(None.asInstanceOf[Option[Operation]])(id => Some(operation))
      }
    })
  }

}
