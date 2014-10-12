package com.servicerocket.jira.rest.client

import com.servicerocket.jira.rest.api.domain.Permissions
import com.servicerocket.jira.rest.api.domain.input.MyPermissionsInput

import scala.concurrent.Future

trait MyPermissionsRestClient {

  /** Returns permissions for current user and context defined by provided `permissionInput`.
    * - When no context supplied (everything is None inside permissionInput) the project related permissions
    * will return true if the user has that permission in ANY project.
    * - If a project context is provided, project related permissions will return true
    * if the user has the permissions in the specified project. For permissions
    * that are determined using issue data (e.g Current Assignee), true will be returned
    * if the user meets the permission criteria in ANY issue in that project.
    * - If an issue context is provided, it will return whether or not the user
    * has each permission in that specific issue.
    *
    * @param permissionInput Permissions context ie. projectKey OR projectId OR issueKey OR issueId.
    * @return Permissions for user in the context
    */
  def getMyPermissions(permissionInput: MyPermissionsInput): Future[Permissions]

}
