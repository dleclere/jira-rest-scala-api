package com.servicerocket.jira.rest.client

import java.net.URI
import com.servicerocket.jira.rest.api.domain.exception.RestClientException
import com.servicerocket.jira.rest.api.domain.{Version, VersionRelatedIssuesCount}
import com.servicerocket.jira.rest.api.domain.input.{VersionInput, VersionPosition}

import scala.concurrent.Future

/** The com.atlassian.jira.rest.client.api responsible for Project version(s) related operations
  *
  * @since 0.1
  */
trait VersionRestClient {

  /** Retrieves full information about selected project version
    *
    * @param versionUri URI of the version to retrieve. You can get it for example from Project or it can be
    *                   referenced from an issue.
    * @return full information about selected project version
    * @throws RestClientException in case of problems (connectivity, malformed messages, etc.)
    */
  def getVersion(versionUri: URI): Future[Version]

  /** Creates a new version (which logically belongs to a project)
    *
    * @param version details about version to create
    * @return newly created version
    * @throws RestClientException in case of problems (connectivity, malformed messages, etc.)
    */
  def createVersion(version: VersionInput): Future[Version]

  /** Updates selected version with a new details.
    *
    * @param versionUri   full URI to the version to update
    * @param versionInput new details of the version. <code>null</code> fields will be ignored
    * @return newly updated version
    * @throws RestClientException in case of problems (connectivity, malformed messages, etc.)
    */
  def updateVersion(versionUri: URI, versionInput: VersionInput): Future[Version]

  /**
   * Removes selected version optionally changing Fix Version(s) and/or Affects Version(s) fields of related issues.
   *
   * @param versionUri                     full URI to the version to remove
   * @param moveFixIssuesToVersionUri      URI of the version to which issues should have now set their Fix Version(s)
   *                                       field instead of the just removed version. Use <code>null</code> to simply clear Fix Version(s) in all those issues
   *                                       where the version removed was referenced.
   * @param moveAffectedIssuesToVersionUri URI of the version to which issues should have now set their Affects Version(s)
   *                                       field instead of the just removed version. Use <code>null</code> to simply clear Affects Version(s) in all those issues
   *                                       where the version removed was referenced.
   * @throws RestClientException in case of problems (connectivity, malformed messages, etc.)
   */
  def removeVersion(versionUri: URI, moveFixIssuesToVersionUri: Option[URI], moveAffectedIssuesToVersionUri: Option[URI]): Future[Boolean]

  /** Retrieves basic statistics about issues which have their Fix Version(s) or Affects Version(s) field
    * pointing to given version.
    *
    * @param versionUri full URI to the version you want to get related issues count for
    * @return basic stats about issues related to given version
    * @throws RestClientException in case of problems (connectivity, malformed messages, etc.)
    */
  def getVersionRelatedIssuesCount(versionUri: URI): Future[VersionRelatedIssuesCount]

  /**
   * Retrieves number of unresolved issues which have their Fix Version(s) field
   * pointing to given version.
   *
   * @param versionUri full URI to the version you want to get the number of unresolved issues for
   * @return number of unresolved issues having this version included in their Fix Version(s) field.
   * @throws RestClientException in case of problems (connectivity, malformed messages, etc.)
   */
  def getNumUnresolvedIssues(versionUri: URI): Future[Int]

  /** Moves selected version after another version. Ordering of versions is important on various reports and whenever
    * input version fields are rendered by JIRA.
    * If version is already immediately after the other version (defined by <code>afterVersionUri</code>) then
    * such call has no visual effect.
    *
    * @param versionUri      full URI to the version to move
    * @param afterVersionUri URI of the version to move selected version after
    * @return just moved version
    * @throws RestClientException in case of problems (connectivity, malformed messages, etc.)
    */
  def moveVersionAfter(versionUri: URI, afterVersionUri: URI): Future[Version]

  /** Moves selected version to another position.
    * If version already occupies given position (e.g. is the last version and we want to move to a later position or to the last position)
    * then such call does not change anything.
    *
    * @param versionUri      full URI to the version to move
    * @param versionPosition defines a new position of selected version
    * @return just moved version
    * @throws RestClientException in case of problems (connectivity, malformed messages, etc.)
    */
  def moveVersion(versionUri: URI, versionPosition: VersionPosition.type): Future[Version]

}
