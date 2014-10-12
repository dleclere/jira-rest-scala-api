package com.servicerocket.jira.rest.api.domain.input

/** Defines a new position for a project version (while moving it) by {@link com.atlassian.jira.rest.client.api.VersionRestClient#moveVersion(java.net.URI, VersionPosition)}
  *
  * @since 0.1
  */
object VersionPosition extends Enumeration {

  type VersionPosition = Value

  val First, Last, Earlier, later = Value

}
