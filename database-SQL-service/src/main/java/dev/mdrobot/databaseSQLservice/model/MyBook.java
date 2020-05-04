package dev.mdrobot.databaseSQLservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class MyBook extends RepresentationModel {

    @Id
    @GeneratedValue
    private Integer id;

    private String author;
    private String title;
    private int rating;
}
