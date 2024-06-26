package com.example.FullStackProjekt.wishlistproject.controller;

import com.example.FullStackProjekt.wishlistproject.model.User;
import com.example.FullStackProjekt.wishlistproject.model.Wish;
import com.example.FullStackProjekt.wishlistproject.model.WishList;
import com.example.FullStackProjekt.wishlistproject.service.WishListService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/wishlist")
public class WishListController {

    private WishListService wishlistService;

    public WishListController(WishListService wishlistService) {
        this.wishlistService = wishlistService;
    }

    private boolean isLoggedIn(HttpSession session) {
        return session.getAttribute("user") != null;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session and return to login page
        session.invalidate();
        return "index";
    }


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/") // index is loginPage
    public String index(@RequestParam("userName") String userName,
                        @RequestParam("userPassword") String userPassword,
                        HttpSession session,
                        Model model)
    {
        // find user in repo - return loggedIn if succes
        User user = wishlistService.getUser(userName);
        if (user != null)
            if (user.getUserPassword().equals(userPassword)) {
                // create session for user and set session timeout to 30 sec (container default: 15 min)
                session.setAttribute("user", user);
                session.setMaxInactiveInterval(300);
                return "frontpage";
            }
        // wrong login info
        model.addAttribute("wrongLoginInfo", true);
        return "index";
    }

    @GetMapping("/frontpage")
    public String frontPage(HttpSession session) {
        return isLoggedIn(session) ? "frontpage" : "index";
    }

    @GetMapping("/youraccount")
    public String yourAccount(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        user = wishlistService.getUserById(user.getUserID());
        model.addAttribute("user", user);
        return isLoggedIn(session) ? "accountinfo" : "index";
    }

    @PostMapping("/youraccount/delete")
    public String deleteAccount(HttpSession session, @RequestParam("id") int id) {
        wishlistService.deleteAccount(id);
        session.invalidate();
        return "redirect:/wishlist/";
    }

    @GetMapping("/youraccount/edit/{id}")
    public String editAccount(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        user = wishlistService.getUserById(user.getUserID());
        model.addAttribute("user", user);
        return "editaccount";
    }

    @PostMapping("youraccount/edit/{id}")
    public String editedAccount(HttpSession session, User editedUser) {
        User user = (User) session.getAttribute("user");
        wishlistService.editAccount(user.getUserID(), editedUser);
        return "redirect:/wishlist/youraccount";
    }

    @GetMapping("/createwish")
    public String createWish(Model model, HttpSession session) {
        Wish wish = new Wish();
        User user = (User) session.getAttribute("user");

        model.addAttribute("wish", wish);
        model.addAttribute("wishlists", wishlistService.getWishlists(user.getUserID()));
        return isLoggedIn(session) ? "createWish" : "index";
    }

    @PostMapping("/createwish")
    public String createdWish(@ModelAttribute("wish") Wish wish, HttpSession session) {
        wishlistService.createWish(wish);
        return "redirect:/wishlist/seewishlists";
    }

    @GetMapping("/seewishes/{listid}")
    public String seeWishes(Model model, HttpSession session, @PathVariable int listid) {
        model.addAttribute("wishes", wishlistService.getWishes(listid));
        return isLoggedIn(session) ? "wishes" : "index";
    }

    @PostMapping("/deletewish")
    public String deleteWish(@RequestParam("id") int id) {
        wishlistService.deleteWish(id);
        return "redirect:/wishlist/seewishes";

    }

    @GetMapping("/edit/wish/{id}")
    public String editWish(@PathVariable int id, Model model, HttpSession session) {
        Wish wish = wishlistService.findWishById(id);
        User user = (User) session.getAttribute("user");
        model.addAttribute("wish", wish);
        model.addAttribute("wishlists", wishlistService.getWishlists(user.getUserID()));
        return "editWish";
    }

    @PostMapping("/edit/wish/{id}")
    public String editedWish(@PathVariable int id, @ModelAttribute Wish editedWish) {
        wishlistService.editWish(id, editedWish);
        return "redirect:/wishlist/seewishes";
    }

    @GetMapping("/createuser")
    public String createUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "createUser";
    }

    @PostMapping("/createuser")
    public String createdUser(@ModelAttribute("user") User user) {
        wishlistService.createUser(user);
        return "createUserSuccess";
    }

    @GetMapping("/seewishlists")
    public String seeWishlists(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            model.addAttribute("wishlists", wishlistService.getWishlists(user.getUserID()));
            return "wishlists";
        } else {
            return "redirect:/wishlist/frontpage";
        }
    }

    @GetMapping("/createwishlist")
    public String createWishlist(Model model, HttpSession session) {
        WishList wishlist = new WishList();
        model.addAttribute("wishlist", wishlist);

        return isLoggedIn(session) ? "createWishlist" : "index";
    }

    @PostMapping("/createwishlist")
    public String createdWishlist(@ModelAttribute("wishlist") WishList wishlist,
                                  HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            wishlistService.createWishlist(user.getUserID(), wishlist);
            return "redirect:/wishlist/seewishlists";
        } else {
            return "redirect:/wishlist/createWishlist";
        }
    }

    @GetMapping("/edit/wishlist/{listid}")
    public String editWishlist(@PathVariable int listid, Model model) {
        WishList wishlist = wishlistService.findWishListById(listid);
        model.addAttribute("wishlist", wishlist);
        return "editWishlist";
    }

    @PostMapping("/edit/wishlist/{listid}")
    public String editedWishlist(@PathVariable int listid, @ModelAttribute WishList editedWishlist) {
        wishlistService.editWishlist(listid, editedWishlist);
        return "redirect:/wishlist/seewishlists";
    }

    @PostMapping("/deletewishlist")
    public String deleteWishlist(@RequestParam("id") int id) {
        wishlistService.deleteWishlist(id);
        return "redirect:/wishlist/seewishlists";
    }

    @GetMapping("/SuccessSeeLists")
    public String seeWishlists(HttpSession session) {
        return isLoggedIn(session) ? "SuccessSeeLists" : "index";
    }



}