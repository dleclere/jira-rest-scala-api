package com.servicerocket.jira.rest.api.domain

import java.net.URI

/** Association between users and project roles.
  *
  * @since 0.1
  */
case class RoleActor(
                      id: Option[Long],
                      displayName: String,
                      `type`: String,
                      name: String,
                      avatarUrl: Option[URI]
                      )

  extends Named
  with Identified[Option[Long]] {
}

object RoleActor {

  /** Type of a role actor which associates a project with some particular user. */
  val AtlassianUserRoleType = "atlassian-user-role-actor"

  /** Type of a role actor which associates a project with a group of users, for instance: administrators, developers. */
  val AtlassianGroupRoleType = "atlassian-group-role-actor"

}
