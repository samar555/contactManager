package com.app.contactapp.controllers;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.contactapp.Repository.UserRepository;
import com.app.contactapp.entites.user;
import com.app.contactapp.helper.ShowingMessage;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class home {
    @Autowired
    private UserRepository userrepo;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/")
    public String homeController(Model model) {

        System.out.println("running controllers");
        model.addAttribute("title", "home-contact manager");
        user User = new user();
        User.setAbout("this is about test");
        User.setName("sachin");
        User.setEmail("sachin.mshrvi@gmail.com");
        User.setContacts(null);
        User.setEnable(false);
        User.setRole("simple user");
        User.setImageUrl(null);
        // UserREpository.save(User);

        return "home";
    }

    @GetMapping("/about")
    public String aboutController(Model model) {
        System.out.println("running about page");
        model.addAttribute("title", "about-contact manager");
        return "about";
    }

    @GetMapping("/user-registration")
    private String userRegistrationForm(Model model) {
        model.addAttribute("user", new user());
        System.out.println("runnig user registration");
        model.addAttribute("title", "user-Registration");
        return "userRegister";
    }

    @GetMapping("/blogs")
    private String userblog(Model model) {
        System.out.println("running blogging handler");
        model.addAttribute("title", "All-Blogs");

        return "blogs";
    }

    // saving new user
    @PostMapping("/registering")
    private String userRegistering(@Valid @ModelAttribute("user") user User, BindingResult result, HttpSession session,
            @RequestParam(value = "checkbox", defaultValue = "false") boolean checkbox, Model model) {
        try {
            if (!checkbox) {
                System.out.println("not accepted terms and condition");
                throw new Exception("not accepted terms and condition");
            }
            if (result.hasErrors()) {
                System.out.println("server side validation error");
                System.out.println(result);
                model.addAttribute("user", User);
                return "userRegister";
            }
            System.out.println(User);
            System.out.println(checkbox);
            User.setRole("ROLE_USER");
            User.setPassword(bCryptPasswordEncoder.encode(User.getPassword()));
            User.setImageUrl("default.png");
            User.setEnable(false);
            userrepo.save(User);
            session.setAttribute("message", new ShowingMessage("Registered successfully !!", "alert-success"));

            model.addAttribute("name", "User-Home");
            return "userRegister";
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("message",
                    new ShowingMessage("Something Went Wrong  " + e.getMessage(), "alert-danger"));
            model.addAttribute("user", User);
            return "userRegister";
        }

    }

    @GetMapping("/login")
    private String getCustomLogInPage() {

        return "login";
    }

}
