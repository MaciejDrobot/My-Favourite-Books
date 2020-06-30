package dev.mdrobot.booksapifeignclient.controller;

import dev.mdrobot.booksapifeignclient.model.BookInfo;
import dev.mdrobot.booksapifeignclient.service.BooksApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
public class BookInfoController {

    @Autowired
    private BooksApiService service;

    @GetMapping("/find/{q}")
    public ResponseEntity<List<BookInfo>> bookQuery(@PathVariable("q") String query){
        List<BookInfo> allBooks = service.getBooks(query);
        Link link = (linkTo(BookInfoController.class)
                .slash("find")
                .slash("q")
                .withSelfRel());
        //Resources<BookInfo> resource = new Resource(allBooks, link);

        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }

}
