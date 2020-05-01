package dev.mdrobot.databaseSQLservice.service;

import dev.mdrobot.databaseSQLservice.model.MyFavouriteBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MyFavouriteBookRepository extends JpaRepository<MyFavouriteBook, Integer> {

    @Query(value = "SELECT m FROM MyFavouriteBook m WHERE author = ?1")
    List<MyFavouriteBook> findByAuthor(String author);

    @Query(value = "SELECT m FROM MyFavouriteBook m WHERE title = ?1")
    List<MyFavouriteBook> findByTitle(String title);
}
