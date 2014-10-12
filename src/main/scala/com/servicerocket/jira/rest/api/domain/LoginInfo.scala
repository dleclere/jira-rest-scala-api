package com.servicerocket.jira.rest.api.domain

import java.time.Instant

/** Statistics about logins (successful and failed logins number and last date) for the current user.
  *
  * @since v0.1
  */
case class LoginInfo(
                      failedLoginCount: Int,
                      loginCount: Int,
                      lastFailedLoginDate: Option[Instant],
                      previousLoginDate: Option[Instant]
                      )
