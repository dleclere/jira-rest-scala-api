package com.servicerocket.jira.rest.api.domain

import java.net.URI

/** Basic information about a JIRA project's role.
  *
  * @since 0.1
  */
case class BasicProjectRole(self: URI,
                            name: String) extends Resource with Named