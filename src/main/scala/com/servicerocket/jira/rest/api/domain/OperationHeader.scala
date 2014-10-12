package com.servicerocket.jira.rest.api.domain

/** Represents operations header
  *
  * @since 0.1
  */
case class OperationHeader(
                            id: Option[String],
                            label: String,
                            title: Option[String], iconClass: Option[String]
                            )

  extends Operation {

  def accept[T](visitor: OperationVisitor[T]): Option[T] = visitor.visit(this)

}
