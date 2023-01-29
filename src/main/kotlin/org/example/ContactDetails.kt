package org.example

import javax.validation.constraints.NotNull

class ContactDetails {
    @NotNull
    @SloPhone
    var mobilePhone: String? = null
    var workPhone: String? = null
}