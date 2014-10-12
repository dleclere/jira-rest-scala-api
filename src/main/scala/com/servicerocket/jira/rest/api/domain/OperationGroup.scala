package com.servicerocket.jira.rest.api.domain

/** Represents operations group
  *
  * @since 0.1
  */
case class OperationGroup(
                           id: Option[String],
                           links: Seq[OperationLink],
                           groups: Seq[OperationGroup],
                           header: Option[OperationHeader],
                           weight: Option[Int]
                           )

  extends Operation {

  def accept[T](visitor: OperationVisitor[T]): Option[T] = {
    val result = visitor.visit(this)
    result.orElse {
      val operations = header.fold(links ++ groups)(header => header +: (links ++ groups))
      OperationGroup.accept(operations, visitor)
    }
  }

}

object OperationGroup {

  def accept[T](operations: Iterable[Operation], visitor: OperationVisitor[T]): Option[T] =
    operations.map(_.accept[T](visitor)).find(_.isDefined).flatten

}
