package com.ank.kotlinmongo.repository

import com.ank.kotlinmongo.model.Person
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Slice
import org.springframework.data.mongodb.repository.MongoRepository


interface PersonRepository : MongoRepository<Person, String> {

    fun findTop2ByOrderByAgeDesc(): List<Person>

    fun findTopByOrderByAgeDesc(): Person

    fun findAllByAgeGreaterThan(age: Int, pageable: Pageable): Slice<Person>

}