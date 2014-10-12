package com.servicerocket.jira.rest.api.domain

case class Permissions(permissions: Iterable[Permission]) {

  private val permissionMap = permissions.map(permission => permission.key -> permission).toMap

  def permission(permissionKey: String) = permissionMap.get(permissionKey)

  def havePermission(permissionKey: String) = permission(permissionKey).fold(false)(_.havePermission)

}

object Permissions {

  /** Permission key for ability to log work done against an issue. Only useful if Time Tracking is turned on. */
  val WorkIssue = "WORK_ISSUE"

}
