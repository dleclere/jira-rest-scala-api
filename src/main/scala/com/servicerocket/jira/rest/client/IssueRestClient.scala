package com.servicerocket.jira.rest.client

import java.io.{File, InputStream}
import java.net.URI

import com.servicerocket.jira.rest.api.domain._
import com.servicerocket.jira.rest.api.domain.exception.RestClientException
import com.servicerocket.jira.rest.api.domain.input.IssueInput

import scala.concurrent.Future

/** REST API  client handling issue resources.
  *
  * @since 0.1
  */
trait IssueRestClient {

  /** Creates new issue.
    *
    * @param issue populated with data to create new issue
    * @return basicIssue with generated <code>issueKey</code>
    * @throws RestClientException in case of problems (connectivity, malformed messages, invalid argument, etc.)
    * @since com.atlassian.jira.rest.client.api 1.0, server 5.0
    */
  def createIssue(issue: IssueInput): Future[BasicIssue]

  /** Retrieves all CreateIssueMetadata.
    *
    * @return List of { @link com.atlassian.jira.rest.client.api.domain.CimProject} describing projects, issue types and fields.
    * @throws RestClientException in case of problems (connectivity, malformed messages, invalid argument, etc.)
    * @since com.atlassian.jira.rest.client.api 1.0, server 5.0
    */
  def getCreateIssueMetadata: Future[Seq[CimProject]] = getCreateIssueMetadata(None)

  /** Retrieves CreateIssueMetadata with specified filters.
    *
    * @param options Request configuration like filters and expandos.
    * @return List of { @link com.atlassian.jira.rest.client.api.domain.CimProject} describing projects, issue types and fields.
    * @throws RestClientException in case of problems (connectivity, malformed messages, invalid argument, etc.)
    * @since com.atlassian.jira.rest.client.api 1.0, server 5.0
    */
  def getCreateIssueMetadata(options: CreateIssueMetadataOptions): Future[Seq[CimProject]] = getCreateIssueMetadata(Some(options))

  /** Implementations of this trait should implements this method which is the actual implementation
    * behind two overloaded methods with the same name. Refer to their doc for more info.
    */
  protected def getCreateIssueMetadata(options: Option[CreateIssueMetadataOptions]): Future[Seq[CimProject]]

  /** Creates new issues in batch.
    *
    * @param issues populated with data to create new issue
    * @return BulkOperationResult<BasicIssues> with generated <code>issueKey</code> and errors for failed issues
    * @throws RestClientException in case of problems (connectivity, malformed messages, invalid argument, etc.)
    * @since com.atlassian.jira.rest.client.api 2.0, server 6.0
    */
  def createIssues(issues: Seq[IssueInput]): Future[BulkOperationResult[BasicIssue]]

  /** Retrieves issue with selected issue key.
    *
    * @param issueKey issue key (like TST-1, or JRA-9)
    * @return issue with given <code>issueKey</code>
    * @throws RestClientException in case of problems (connectivity, malformed messages, invalid argument, etc.)
    */
  def getIssue(issueKey: String): Future[Issue]

  /** Retrieves issue with selected issue key, with specified additional expandos.
    *
    * @param issueKey issue key (like TST-1, or JRA-9)
    * @param expand   additional expands. Currently CHANGELOG is the only supported expand that is not expanded by default.
    * @return issue with given <code>issueKey</code>
    * @throws RestClientException in case of problems (connectivity, malformed messages, invalid argument, etc.)
    * @since 0.6
    */
  def getIssue(issueKey: String, expand: Seq[IssueRestClient.Expandos.Expandos]): Nothing

  /** Deletes issue with given issueKey. You can set `deleteSubtasks` to delete issue with subtasks. If issue have
    * subtasks and `deleteSubtasks` is set to false, then issue won't be deleted.
    *
    * @param issueKey issue key (like TST-1, or JRA-9)
    * @param deleteSubtasks Determines if subtask of issue should be also deleted. If false, and issue has subtasks, then it
    *                       won't be deleted.
    * @return Void
    * @since 2.0
    */
  def deleteIssue(issueKey: String, deleteSubtasks: Boolean): Future[Boolean]

