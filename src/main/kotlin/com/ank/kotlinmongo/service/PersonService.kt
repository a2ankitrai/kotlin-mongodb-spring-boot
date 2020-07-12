package com.ank.kotlinmongo.service

import com.ank.kotlinmongo.model.Person
import com.ank.kotlinmongo.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Slice
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.aggregation.Aggregation
import org.springframework.data.mongodb.core.aggregation.AggregationResults
import org.springframework.stereotype.Service
import java.util.*

interface PersonService {

    fun get2Elders(): List<Person>
    fun allPersons(): List<Person>
    fun allPersonsSlice(pageable: Pageable): Slice<Person>
    fun findByFirstName(): Optional<Person>
    fun findByContactNumber(): Person
    fun getEldestPersonAge(): Int

}

@Service("personService")
class PersonServiceImpl : PersonService {

    @Autowired
    lateinit var personRepository: PersonRepository

    @Autowired
    lateinit var mongoTemplate: MongoTemplate

    override fun get2Elders(): List<Person> =
            personRepository.findTop2ByOrderByAgeDesc()

    override fun allPersons(): List<Person> = personRepository.findAll()

    override fun allPersonsSlice(pageable: Pageable): Slice<Person> {
        return personRepository.findAllByAgeGreaterThan(15, pageable)
    }

    override fun findByFirstName(): Optional<Person> {
        TODO("Not yet implemented")
    }

    override fun findByContactNumber(): Person {
        TODO("Not yet implemented")
    }

    override fun getEldestPersonAge(): Int {

        /***
         * method 1:
         * */
//        var query = Query()
//        query.fields().include("age").exclude("id")
//        var result = mongoTemplate.find(
//                query.with(Sort.by(Sort.Direction.DESC,"age"))
//                        .limit(1), Person::class.java)
//        return result[0].age

        /***
         * method 2:
         * */
//        val result = personRepository.findTopByOrderByAgeDesc()
//        println(result)
//        return result.age

        /***
         * method 3: Aggregation
         * */
        val aggregation: Aggregation = Aggregation.newAggregation(
                Aggregation.sort(Sort.Direction.DESC,"age"),
                Aggregation.group("id").first("age").`as`("age")
        )

       val results: AggregationResults<Person>
        = mongoTemplate.aggregate(aggregation,"person", Person::class.java)

        println(results.mappedResults[0])
        return results.mappedResults[0].age

    }


}
