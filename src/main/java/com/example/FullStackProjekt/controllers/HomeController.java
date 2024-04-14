package com.example.FullStackProjekt.controllers;


import com.example.FullStackProjekt.models.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model){
        Person person = new Person();
        person.setId(12);
        person.setFirstName("John");
        person.setLastName("Smith");

        model.addAttribute("id",person.getId());
        model.addAttribute("firstName",person.getFirstName());
        model.addAttribute("lastName",person.getLastName());

        Person anotherPerson = new Person();
        anotherPerson.setId(13);
        anotherPerson.setFirstName("Jane");
        anotherPerson.setLastName("Smith");


        model.addAttribute("anotherPerson",anotherPerson);
        return "home/index";
    }
}
