package com.example.FullStackProjekt.wishlistproject.service;

import com.example.FullStackProjekt.wishlistproject.model.Wish;
import com.example.FullStackProjekt.wishlistproject.model.WishList;
import com.example.wishlistproject.dto.WishDTO;
import com.example.wishlistproject.dto.wishlistDTO;
import com.example.FullStackProjekt.wishlistproject.model.User;
import com.example.wishlistproject.model.Wishlist;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListService {

    private com.example.wishlistproject.repositories.WishListRepositoryDB wishlistRepositoryDB;

    public WishListService(com.example.wishlistproject.repositories.WishListRepositoryDB wishlistRepositoryDB) {
        this.wishlistRepositoryDB = wishlistRepositoryDB;
    }

    public void createWish(Wish wish) {
        wishlistRepositoryDB.createWish(wish);
    }

    public void deleteWish(int id) {
        wishlistRepositoryDB.deleteWish(id);
    }

    public Wish findWishById(int id) {
        return wishlistRepositoryDB.findWishById(id);
    }

    public void editWish(int id, Wish editedWish) {
        wishlistRepositoryDB.editWish(id, editedWish);
    }

    public void createUser(User user) {
        wishlistRepositoryDB.createUser(user);
    }

    public void createWishlist(int id, WishList wishlist) {
        wishlistRepositoryDB.createWishlist(id, wishlist);
    }

    public WishList findWishListById(int listid) {
        return wishlistRepositoryDB.findWishListById(listid);
    }

    public void editWishlist(int listid, wishlistDTO editedWishlist) {
        wishlistRepositoryDB.editWishlist(listid,editedWishlist);
    }

    public List<WishDTO> getWishes(int listid) {
        return wishlistRepositoryDB.getWishes(listid);
    }

  /*  public boolean checkLogin(String username, String password) {
        return wishlistRepositoryDB.checkLogin(username, password);
    }*/

    public User getUser(String uid) {
        return wishlistRepositoryDB.getUser(uid);
    }

    public User getUserById(int id) {
        return wishlistRepositoryDB.getUserById(id);
    }

    public void deleteAccount(int id) {
        wishlistRepositoryDB.deleteAccount(id);
    }

    public void editAccount(int id, User editedUser) {
        wishlistRepositoryDB.editAccount(id, editedUser);
    }

    public void deleteWishlist(int id) {
        wishlistRepositoryDB.deleteWishlist(id);
    }
    public List<wishlistDTO> getWishlists(int id) {
        return wishlistRepositoryDB.getWishlists(id);
    }

}