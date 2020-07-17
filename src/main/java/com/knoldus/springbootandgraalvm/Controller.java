package com.knoldus.springbootandgraalvm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class Controller {
    static List<String> users = new ArrayList<>();
    
    {
        users.add("Sharma-Prashant");
    }
    
    @GetMapping("/admin")
    public String getAdminGreet() {
        return "Greetings, admins = " + users;
    }
    
    @PostMapping("/admin/{name}")
    public String addAdmin(@PathVariable String name) {
        users.add(name);
        return "User added, greetings to all admins = " + users;
    }
}
