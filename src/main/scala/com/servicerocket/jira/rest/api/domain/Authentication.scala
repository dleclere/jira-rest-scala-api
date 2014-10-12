package com.servicerocket.jira.rest.api.domain

/** Basic Authentication information of the current user session (if the connection maintains the session)
  * or just authentication info from the last remote call (when the connection is stateless - usually
  * recommended for genuine REST designs).
  *
  * @since 0.1
  */
case class Authentication(loginInfo: LoginInfo,
                          sessionCookie: SessionCookie)