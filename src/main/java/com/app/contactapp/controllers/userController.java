package com.app.contactapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.web.exchanges.HttpExchange.Principal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.contactapp.Repository.UserRepository;
import com.app.contactapp.entites.user;


@Controller
@RequestMapping("/user")
public class userController {
  @Autowired
  UserRepository repo;
    @RequestMapping("/index")
    public String userDeshBoared(Model model){
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      String currentPrincipalName = authentication.getName();
      model.addAttribute("name", currentPrincipalName);
      user user=repo.findUserByName(currentPrincipalName);
      System.out.println("user name " +currentPrincipalName);
      model.addAttribute("name", user);
        return "normalUsers/userDeshBoared";
    }
}
