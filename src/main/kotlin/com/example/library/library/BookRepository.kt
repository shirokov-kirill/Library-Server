package com.example.library.library

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional
import javax.transaction.Transactional

@Repository
interface BookRepository: JpaRepository<Book, Int>  {

    @Query("SELECT b FROM Book b WHERE b._isbn = ?1")
    fun findBookByIsbn(isbn: String): Optional<Book>

    @Transactional
    @Modifying
    @Query("DELETE FROM Book b WHERE b._isbn = ?1")
    fun deleteBookByIsbn(isbn: String)

    @Query("SELECT b FROM Book b WHERE b._author = ?1")
    fun searchBooksByAuthor(value: String): List<Book>

    @Query("SELECT b FROM Book b WHERE b._title = ?1")
    fun searchBooksByTitle(value: String): List<Book>

    @Query("SELECT b FROM Book b WHERE b._printYear = ?1")
    fun searchBooksByYear(value: Int): List<Book>

    @Query("SELECT b FROM Book b WHERE b._isbn = ?1")
    fun searchBooksByIsbn(value: String): List<Book>

    @Query("SELECT b FROM Book b WHERE b._readAlready = ?1")
    fun searchBooksByIsRead(value: Boolean): List<Book>

    @Query("SELECT b FROM Book b WHERE b._id = ?1")
    fun searchBooksById(value: Int): List<Book>
}