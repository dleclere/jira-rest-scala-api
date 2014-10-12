package com.servicerocket.jira.rest.api.domain.input

/** Represents object with fields in IssueInputField's value.
  *
  * @since 0.1
  */
case class ComplexIssueInputFieldValue(valuesMap: Map[String, Any] = Map()) {

  def +(key: String, value: AnyRef) = copy(valuesMap = valuesMap + (key -> value))

}

object ComplexIssueInputFieldValue {

  def from[T](key: String, value: T) = ComplexIssueInputFieldValue(Map(key -> value))

}
