package dev.mdrobot.databaseSQLservice.service;

import dev.mdrobot.databaseSQLservice.model.MyFavouriteBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface MyFavouriteBookRepository extends JpaRepository<MyFavouriteBook, Integer> {
}
