package com.example.library.library

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.*

@SpringBootApplication
@RestController
@RequestMapping(path=["/book"])
class LibraryServerApplication(repository: BookRepository) {

	private val bookService = BookService(repository)

	@GetMapping
	fun getAllBooks(): List<Book> {
		return bookService.getAllBooks()
	}

	@PostMapping
	fun addNewBook(@RequestBody book: Book) {
		bookService.addNewBook(book)
	}

	@DeleteMapping
	fun deleteBook(@RequestBody book: Book) {
		println("Hello")
		bookService.deleteBookByIsbn(book.isbn)
	}

	@PutMapping
	fun modifyBook(@RequestBody book: Book) {
		bookService.modifyBookInfo(book.isbn, book)
	}

	@GetMapping(path = ["{field}/{value}"])
	fun searchByField(
		@PathVariable("field") field: String,
		@PathVariable("value") value: String
	): List<Book> {
		return bookService.searchByField(field, value)
	}

}

fun main(args: Array<String>) {
	runApplication<LibraryServerApplication>(*args)
}
