package com.ank.kotlinmongo.service

import com.ank.kotlinmongo.repository.PersonRepository
import com.ank.kotlinmongo.util.TestUtil
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PersonServiceTest {

    @Autowired
    lateinit var personService: PersonService

    @Autowired
    lateinit var personRepository: PersonRepository

    @BeforeEach
    fun setup() {
        personRepository.deleteAll()
        personRepository.saveAll(TestUtil.getPersonList())
    }


    @Test
    fun testElders() {
        val p = personService.get2Elders()
        p.stream().forEach { it -> println(it.age) }
    }

    @Test
    fun testGetEldestPersonAge() {
        val p = personService.getEldestPersonAge();
        assert(p == 99)
    }

}