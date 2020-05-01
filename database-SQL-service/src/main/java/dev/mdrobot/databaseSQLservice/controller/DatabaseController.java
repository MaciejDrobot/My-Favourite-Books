package dev.mdrobot.databaseSQLservice.controller;

import dev.mdrobot.databaseSQLservice.model.MyFavouriteBook;
import dev.mdrobot.databaseSQLservice.service.MyFavouriteBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/books")
@RestController
public class DatabaseController {

    @Autowired
    MyFavouriteBookRepository repository;


    @GetMapping("/all")
    public List<MyFavouriteBook> retrieveAllBooks() {
        return repository.findAll();
    }

    @GetMapping("/byAuthor/{author}")
    public List<MyFavouriteBook> retrieveByAuthor(@PathVariable("author") String author){
        return repository.findByAuthor(author);
    }

    @GetMapping("/byTitle/{title}")
    public List<MyFavouriteBook> retrieveByTitle(@PathVariable("title") String title){
        return repository.findByAuthor(title);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @PostMapping("/create")
    public void createBook(@Valid @RequestBody MyFavouriteBook book) {
        repository.save(book);
    }


}
