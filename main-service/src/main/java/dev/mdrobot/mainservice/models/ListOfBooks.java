package dev.mdrobot.mainservice.models;

import java.util.List;

public class ListOfBooks {

    private List<BookInfo> listOfBooks;

    public ListOfBooks() {
    }

    public ListOfBooks(List<BookInfo> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

    public List<BookInfo> getListOfBooks() {
        return listOfBooks;
    }

    public void setListOfBooks(List<BookInfo> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }
}
