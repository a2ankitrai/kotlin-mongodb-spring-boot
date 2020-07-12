package com.ank.kotlinmongo.model

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias

@TypeAlias("person")
data class Person(
        @Id
        var id: String?,
        var firstName: String?,
        var lastName: String?,
        var age: Int,
        var contactNumber: String?,
        var addresses: List<Address>?
) {
    constructor(firstName: String,
                lastName: String,
                age: Int,
                contactNumber: String,
                addresses: List<Address>
    ) : this("", firstName, lastName, age, contactNumber, addresses) {
        this.firstName = firstName
        this.lastName = lastName
        this.age = age
        this.contactNumber = contactNumber
        this.addresses = addresses
    }
}

data class Address(
        var houseNumber: String,
        var street: String,
        var city: String,
        var zipCode: String
)