  /** Retrieves complete information (if the caller has permission) about watchers for selected issue.
    *
    * @param watchersUri URI of watchers resource for selected issue. Usually obtained by calling <code>Issue.getWatchers().getSelf()</code>
    * @return detailed information about watchers watching selected issue.
    * @throws RestClientException in case of problems (connectivity, malformed messages, invalid argument, etc.)
    * @see com.atlassian.jira.rest.client.api.domain.Issue#getWatchers()
    */
  def getWatchers(watchersUri: URI): Future[Watchers]

  /** Retrieves complete information (if the caller has permission) about voters for selected issue.
    *
    * @param votesUri URI of voters resource for selected issue. Usually obtained by calling <code>Issue.getVotesUri()</code>
    * @return detailed information about voters of selected issue
    * @throws RestClientException in case of problems (connectivity, malformed messages, invalid argument, etc.)
    * @see com.atlassian.jira.rest.client.api.domain.Issue#getVotesUri()
    */
  def getVotes(votesUri: URI): Future[Votes]

  /** Retrieves complete information (if the caller has permission) about transitions available for the selected issue in its current state.
    *
    * @param transitionsUri URI of transitions resource of selected issue. Usually obtained by calling <code>Issue.getTransitionsUri()</code>
    * @return transitions about transitions available for the selected issue in its current state.
    * @throws RestClientException in case of problems (connectivity, malformed messages, invalid argument, etc.)
    */
  def getTransitions(transitionsUri: URI): Future[Seq[Transition]]

  /** Retrieves complete information (if the caller has permission) about transitions available for the selected issue in its current state.
    *
    * @param issue issue
    * @return transitions about transitions available for the selected issue in its current state.
    * @throws RestClientException in case of problems (connectivity, malformed messages, invalid argument, etc.)
    * @since v0.5
    */
  def getTransitions(issue: Issue): Future[Seq[Transition]]

  /** Performs selected transition on selected issue.
    *
    * @param transitionsUri  URI of transitions resource of selected issue. Usually obtained by calling <code>Issue.getTransitionsUri()</code>
    * @param transitionInput data for this transition (fields modified, the comment, etc.)
    * @throws RestClientException in case of problems (connectivity, malformed messages, invalid argument, etc.)
    */
  def transition(transitionsUri: URI, transitionInput: Nothing): Future[Boolean]

  /** Performs selected transition on selected issue.
    *
    * @param issue           selected issue
    * @param transitionInput data for this transition (fields modified, the comment, etc.)
    * @throws RestClientException in case of problems (connectivity, malformed messages, invalid argument, etc.)
    * @since v0.5
    */
  def transition(issue: Issue, transitionInput: Nothing): Future[Boolean]

  /** Casts your vote on the selected issue. Casting a vote on already votes issue by the caller, causes the exception.
    *
    * @param votesUri URI of votes resource for selected issue. Usually obtained by calling <code>Issue.getVotesUri()</code>
    * @throws RestClientException in case of problems (connectivity, malformed messages, invalid argument, etc.)
    */
  def vote(votesUri: URI): Future[Boolean]

  /** Removes your vote from the selected issue. Removing a vote from the issue without your vote causes the exception.
    *
    * @param votesUri URI of votes resource for selected issue. Usually obtained by calling <code>Issue.getVotesUri()</code>
    * @throws RestClientException in case of problems (connectivity, malformed messages, invalid argument, etc.)
    */
  def unvote(votesUri: URI): Future[Boolean]

  /** Starts watching selected issue
    *
    * @param watchersUri URI of watchers resource for selected issue. Usually obtained by calling <code>Issue.getWatchers().getSelf()</code>
    * @throws RestClientException in case of problems (connectivity, malformed messages, invalid argument, etc.)
    */
  def watch(watchersUri: URI): Future[Boolean]

