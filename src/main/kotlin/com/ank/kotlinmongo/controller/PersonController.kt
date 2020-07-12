package com.ank.kotlinmongo.controller

import com.ank.kotlinmongo.model.Person
import com.ank.kotlinmongo.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonController {

    @Autowired
    lateinit var personService: PersonService

    @GetMapping("/personNames")
    fun getAllPersons(): List<Person> =
            personService.allPersons()

    @GetMapping("/elderPersons")
    fun getElders(): List<Person> = personService.get2Elders()

    @GetMapping("/eldestPersonAge")
    fun getEldestPersonAge(): Int = personService.getEldestPersonAge()

    @GetMapping("/allPersonsSlice")
    fun list(@RequestParam("page", required = false, defaultValue = "0") page: Int,
             @RequestParam("size", required = false, defaultValue = "5") pageSize: Int): List<Person> {

        val slice = personService
                .allPersonsSlice(PageRequest.of(page, pageSize,
                        Sort.by(Sort.Direction.DESC, "age")))
        return slice.content

    }


}