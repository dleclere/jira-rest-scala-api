package com.servicerocket.jira.rest.api.domain

import java.net.URI
import java.time.{Instant, LocalDate}

/** Single JIRA issue
  *
  * @since v0.1
  */
case class Issue(
                  summary: String,
                  self: URI,
                  key: String,
                  id: Long,
                  project: BasicProject,
                  issueType: IssueType, status: Status,
                  description: String,
                  priority: Option[BasicPriority],
                  resolution: Option[Resolution],
                  attachments: Seq[Attachment],
                  reporter: Option[User],
                  assignee: Option[User],
                  creationDate: Instant,
                  updateDate: Instant,
                  dueDate: LocalDate,
                  affectedVersions: Seq[Version],
                  fixVersions: Seq[Version],
                  components: Seq[BasicComponent],
                  timeTracking: Option[TimeTracking],
                  issueFields: Seq[IssueField],
                  comments: Seq[Comment],
                  transitionsUri: Option[URI],
                  issueLinks: Option[Seq[IssueLink]],
                  votes: BasicVotes,
                  worklogs: Seq[Worklog],
                  watchers: BasicWatchers,
                  expandos: Iterable[String],
                  subtasks: Option[Seq[Subtask]],
                  changelog: Option[Seq[ChangelogGroup]],
                  operations: Option[Operations],
                  labels: Set[String]
                  )

  extends Expandable
  with Resource
  with Identified[Long] {

  def getField(id: String) = issueFields find (_.id == id)

  def getFieldByName(name: String) = issueFields find (_.name == name)

}
