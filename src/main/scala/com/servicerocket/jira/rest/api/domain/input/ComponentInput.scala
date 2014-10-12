package com.servicerocket.jira.rest.api.domain.input

import com.servicerocket.jira.rest.api.domain.AssigneeType

/** Details about project component to be created or updated;
  *
  * @since com.atlassian.jira.rest.client.api 0.3, server 4.4
  */
class ComponentInput(
                      name: Option[String] = None,
                      description: Option[String] = None,
                      leadUsername: Option[String],
                      assigneeType: Option[AssigneeType]
                      )
