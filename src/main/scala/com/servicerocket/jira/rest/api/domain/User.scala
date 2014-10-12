package com.servicerocket.jira.rest.api.domain

import java.net.URI

/** Complete information about a single JIRA user
  *
  * @since 0.1
  */
case class User(
                 self: URI,
                 name: String,
                 displayName: String,
                 emailAddress: String,
                 groups: Option[ExpandableProperty[String]],
                 avatarUris: Map[String, URI],
                 timezone: Option[String]
                 )

  extends Resource
  with Named {

  val AvatarUri = getAvatarUri(AvatarSize.`48x48`)
  val SmallAvatarUri = getAvatarUri(AvatarSize.`16x16`)

  def getAvatarUri(sizeDefinition: String) = avatarUris.get(sizeDefinition)

}

object AvatarSize {

  val `16x16` = "16x16"
  var `48x48` = "48x48"

}
