package com.servicerocket.jira.rest.api.domain.input

/** This exception is thrown by ValueTransformerManager when there is not transformer that can transform given value.
 *
 * @since 0.1
 */
case class CannotTransformValueException(message: String) extends RuntimeException