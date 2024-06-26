package com.example.FullStackProjekt.wishlistproject.model;

public class WishList {

    private int listID;
    @lombok.Getter
    private String listName;
    @lombok.Getter
    private String listImageURL;
    private int userID;

    public WishList(int listID, String listName, String listImageURL) {
        this.listID = listID;
        this.listName = listName;
        this.listImageURL = listImageURL;
        this.userID = userID;
    }

    public WishList() {

    }

    public int getListID() {
        return listID;
    }

    public int getUserID() {
        return userID;
    }

    public void setListID(int listID) {
        this.listID = listID;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public void setListImageURL(String listImageURL) {
        this.listImageURL = listImageURL;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "listID=" + listID +
                ", listName='" + listName + '\'' +
                ", listImageURL='" + listImageURL + '\'' +
                ", userID=" + userID +
                '}';
    }
}