/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.book;

import java.io.Serializable;

/**
 *
 * @author HP
 */
public class BookDTO implements Serializable{
    private String bookID;
    private String name;
    private String type;
    private String image;
    private int price;
    private boolean status;

    public BookDTO() {
    }

    public BookDTO(String bookID, String name, String type, String image, int price, boolean status) {
        this.bookID = bookID;
        this.name = name;
        this.type = type;
        this.image = image;
        this.price = price;
        this.status = status;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

   

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
