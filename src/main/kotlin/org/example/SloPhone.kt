package org.example

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.annotation.AnnotationTarget.*
import kotlin.reflect.KClass

@Target(FIELD, FUNCTION, VALUE_PARAMETER, ANNOTATION_CLASS, TYPE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [SloPhoneValidator::class])
@MustBeDocumented
annotation class SloPhone(
    val message: String = "{org.example.validators.SloPhone.message}",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
