package com.example.library.library

import javax.persistence.*

@Entity
@Table
data class Book(
    @Id
    @SequenceGenerator(
        name = "book_sequence",
        sequenceName = "book_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "book_sequence"
    )
    private var _id: Int? = null,
    private var _title: String,
    private var _description: String,
    private var _author: String,
    private var _isbn: String,
    private var _printYear: Int,
    private var _readAlready: Boolean
) {

    var id: Int? get() = _id
        set(value) {
            _id = value
        }
    var title: String get() = _title
        set(value) {
            _title = value
        }
    var description: String get() = _description
        set(value) {
            _description = value
        }
    var author: String get() = _author
        set(value) {
            _author = value
        }
    var isbn: String get() = _isbn
        set(value) {
            _isbn = value
        }
    var printYear: Int get() = _printYear
        set(value) {
            _printYear = value
        }
    var readAlready: Boolean get() = _readAlready
        set(value) {
            _readAlready = value
        }

    override fun toString(): String {
        return "Book{" +
                "id=$_id" +
                ", title=$_title" +
                ", description=$_description" +
                ", author=$_author" +
                ", isbn='$_isbn" +
                ", printYear=$_printYear" +
                ", readAlready=$_readAlready" +
                "}"
    }


}