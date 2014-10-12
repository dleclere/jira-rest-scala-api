package com.servicerocket.jira.rest.api.domain.input

import java.time.LocalDate

import com.servicerocket.jira.rest.api.domain._

/** Represents new JIRA issue
  *
  * @since v1.0
  */

case class IssueInput(fields: Map[String, FieldInput] = Map()) {

  def withField(field: FieldInput): IssueInput = copy(fields + (field.id -> field))

  def withField(id: String, value: Any): IssueInput = withField(FieldInput(id, value))

  def withComplexField(id: String, value: ComplexIssueInputFieldValue): IssueInput = withField(FieldInput(id, value))

  @throws(classOf[CannotTransformValueException])
  def withTransformedField(id: String, value: Any)(implicit valueTransformerManager: ValueTransformerManager): IssueInput =
    withField(id, valueTransformerManager(value))

  def withSummary(summary: String) = withField(IssueFieldId.Summary.toString, summary)

  def withProjectKey(projectKey: String) = withComplexField(IssueFieldId.Project.toString, ComplexIssueInputFieldValue.from("key", projectKey))

  def withProject(project: BasicProject) = withProjectKey(project.key)

  def withIssueTypeId(issueTypeId: Long) = withComplexField(IssueFieldId.IssueType.toString, ComplexIssueInputFieldValue.from("id", issueTypeId.toString))

  def withIssueType(issueType: IssueType) = withIssueTypeId(issueType.id)

  def withDescription(summary: String) = withField(IssueFieldId.Description.toString, summary)

  def withAssigneeName(assignee: String) = withComplexField(IssueFieldId.Assignee.toString, ComplexIssueInputFieldValue.from("name", assignee))

  def withAssignee(assignee: BasicUser) = withAssigneeName(assignee.name)

  def withAffectedVersionsNames(names: Seq[String]) = withField(IssueFieldId.AffectsVersions.toString, names.map(ComplexIssueInputFieldValue.from("name", _)))

  def withAffectedVersions(versions: Seq[Version]) = withAffectedVersionsNames(versions.map(_.name))

  def withComponentsNames(names: Seq[String]) = withField(IssueFieldId.Components.toString, names.map(ComplexIssueInputFieldValue.from("name", _)))

  def withComponents(basicComponents: BasicComponent*): IssueInput = withComponentsNames(basicComponents.map(_.name))

  def withDueDate(date: LocalDate) = withField(FieldInput(IssueFieldId.DueDate.toString, date))

  def withFixVersionsNames(names: Seq[String]) = withField(IssueFieldId.FixVersions.toString, names.map(ComplexIssueInputFieldValue.from("name", _)))

  def withFixVersions(versions: Seq[Version]) = withFixVersionsNames(versions.map(_.name))

  def withPriorityId(id: Long) = withField(IssueFieldId.Priority.toString, ComplexIssueInputFieldValue.from("id", s"$id"))

  def withPriority(priority: BasicPriority) = withPriorityId(priority.id)

  def withReporterName(reporterName: String) = withField(IssueFieldId.Reporter.toString, ComplexIssueInputFieldValue.from("name", reporterName))

  def withReporter(reporter: BasicUser) = withReporterName(reporter.name)

}

object IssueInput {

  def withFields(fields: FieldInput*) = IssueInput(fields.map(field => field.id -> field).toMap)

}
