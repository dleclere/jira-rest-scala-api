package com.servicerocket.jira.rest.api.domain

/** Represents search results - links to issues matching given filter (JQL query) with basic
  * information supporting the paging through the results.
  *
  * @since 0.1
  */
case class SearchResult(
                         startIndex: Int,
                         maxResults: Int,
                         total: Int,
                         issues: Seq[Issue]
                         )
