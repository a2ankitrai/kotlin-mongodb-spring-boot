package com.ank.kotlinmongo.repository

import com.ank.kotlinmongo.model.Person
import com.ank.kotlinmongo.util.TestUtil
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    lateinit var personRepository: PersonRepository

    @AfterEach
    fun clear() = personRepository.deleteAll()

    @Test
    fun saveAndGet() {

        val person: Person = TestUtil.getPersonList().random()

        personRepository.save(person)

        val response = personRepository.findAll()[0]

        assert(response.firstName == person.firstName)
        assert(response.lastName == person.lastName)
        assert(response.age == person.age)
        assert(response.contactNumber == person.contactNumber)

    }

    @Test
    fun saveAll() {

        personRepository.saveAll(TestUtil.getPersonList())

        val response = personRepository.findAll()

        assert(response.size == 4)

        for (p in response) {
            println(p)
        }

    }


}