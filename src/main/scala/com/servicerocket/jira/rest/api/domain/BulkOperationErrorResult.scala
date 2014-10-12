package com.servicerocket.jira.rest.api.domain

/** Represents error of creating single element during batch operation.
  *
  * @since 0.1
  */
case class BulkOperationErrorResult(errors: Nothing,
                                    failedElementNumber: Integer)
