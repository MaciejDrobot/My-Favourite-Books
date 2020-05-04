package dev.mdrobot.databaseSQLservice.service;

import dev.mdrobot.databaseSQLservice.model.MyBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MyFavouriteBookRepository extends JpaRepository<MyBook, Integer> {

    @Query(value = "SELECT m FROM MyBook m WHERE author = ?1")
    List<MyBook> findByAuthor(String author);

    @Query(value = "SELECT m FROM MyBook m WHERE title = ?1")
    List<MyBook> findByTitle(String title);
}
