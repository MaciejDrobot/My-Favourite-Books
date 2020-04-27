package dev.mdrobot.booksapifeignclient.controller;

import dev.mdrobot.booksapifeignclient.model.BookInfo;
import dev.mdrobot.booksapifeignclient.service.BooksApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookInfoController {

    @Autowired
    private BooksApiService service;

    @GetMapping("/find")
    public List<BookInfo> bookQuery(@RequestParam("q") String query){
        return  service.getBooks(query);
    }
}
