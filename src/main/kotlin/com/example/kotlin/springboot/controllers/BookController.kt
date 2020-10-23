package com.example.kotlin.springboot.controllers

import com.example.kotlin.springboot.entities.Book
import com.example.kotlin.springboot.repo.BookRepository
import org.springframework.web.bind.annotation.*

@RestController
class BookController(val repo: BookRepository)
{

    @PostMapping("/book")
    fun addBooks(@RequestBody book: Book){
        repo.save(book);
    }

    @GetMapping("/book")
    fun getAllBooks() = repo.findAll()

    @GetMapping("/book/{title}")
    fun getBookByTitle(@PathVariable title: String) = repo.findByTitle(title)

}