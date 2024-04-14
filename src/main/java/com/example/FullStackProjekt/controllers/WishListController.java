package com.example.FullStackProjekt.controllers;


import com.example.FullStackProjekt.models.Person;
import com.example.FullStackProjekt.wishlist.Wish;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WishListController {

    @GetMapping("/")
    public String index(Model model){
        Wish wish = new Wish();
        wish.setWishId(1);
        wish.setWishTekst("jeg vil havde en durum");


        model.addAttribute("id", wish.getWishId());
        model.addAttribute("wish tekst", wish.getWishTekst());


        Wish anotherWish = new Wish();
        anotherWish.setWishId(2);
        anotherWish.setWishTekst("Jeg vil havde en ekstra stor durum fra zeynos");


        model.addAttribute("anotherWish",anotherWish);
        return "home/index";
    }
}