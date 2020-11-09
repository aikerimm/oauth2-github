package kz.aikerimm.oauth;

import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping(path = "/hello")
    public String hello(@CurrentSecurityContext(expression = "authentication.name") String name) {
        return "Hello, " + name + "@Github!";
    }
}
