package com.servicerocket.jira.rest.api.domain

/** Error container returned in bulk operations
  *
  * @since v2.0
  */
case class ErrorCollection(
                            status: Option[Int],
                            errorMessages: Seq[String],
                            errors: Map[String, String]
                            ) {

  def withStatus(status: Int) = copy(status = Some(status))

  def withError(key: String, message: String) = copy(errors = errors + (key -> message))

  def withErrorMessage(message: String) = copy(errorMessages = message +: errorMessages)

}
