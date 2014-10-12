package com.servicerocket.jira.rest.api.domain.input

import com.servicerocket.jira.rest.api.domain.Comment

/**
 * Input data used while transitioning an issue including new values for this issue and the optional comment.
 *
 * @since v0.1
 */
case class TransitionInput(
                            id: Long,
                            fields: Seq[FieldInput],
                            comment: Option[Comment] = None
                            )
