package com.servicerocket.jira.rest.api.domain

/** Keeps field id that may be used to refer to field in fields maps.
  *
  * @since 0.1
  */
object IssueFieldId extends Enumeration {

  type IssueFieldId = Value

  /** Returns all fields ids.
    *
    * @return List of string id of each field.
    */
  def ids = IssueFieldId.values.map(_.toString)

  val AffectsVersions = Value("versions")
  val Assignee = Value("assignee")
  val Attachment = Value("attachment")
  val Comment = Value("comment")
  val Components = Value("components")
  val Created = Value("created")
  val Description = Value("description")
  val DueDate = Value("duedate")
  val FixVersions = Value("fixVersions")
  val IssueType = Value("issuetype")
  val Labels = Value("labels")
  val Links = Value("links")
  val Priority = Value("priority")
  val Project = Value("project")
  val Reporter = Value("reporter")
  val Resolution = Value("resolution")
  val Status = Value("status")
  val Subtasks = Value("subtasks")
  val Summary = Value("summary")
  val TimeTracking = Value("timetracking")
  val Transitions = Value("transitions")
  val Updated = Value("updated")
  val Votes = Value("votes")
  val Watches = Value("watches")
  val Worklog = Value("worklog")
  val Worklogs = Value("worklogs")

}
