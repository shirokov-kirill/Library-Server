package com.example.library.library

import org.springframework.stereotype.Service

@Service
class BookService(private val repository: BookRepository) {

    fun getAllBooks(): List<Book> {
        return repository.findAll()
    }

    fun addNewBook(book: Book) {
        val otherBook = repository.findBookByIsbn(book.isbn)
        if(otherBook.isPresent) {
            throw IllegalStateException("This ISBN already added")
        }
        repository.save(book)
    }

    fun modifyBookInfo(isbn: String, book: Book) {
        deleteBookByIsbn(isbn)
        repository.save(book)
    }

    fun deleteBookByIsbn(isbn: String) {
        val otherBook = repository.findBookByIsbn(isbn)
        println(isbn)
        println(otherBook.isPresent)
        if(!otherBook.isPresent) {
            throw IllegalStateException("No book with such ISBN")
        }
        repository.deleteBookByIsbn(isbn)
    }

    fun searchByField(field: String, value: String): List<Book> {
        return when(field) {
            "id" -> repository.searchBooksById(value.toInt())
            "isbn" -> repository.searchBooksByIsbn(value)
            "title" -> repository.searchBooksByTitle(value)
            "author" -> repository.searchBooksByAuthor(value)
            "printYear" -> repository.searchBooksByYear(value.toInt())
            "readAlready" -> repository.searchBooksByIsRead(value.toBoolean())
            else -> throw IllegalStateException("No such field")
        }
    }
}