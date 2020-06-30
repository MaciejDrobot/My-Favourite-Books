package dev.mdrobot.databaseSQLservice.controller;

import dev.mdrobot.databaseSQLservice.model.MyBook;
import dev.mdrobot.databaseSQLservice.service.MyFavouriteBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RequestMapping("/books")
@RestController
public class DatabaseController {

    @Autowired
    MyFavouriteBookRepository repository;


    @GetMapping("/all")
    public ResponseEntity<List<MyBook>> retrieveAllBooks() {
        List<MyBook> allBooks = createDeleteLink(repository.findAll());
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }

    @GetMapping("/byAuthor/{author}")
    public ResponseEntity <List<MyBook>> retrieveByAuthor(@PathVariable("author") String author){
        List<MyBook> allBooks = createDeleteLink(repository.findByAuthor(author));
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }

    @GetMapping("/byTitle/{title}")
    public ResponseEntity <List<MyBook>> retrieveByTitle(@PathVariable("title") String title){
        List<MyBook> allBooks = createDeleteLink(repository.findByTitle(title));
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @PostMapping("/create")
    public void createBook(@RequestBody MyBook book) {
        repository.save(book);
    }

    @PutMapping("/update/{id}/rating/{rating}")
    public void updateRating(@PathVariable("id") Integer id, @PathVariable("rating") int newRating) {
        Optional<MyBook> updatedRating = repository.findById(id);
        updatedRating.get().setRating(newRating);
        repository.save(updatedRating.get());
    }


    public List<MyBook> createDeleteLink(List<MyBook> list){
        list.forEach(myBook -> myBook.add(linkTo(DatabaseController.class)
                .slash("delete")
                .slash(myBook.getId())
                .withSelfRel()
                .withType("DELETE")));
        return list;
    }

}
