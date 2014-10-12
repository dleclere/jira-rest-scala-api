package com.servicerocket.jira.rest.api.domain

import java.time.Instant

/** Represents Issue change history group
  *
  * @since 0.1
  */
case class ChangelogGroup(author: BasicUser,
                          created: Instant,
                          items: Iterable[ChangelogItem])
