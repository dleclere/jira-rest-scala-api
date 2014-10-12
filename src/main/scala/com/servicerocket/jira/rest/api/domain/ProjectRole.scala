package com.servicerocket.jira.rest.api.domain

import java.net.URI

/** A way to group users (@see RoleActors) with projects. An example would be a global role called "testers". If you
  * have a project X and a project Y, you would then be able to configure different RoleActors in the "testers" role
  * for project X than for project Y. You can use ProjectRole objects as the target of Notification and Permission
  * schemes.
  *
  * @see com.atlassian.jira.security.roles.ProjectRole
  */
case class ProjectRole(
                        id: Option[Long],
                        self: URI,
                        name: String,
                        description: String,
                        actors: Seq[RoleActor]
                        )

  extends Resource
  with Named
  with Identified[Option[Long]]
