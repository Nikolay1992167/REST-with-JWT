package by.it.restjwt.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static by.it.restjwt.utils.Constants.SECURITY_SWAGGER;

@RestController
@RequestMapping("/main")
@SecurityRequirement(name = SECURITY_SWAGGER)
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
