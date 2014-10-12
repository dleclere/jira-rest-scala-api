package com.servicerocket.jira.rest.api.domain

/** Helper class for entities.
  *
  * With a functional language like Scala, ideally we won't need this helper.
  * // TODO : Remove this helper
  *
  * @since 0.1
  */
object EntityHelper {

  def toNamesList(items: Seq[Named]) = items.map(_.name)

  def toFileNamesList(attachments: Seq[Attachment]) = attachments.map(_.filename)

  def toStringIdList[T](items: Seq[Identified[T]]) = items.map(_.id).map(_.toString)

  def findEntityByName(entities: Seq[Named], name: String) = entities.find(_.name == name)

  def findEntityBId[T](entities: Seq[Identified[T]], id: T) = entities.find(_.id == id)

  def findAttachmentByFileName(attachments: Seq[Attachment], fileName: String) = attachments.find(_.filename == fileName)

}
