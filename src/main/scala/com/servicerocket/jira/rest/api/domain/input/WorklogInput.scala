package com.servicerocket.jira.rest.api.domain.input

import java.time.Instant

import com.servicerocket.jira.rest.api.domain.{Worklog, BasicUser, Visibility}
import java.net.URI

/** Represents worklog item in JIRA. Is used to create new worklog or update existing one.
  * Contains also estimate adjustment options which are used only to adjust change of remaining
  * estimate (adjustEstimate and adjustEstimateValue).
  * Possible values for adjustEstimate and adjustEstimateValue are:
  *
  * - When adjustEstimate is set to [[com.servicerocket.jira.rest.api.domain.input.WorklogInput.AdjustEstimate.Auto]]
  * or [[com.servicerocket.jira.rest.api.domain.input.WorklogInput.AdjustEstimate.Leave]] adjustEstimateValue
  * is not used
  * - When adjustEstimate is set to [[com.servicerocket.jira.rest.api.domain.input.WorklogInput.AdjustEstimate.New]]
  * then remaining estimate is set to adjustEstimateValue
  * - When adjustEstimate is set to [[com.servicerocket.jira.rest.api.domain.input.WorklogInput.AdjustEstimate.Manual]]
  * then remaining estimate is reduced by adjustEstimateValue
  */
case class WorklogInput(
                         self: Option[URI],
                         issueUri: URI,
                         author: Option[BasicUser],
                         updateAuthor: Option[BasicUser],
                         comment: Option[String],
                         startDate: Instant,
                         minutesSpent: Int,
                         visibility: Option[Visibility],
                         adjustEstimate: Option[WorklogInput.AdjustEstimate.type] = None,
                         adjustEstimateValue: Option[String] = None)

object WorklogInput {

  def from(worklog: Worklog): WorklogInput = WorklogInput(
    Some(worklog.self),
    worklog.issueUri,
    Some(worklog.author),
    Some(worklog.updateAuthor),
    worklog.comment,
    worklog.startDate,
    worklog.minutesSpent,
    worklog.visibility
  )

  def from(worklog: Worklog, adjustEstimate: WorklogInput.AdjustEstimate.type, estimateValue: String): WorklogInput =
    from(worklog).copy(adjustEstimate = Some(adjustEstimate), adjustEstimateValue = Some(estimateValue))

  object AdjustEstimate extends Enumeration {
    type AdjustEstimate = Value

    val New = Value("new")
    val Leave = Value("leave")
    val Manual = Value("manual")
    val Auto = Value("auto")
  }

}
