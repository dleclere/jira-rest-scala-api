package com.servicerocket.jira.rest.api.domain.input

import com.servicerocket.jira.rest.client.MyPermissionsRestClient

/**
 * Permissions context for [[MyPermissionsRestClient]]
 */
case class MyPermissionsInput(
                               projectKey: Option[String] = None,
                               projectId: Option[Long] = None,
                               issueKey: Option[String] = None,
                               issueId: Option[Long] = None
                               )
