package com.servicerocket.jira.rest.api.domain.input

import com.servicerocket.jira.rest.api.domain._
import com.servicerocket.jira.rest.api.domain.input.ValueTransformer.CanNotHandle

/** Transforms most of standard fields values into form understandable by input generator.
  *
  * @since v1.0
  */
class BaseValueTransformer extends ValueTransformer {

  def apply(rawValue: Any): Any = rawValue match {
    case null =>
      null
    case _: String | _: Int | _: Long | _: Float | _: Double | _: Boolean | _: ComplexIssueInputFieldValue =>
      rawValue
    case project: BasicProject =>
      ComplexIssueInputFieldValue(Map("key" -> project.key))
    case cfo: CustomFieldOption =>
      transformCustomFieldOption(cfo)
    case tracking: TimeTracking =>
      transformTimeTracking(tracking)
    case identifiableEntity: Identified[_] =>
      ComplexIssueInputFieldValue(Map("id" -> identifiableEntity.id.toString))
    case namedEntity: Named =>
      ComplexIssueInputFieldValue(Map("name" -> namedEntity.name))
    case _ =>
      CanNotHandle
  }

  private def transformCustomFieldOption(cfo: CustomFieldOption): ComplexIssueInputFieldValue =
    if (cfo.child.isDefined)
      ComplexIssueInputFieldValue(Map("id" -> cfo.id.toString, "value" -> cfo.value, "child" -> this(cfo.child.get)))
    else
      ComplexIssueInputFieldValue(Map("id" -> cfo.id.toString, "value" -> cfo.value))

  // TODO : Use immutable map
  private def transformTimeTracking(timeTracking: TimeTracking): ComplexIssueInputFieldValue = {
    var fields: collection.mutable.Map[String, String] = collection.mutable.Map()
    timeTracking.originalEstimateMinutes.foreach { originalEstimateMinutes =>
      fields += ("originalEstimate" -> s"${originalEstimateMinutes}m")
    }
    timeTracking.remainingEstimateMinutes.foreach { remainingEstimateMinutes =>
      fields += ("remainingEstimate" -> s"${remainingEstimateMinutes}m")
    }
    ComplexIssueInputFieldValue(fields.toMap)
  }

}
