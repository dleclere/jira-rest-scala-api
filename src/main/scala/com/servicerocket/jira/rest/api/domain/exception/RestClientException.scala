package com.servicerocket.jira.rest.api.domain.exception

import com.servicerocket.jira.rest.api.domain.ErrorCollection

/** Basic exception which may be thrown by any remote operation encapsulated by the REST com.atlassian.jira.rest.client.api.
  * Usually some more specific exception will be chained here and available via {@link #getCause()}
  *
  * @since v0.1
  */
case class RestClientException(
                                message: String,
                                cause: Option[Throwable] = None,
                                errorCollections: Seq[ErrorCollection] = Seq(),
                                statusCode: Option[Int] = None)

  extends RuntimeException
