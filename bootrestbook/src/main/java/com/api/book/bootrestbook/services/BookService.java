package com.api.book.bootrestbook.services;

import com.api.book.bootrestbook.entities.Book;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookService {
    private static List<Book> list = new ArrayList<>();
    static {
        list.add(new Book(1, "Java", "Code with harry"));
        list.add(new Book(2, "Python", "durgesh"));
        list.add(new Book(3, "C++", "Kunal"));
    }
    // get all books
    public List<Book> getAllBooks()
    {
        return list;
    }
//    GET single book
    public Book getBookById(int id){
        Book book = null;
        try {
            book = list.stream().filter(e -> e.getId() == id).findFirst().get();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    return book;
}
//  Adding the book--->>
    public Book addBook(Book b){
        list.add(b);
        return b;

    }
//    Delete a book--->>
    public void deleteBook(int bookId){
    list=list.stream().filter(book->{
        if(book.getId()!=bookId)
        {
            return true;
        }else {
            return false;
        }
    }).collect(Collectors.toList());
    }
//    UPdate the Book
    public void updateBook(Book book,int bookId){
        list= list.stream().map(b->{
        if (b.getId()==bookId){
            b.setTitle(book.getTitle());
            b.setAuthor(book.getAuthor());
            b.setId(book.getId());
        }
            return b;
        }).collect(Collectors.toList());
    }
}
