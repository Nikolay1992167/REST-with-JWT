package by.it.restjwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class MainController {

    @GetMapping("/unsecurity")
    public String getUnsecurityPage(){
        return "Unsecurity page!";
    }

    @GetMapping("/security")
    public String getSecurityPage(){
        return "Security page!";
    }

    @GetMapping("/admin")
    public String getAdminPage(){
        return "Admin page!";
    }
}
