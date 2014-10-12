package com.servicerocket.jira.rest.api.domain

/** Cookie used for maintaining the session for this user
  *
  * @since 0.1
  */
case class SessionCookie(
                          name: String,
                          value: String
                          )

  extends Named