package com.servicerocket.jira.rest.api.domain.input

import com.servicerocket.jira.rest.api.domain.Identified

/** New value for selected field - used while changing issue fields - e.g. while transitioning issue.
  *
  * @since 0.1
  */
case class FieldInput(
                       id: String,
                       value: Any
                       )

  extends Identified[String]
