package com.example.quanlythuvien.model;

public class Information_BorrowBook {
    private int ordinalNumbers;
    private String bookId;
    private String bookName;
    private String category;
    private String author;

    public Information_BorrowBook(int ordinalNumbers, String bookId, String bookName, String category, String author) {
        this.ordinalNumbers = ordinalNumbers;
        this.bookId = bookId;
        this.bookName = bookName;
        this.category = category;
        this.author = author;
    }

    public Information_BorrowBook() {

    }

    public int getOrdinalNumbers() {
        return ordinalNumbers;
    }

    public void setOrdinalNumbers(int ordinalNumbers) {
        this.ordinalNumbers = ordinalNumbers;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
