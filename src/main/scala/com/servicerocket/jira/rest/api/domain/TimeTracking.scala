package com.servicerocket.jira.rest.api.domain

/** Represents time tracking information associated with given issue
  *
  * @since com.atlassian.jira.rest.client.api 0.3, server 4.4
  */
case class TimeTracking(
                    originalEstimateMinutes: Option[Int],
                    remainingEstimateMinutes: Option[Int],
                    timeSpentMinutes: Option[Int]
                    )