  /** Stops watching selected issue
    *
    * @param watchersUri URI of watchers resource for selected issue. Usually obtained by calling <code>Issue.getWatchers().getSelf()</code>
    * @throws RestClientException in case of problems (connectivity, malformed messages, invalid argument, etc.)
    */
  def unwatch(watchersUri: URI): Future[Boolean]

  /** Adds selected person as a watcher for selected issue. You need to have permissions to do that (otherwise
    * the exception is thrown).
    *
    * @param watchersUri URI of watchers resource for selected issue. Usually obtained by calling <code>Issue.getWatchers().getSelf()</code>
    * @param username    user to add as a watcher
    * @throws RestClientException in case of problems (connectivity, malformed messages, invalid argument, etc.)
    */
  def addWatcher(watchersUri: URI, username: String): Future[Boolean]

  /** Removes selected person from the watchers list for selected issue. You need to have permissions to do that (otherwise
    * the exception is thrown).
    *
    * @param watchersUri URI of watchers resource for selected issue. Usually obtained by calling <code>Issue.getWatchers().getSelf()</code>
    * @param username    user to remove from the watcher list
    * @throws RestClientException in case of problems (connectivity, malformed messages, invalid argument, etc.)
    */
  def removeWatcher(watchersUri: URI, username: String): Future[Boolean]

  /** Creates link between two issues and adds a comment (optional) to the source issues.
    *
    * @param linkIssuesInput details for the link and the comment (optional) to be created
    * @throws RestClientException in case of problems (connectivity, malformed messages, invalid argument, permissions, etc.)
    * @since com.atlassian.jira.rest.client.api 0.2, server 4.3
    */
  def linkIssue(linkIssuesInput: Nothing): Future[Boolean]

  /** Uploads attachments to JIRA (adding it to selected issue)
    *
    * @param attachmentsUri where to upload the attachment. You can get this URI by examining issue resource first
    * @param in             stream from which to read data to upload
    * @param filename       file name to use for the uploaded attachment
    * @since com.atlassian.jira.rest.client.api 0.2, server 4.3
    */
  def addAttachment(attachmentsUri: URI, in: InputStream, filename: String): Future[Boolean]

  /** Uploads attachments to JIRA (adding it to selected issue)
    *
    * @param attachmentsUri where to upload the attachments. You can get this URI by examining issue resource first
    * @param attachments    attachments to upload
    * @since com.atlassian.jira.rest.client.api 0.2, server 4.3
    */
  def addAttachments(attachmentsUri: URI, attachments: Nothing*): Future[Boolean]

  /** Uploads attachments to JIRA (adding it to selected issue)
    *
    * @param attachmentsUri where to upload the attachments. You can get this URI by examining issue resource first
    * @param files          files to upload
    * @since com.atlassian.jira.rest.client.api 0.2, server 4.3
    */
  def addAttachmentsFromFiles(attachmentsUri: URI, files: File*): Future[Boolean]

  /** Adds a comment to JIRA (adding it to selected issue)
    *
    * @param commentsUri where to add comment
    * @param comment     the { @link com.atlassian.jira.rest.client.api.domain.Comment} to add
    * @since com.atlassian.jira.rest.client.api 1.0, server 5.0
    */
  def addComment(commentsUri: URI, comment: Comment): Future[Boolean]

  /** Retrieves the content of given attachment.
    *
    * @param attachmentUri URI for the attachment to retrieve
    * @return stream from which the caller may read the attachment content (bytes). The caller is responsible for closing the stream.
    */
  def getAttachment(attachmentUri: URI): Future[InputStream]

  /** Adds new worklog entry to issue.
    *
    * @param worklogUri   URI for worklog in issue
    * @param worklogInput worklog input object to create
    */
  def addWorklog(worklogUri: URI, worklogInput: Nothing): Future[Boolean]
}

object IssueRestClient {

  /** Expandos supported by [[IssueRestClient.getIssue( S t r i n g, I t e r a b l e )]]
    */
  object Expandos extends Enumeration {
    type Expandos = Value

    val Changelog = Value("changelog")
    val Operations = Value("operations")
    val Schema = Value("schema")
    val Names = Value("names")
    val Transitions = Value("transitions")
  }

}
