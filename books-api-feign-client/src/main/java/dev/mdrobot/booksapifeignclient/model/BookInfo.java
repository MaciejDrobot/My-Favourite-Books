package dev.mdrobot.booksapifeignclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookInfo {

    private String title;
    private String author;
}
