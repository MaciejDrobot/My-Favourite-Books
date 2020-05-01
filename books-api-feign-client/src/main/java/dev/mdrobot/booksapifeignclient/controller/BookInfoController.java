package dev.mdrobot.booksapifeignclient.controller;

import dev.mdrobot.booksapifeignclient.model.BookInfo;
import dev.mdrobot.booksapifeignclient.service.BooksApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookInfoController {

    @Autowired
    private BooksApiService service;

    @GetMapping("/find/{q}")
    public List<BookInfo> bookQuery(@PathVariable("q") String query){
        return  service.getBooks(query);
    }

}
