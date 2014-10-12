package com.servicerocket.jira.rest.api.domain

trait Operation {

  /** Returns Operation id.
    */
  def id: Option[String]

  /** Traverse through operation elements to visit them. Traversal will stop on first non absent value
    * returned from the visitor.
    *
    * @param visitor Visitor to visit operation element
    * @tparam T Visiting result type
    * @return Value returned from the visitor.
    */
  def accept[T](visitor: OperationVisitor[T]): Option[T]

}
