package com.servicerocket.jira.rest.api.domain

import java.net.URI

/** Information about current user "session" - or in case of the recommended stateless connection (really RESTful design)
  * just the information about the user and the user login data.
  *
  * @since 0.1
  */
case class Session(
                    userUri: URI,
                    username: String,
                    loginInfo: LoginInfo
                    )
