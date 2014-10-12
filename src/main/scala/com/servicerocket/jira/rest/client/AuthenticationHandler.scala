package com.servicerocket.jira.rest.client

/** Interface for classes which authenticate the requests. The configure method is invoked during each request.
  * For instance, the implementation of this handling which would configure the request to do a basic http authentication would
  * have a following implementation.
  *
  * Example:
  * {{{
  * public void configure(final Request request) {
  * request.setHeader("Authorization", "Basic " + base64EncodedCredentials());
  * }
  * }}}
  *
  * @since 0.1
  */
trait AuthenticationHandler[T] {

  def configure(request: T): T

}
