package com.servicerocket.jira.rest.api.domain.input

import com.servicerocket.jira.rest.api.domain.input.ValueTransformer.CanNotHandle

trait ValueTransformer {

  /** Transforms given object into other representation, that can be used as input for field value generators.
    *
    * @param from Source object.
    * @return The resulting object or { @link ValueTransformer#CANNOT_HANDLE} when given value cannot be transformed.
    */
  def apply(from: Any): Any

}

/** Implement this interface if you want to provide your own value transformer to ValueTransformerManager.<br/>
  * You should return [[com.servicerocket.jira.rest.api.domain.input.ValueTransformer.CanNotHandle]]
  * when implemented transformer cannot transform given value.<br/>
  *
  * @since v1.0
  */

object ValueTransformer {

  case object CanNotHandle

}

/** This class allows to register [[com.servicerocket.jira.rest.api.domain.input.ValueTransformer]] objects and
  * then perform value transformation using registered transformers by
  * invoking `apply` method on it
  *
  * @since 0.1
  */
case class ValueTransformerManager(transformers: Seq[ValueTransformer] = Seq()) {

  /** Registers a new transformer at the end of list so it will be processed after existing transformers.
    *
    * @param transformer Transformer to register
    * @return this
    */
  def withTransformer(transformer: ValueTransformer) = copy(transformers = transformers :+ transformer)

  /** Registers new transformer at the beginning of list so it will be processed before existing transformers.
    *
    * @param transformer Transformer to register
    * @return this
    */
  def withTransformerAsFirst(transformer: ValueTransformer) = copy(transformers = transformer +: transformers)

  /** Use registered transformers to transform given value.
    *
    * Infinite recursion possible!! // TODO : Use a better pattern.
    *
    * @param rawInput Value to transform
    * @return transformed value
    * @throws CannotTransformValueException when any of available transformers was able to transform given value
    */
  def apply(rawInput: Any): Any = {
    if (rawInput.isInstanceOf[Iterable[_]]) {
      val rawInputObjects: Iterable[AnyRef] = rawInput.asInstanceOf[Iterable[AnyRef]]
      return rawInputObjects.map(apply(_))
    }
    transformers.toStream.map(_(rawInput)).find {
      case CanNotHandle => false
      case _ => true
    }.getOrElse(
        throw CannotTransformValueException(
          s"Any of available transformers was able to transform given value. Value is: ${if (rawInput == null) "NULL" else rawInput.getClass.getName + ": " + rawInput.toString}"))
  }

}
