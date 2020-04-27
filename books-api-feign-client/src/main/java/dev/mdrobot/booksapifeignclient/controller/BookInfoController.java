package dev.mdrobot.booksapifeignclient.controller;

import dev.mdrobot.booksapifeignclient.model.Item;
import dev.mdrobot.booksapifeignclient.service.BooksApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookInfoController {

    @Autowired
    private BooksApiService service;

    @Value("${books.api.key}")
    private String key;

    @GetMapping("/find")
    public List<Item> bookQuery(@RequestParam("query") String query, String key){
        return  service.getBooks(query, key);
    }
}
