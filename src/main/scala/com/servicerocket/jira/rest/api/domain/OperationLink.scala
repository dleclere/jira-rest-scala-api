package com.servicerocket.jira.rest.api.domain

/** Represents operations link
  *
  * @since 0.1
  */
case class OperationLink(
                          id: Option[String],
                          styleClass: Option[String],
                          label: String,
                          title: Option[String],
                          href: String,
                          weight: Option[Int],
                          iconClass: Option[String])
  extends Operation {

  def accept[T](visitor: OperationVisitor[T]): Option[T] = visitor.visit(this)

}
