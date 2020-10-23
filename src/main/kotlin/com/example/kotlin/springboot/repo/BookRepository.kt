package com.example.kotlin.springboot.repo

import com.example.kotlin.springboot.entities.Book
import org.springframework.data.repository.CrudRepository

interface BookRepository: CrudRepository<Book, Long> {

    fun findByTitle(title: String): Book
}