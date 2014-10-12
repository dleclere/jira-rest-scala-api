package com.servicerocket.jira.rest.api.domain

import java.net.URI

case class Subtask(
                    issueKey: String,
                    issueUri: URI,
                    summary: String,
                    issueType: IssueType,
                    status: Status
                    )
