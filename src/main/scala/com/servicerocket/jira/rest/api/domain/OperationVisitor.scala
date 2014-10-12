package com.servicerocket.jira.rest.api.domain

/** Interface visit operation elements.
  *
  * @since 0.1
  * @see Operations#accept(OperationVisitor)
  * @see Operation#accept(OperationVisitor)
  */
trait OperationVisitor[T] {

  /** Visits operation element
    *
    * @param operation operation element to be visited
    * @return Present value means "I've found a value let's finish visiting".
    *         If absent traversal through operation elements will be continued.
    */
  def visit(operation: Operation): Option[T]

}
