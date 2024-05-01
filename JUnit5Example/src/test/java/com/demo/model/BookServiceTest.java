package com.demo.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    @Test
    @DisplayName("Adding books JUnit")
    void assertEqualsWithNoMessage(){
        BookService bookService = new BookService();

        Book book1 = new Book("1","Java","Shiv");
        Book book2 = new Book("2","Java","Patel");
        Book book3 = new Book("3","Python","Shiv");

        bookService.addBook(book1);
        bookService.addBook(book2);
        bookService.addBook(book3);

        Book actualBookTest = bookService.getBookById("1");

        assertEquals("1",actualBookTest.getBookId());
        assertEquals("Java",actualBookTest.getTitle());

    }

    @Test
    void assertEqualsWithMessage(){
        BookService bookService = new BookService();

        Book book1 = new Book("1","Java","Shiv");
        Book book2 = new Book("2","Java","Patel");
        Book book3 = new Book("3","Python","Shiv");

        bookService.addBook(book1);
        bookService.addBook(book2);
        bookService.addBook(book3);

        Book actualBookTest = bookService.getBookById("1");

        assertEquals("1",actualBookTest.getBookId());
        assertEquals("Java",actualBookTest.getTitle(),"Did not match the Title");

    }

    @Test
    @DisplayName("Checking Array Assert")
    void assertEqualsWithArray(){
        BookService bookService = new BookService();

        Book book1 = new Book("1","Java","Shiv");
        Book book2 = new Book("2","Java","Patel");
        Book book3 = new Book("3","Python","Shiv");

        bookService.addBook(book1);
        bookService.addBook(book2);
        bookService.addBook(book3);

        String[] bookTitlesByAuthor = bookService.getBookIdsByPublisher("Shiv");

        assertArrayEquals(new String[] {"1","3"}, bookTitlesByAuthor);

    }

}