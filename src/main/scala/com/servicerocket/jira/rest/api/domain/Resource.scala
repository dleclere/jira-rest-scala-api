package com.servicerocket.jira.rest.api.domain

import java.net.URI

/** A REST resource.
  *
  * All REST resources should implement this interface.
  */
trait Resource {

  def self: URI

}


/** A named entity.
  *
  * All REST resources having a name should implement this interface.
  */
trait Named {

  def name: String

}

/** This trait should be mixed into all entities having a unique ID field.
  *
  * @tparam T Generic type of Id.
  **/
trait Identified[+T] {

  def id: T

}

/** An Expandable resource. */
trait Expandable {

  def expandos: Iterable[String]

}
