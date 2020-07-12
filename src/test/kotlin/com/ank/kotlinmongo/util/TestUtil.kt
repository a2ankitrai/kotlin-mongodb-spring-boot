package com.ank.kotlinmongo.util

import com.ank.kotlinmongo.model.Address
import com.ank.kotlinmongo.model.Person

class TestUtil {

    companion object {

        fun getPersonList(): List<Person>{
            return listOf(person1, person2, person3, person4)
        }

        private val address =
                listOf(
                        Address("12", "WestWick", "Glasgow", "123"),
                        Address("13", "Shadow", "London", "343"),
                        Address("14", "Genesis", "Paris", "545"),
                        Address("15", "Harlem", "Delhi", "564"),
                        Address("16", "Melania", "Moscow", "933"),
                        Address("17", "Hawaii", "Dubai", "453"),
                        Address("18", "North", "Bali", "223"),
                        Address("19", "Clot", "NewYork", "634")
                )
        private val person1 = Person(firstName = "James",
                lastName = "Moriarty",
                age = 32,
                contactNumber = "347879",
                addresses = listOf(address[0])
        )

        private val person2 = Person(firstName = "Hanes",
                lastName = "Kreto",
                age = 19,
                contactNumber = "980343",
                addresses = listOf(address[1], address[3])
        )

        private val person3 = Person(firstName = "Melda",
                lastName = "Christ",
                age = 99,
                contactNumber = "991234",
                addresses = listOf(address[6], address[7])
        )

        private val person4 = Person(firstName = "Brute",
                lastName = "Force",
                age = 39,
                contactNumber = "1231324",
                addresses = listOf(address[2],address[4], address[5])
        )

    }

}