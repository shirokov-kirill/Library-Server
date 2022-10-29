package com.example.library.library

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BookConfig {

    @Bean
    fun commandLineRunner(bookRepository: BookRepository) = CommandLineRunner {
        val firstBook = Book(
            _title = "Hello world",
            _description = "About this world",
            _author = "Kirill",
            _isbn = "kfjgkgdf-45-jfk-34",
            _printYear = 2022,
            _readAlready = false
        )

        val secondBook = Book(
            _title = "Hello world 2",
            _description = "About this world, second part",
            _author = "Kirill",
            _isbn = "kfjgkgdf-45-jfk-35",
            _printYear = 2022,
            _readAlready = false
        )

        bookRepository.saveAll(
            listOf(firstBook, secondBook)
        )
    }

}