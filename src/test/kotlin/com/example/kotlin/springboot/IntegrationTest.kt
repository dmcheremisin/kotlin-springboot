package com.example.kotlin.springboot

import com.example.kotlin.springboot.entities.Book
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import org.springframework.web.client.postForEntity

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IntegrationTest {
    private val restTemplate = RestTemplate();

    @BeforeAll
    fun setUp() {
        println(">> Startup")
    }

    @Test
    fun `Testing get all books`() {
        val entity = restTemplate.getForEntity<String>("http://localhost:8080/book")
        Assertions.assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
    }

    @Test
    fun `Test create new book`() {
        val entity =
                restTemplate.postForEntity<Any>("http://localhost:8080/book", Book(12, "sdfsdf", "first"))
        Assertions.assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
    }
//
//    @Test
//    fun `Test get book by name`() {
//        val entity =
//                restTemplate.postForEntity<Any>("http://localhost:8080/book", Book(12, "one", "one"))
//        Assertions.assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
//
//        val getEntity = restTemplate.getForEntity<String>("http://localhost:8080/book/one")
//        Assertions.assertThat(getEntity.statusCode).isEqualTo(HttpStatus.OK)
//    }

}