/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trongnt.dto;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class BookDTO implements Serializable {

    String bookID;
    String bookName;
    String image;
    String author;
    String description;
    int price;
    String categoryID;
    String dateAdded;
    int quantity;
    boolean status;

    public BookDTO(String bookID, String bookName, String image, String author, String description, int price, String categoryID, String dateAdded, int quantity, boolean status) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.image = image;
        this.author = author;
        this.description = description;
        this.price = price;
        this.categoryID = categoryID;
        this.dateAdded = dateAdded;
        this.quantity = quantity;
        this.status = status;
    }

    public BookDTO(String bookID, String bookName, String image, String author, String description, int price, String categoryID, int quantity) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.image = image;
        this.author = author;
        this.description = description;
        this.price = price;
        this.categoryID = categoryID;
        this.quantity = quantity;
    }

   
    

    public String getBookID() {
        return bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public String getImage() {
        return image;
    }

    public String getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
