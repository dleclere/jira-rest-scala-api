package com.servicerocket.jira.rest.api.domain

/** Represents a resource which can be expandable - that is REST API is capable of sending just the number
  * of child resources or when the entity is expanded, also the child resources themselves
  *
  * @since 0.1
  */
case class ExpandableProperty[T](
                                  size: Int,
                                  items: Option[Seq[T]] = None
                                  )
