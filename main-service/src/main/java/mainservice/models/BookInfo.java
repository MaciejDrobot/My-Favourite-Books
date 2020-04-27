package mainservice.models;

import java.util.List;

public class BookInfo {

    private String author;
    private String title;

    public BookInfo() {
    }

    public BookInfo(List<String> authors, String author, String title) {
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
