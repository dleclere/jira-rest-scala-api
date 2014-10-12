package com.servicerocket.jira.rest.api.domain

import java.net.URI

/** Represents number of issues which use given version in their FixVersion(s) and Affects Version fields.
  * This is mostly useful when presenting per-version basic issue stats or when about to remove given version completely.
  *
  * @since 0.1
  */
case class VersionRelatedIssuesCount(
                                      versionUri: URI,
                                      numFixedIssues: Int,
                                      numAffectedIssues: Int)
