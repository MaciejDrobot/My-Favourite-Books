package dev.mdrobot.booksinfoservice.controller;

import com.fasterxml.jackson.databind.JsonNode;
import dev.mdrobot.booksinfoservice.model.BookInfo;
import dev.mdrobot.booksinfoservice.service.BookInfoProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/getBook")
public class Controller {

    private final BookInfoProvider bookInfoProvider;


    public Controller(@Autowired BookInfoProvider bookInfoProvider) {
        this.bookInfoProvider = bookInfoProvider;
    }

    @GetMapping
    @RequestMapping("/{query}")
    public List<BookInfo> getBooks(@PathVariable("query") String query){
        JsonNode response = bookInfoProvider.getBookResponse(query);
        return bookInfoProvider.getBookInfo(response);
    }
}
