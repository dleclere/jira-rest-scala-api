package com.servicerocket.jira.rest.api.domain

import java.net.URI

/** Represents Custom Field Option
  *
  * @since 0.1
  */
case class CustomFieldOption(
                              id: Long,
                              self: URI,
                              value: String,
                              children: Iterable[CustomFieldOption],
                              child: Option[CustomFieldOption]
                              )

  extends Resource
  with Identified[Long]