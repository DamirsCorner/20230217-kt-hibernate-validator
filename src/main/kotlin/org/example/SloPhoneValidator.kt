package org.example

import com.google.i18n.phonenumbers.NumberParseException
import com.google.i18n.phonenumbers.PhoneNumberUtil
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class SloPhoneValidator : ConstraintValidator<SloPhone, String> {
    override fun isValid(value: String?, constraintContext: ConstraintValidatorContext?): Boolean {
        if (value == null) {
            return true
        }

        val phoneUtil = PhoneNumberUtil.getInstance()

        return try {
            val slovenianNumberProto = phoneUtil.parse(value, "SI")
            phoneUtil.isValidNumber(slovenianNumberProto)
        } catch (e: NumberParseException) {
            false
        }
    }
}