package org.example

import io.quarkus.hibernate.validator.ValidatorFactoryCustomizer
import org.hibernate.validator.BaseHibernateValidatorConfiguration
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class ContactDetailsValidatorFactoryCustomizer : ValidatorFactoryCustomizer {
    override fun customize(configuration: BaseHibernateValidatorConfiguration<*>) {
        val constraintMapping = configuration.createConstraintMapping()

        constraintMapping
            .type(ContactDetails::class.java)
                .field(ContactDetails::workPhone.name)
                    .constraint(SloPhoneDef())

        configuration.addMapping(constraintMapping)
    }
}
