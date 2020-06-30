package dev.mdrobot.booksapifeignclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookInfo extends RepresentationModel {

    private String title;
    private String author;
}
