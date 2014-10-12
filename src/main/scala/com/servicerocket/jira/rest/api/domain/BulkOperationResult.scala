package com.servicerocket.jira.rest.api.domain

/** Basic representation of a JIRA issues and errors created using batch operation.
  *
  * @since v2.0
  */
case class BulkOperationResult[T](issues: Iterable[T],
                                  errors: Iterable[BulkOperationErrorResult])