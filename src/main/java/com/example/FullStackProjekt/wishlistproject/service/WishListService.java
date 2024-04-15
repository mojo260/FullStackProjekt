package com.example.FullStackProjekt.wishlistproject.service;

import com.example.FullStackProjekt.wishlistproject.model.User;
import com.example.FullStackProjekt.wishlistproject.model.Wish;
import com.example.FullStackProjekt.wishlistproject.model.WishList;
import com.example.FullStackProjekt.wishlistproject.repositories.WishListRepositoryDB;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WishListService {

    private WishListRepositoryDB wishlistRepositoryDB;

    public WishListService(WishListRepositoryDB wishlistRepositoryDB) {
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

    public void editWishlist(int listid, WishList editedWishlist) {
        wishlistRepositoryDB.editWishlist(listid,editedWishlist);
    }

    public List<Wish> getWishes(int listid) {
        return wishlistRepositoryDB.getWishes(listid);
    }

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
    public List<WishList> getWishlists(int id) {
        return wishlistRepositoryDB.getWishlists(id);
    }
}